package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.constants.constants;
import com.ashkan.moviesapi.repositories.MemberRepository;
import com.ashkan.moviesapi.repositories.MovieCatalogRepository;
import com.ashkan.moviesapi.repositories.MovieRentalRepository;
import com.ashkan.moviesapi.repositories.MovieRepository;
import com.ashkan.moviesapi.entities.Member;
import com.ashkan.moviesapi.entities.Movie;
import com.ashkan.moviesapi.entities.MovieCatalog;
import com.ashkan.moviesapi.entities.MovieRental;
import com.ashkan.moviesapi.exceptions.BadRequest.MovieRentalBadRequestException;
import com.ashkan.moviesapi.exceptions.BadRequest.MovieRentalBadRequestException_NoCopies;
import com.ashkan.moviesapi.exceptions.NotFound.MovieRentalNotFoundException;
import com.ashkan.moviesapi.services.interfaces.MovieRentalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MovieRentalServiceImpl implements MovieRentalService {
    private MovieRentalRepository movieRentalRepository;
    private MovieRepository movieRepository;
    private MemberRepository memberRepository;
    private MovieCatalogRepository movieCatalogRepository;

    @Autowired
    public MovieRentalServiceImpl(MovieRentalRepository movieRentalRepository,
                                  MovieRepository movieRepository,
                                  MemberRepository memberRepository,
                                  MovieCatalogRepository movieCatalogRepository) {
        this.movieRentalRepository = movieRentalRepository;
        this.movieRepository = movieRepository;
        this.memberRepository = memberRepository;
        this.movieCatalogRepository = movieCatalogRepository;
    }

    @Override
    public List<MovieRental> findAll() {
        return movieRentalRepository.findAll();
    }

    @Override
    public MovieRental findById(int id) {
        return movieRentalRepository.findById(id)
                .orElseThrow(() -> new MovieRentalNotFoundException(id));
    }

    @Override
    public void save(MovieRental movieRental) {
        Movie movie = movieRepository.findById(movieRental.getMovieId())
                .orElseThrow(() -> new MovieRentalNotFoundException(movieRental.getMovieId()));

        Member member = memberRepository.findById(movieRental.getMemberId())
                .orElseThrow(() -> new MovieRentalNotFoundException(movieRental.getMemberId()));

        MovieCatalog movieCatalog = movieCatalogRepository.findById(movieRental.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie catalog not found " + movieRental.getMovieId()));

        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        Timestamp returnDate = new Timestamp(System.currentTimeMillis() + constants.DAYS_TO_ADD);

        movieRental.setMovieByMovieId(movie);
        movieRental.setMemberByMemberId(member);
        movieRental.setDate(currentDate);
        movieRental.setToReturnDate(returnDate);
        movieRental.setStatus("Rented");

        if (movieCatalog.getCopies() > 0) {
            movieCatalog.setCopies(movieCatalog.getCopies() - 1);
        } else {
            throw new MovieRentalBadRequestException_NoCopies();
        }

        movieRentalRepository.save(movieRental);
    }

    @Override
    public void deleteById(int id) {
        movieRentalRepository.deleteById(id);
    }

    @Override
    public void patchStatus(MovieRental movieRental, int id) {
        MovieRental movieRentalFind = movieRentalRepository.findById(id)
                .orElseThrow(() -> new MovieRentalNotFoundException(id));

        MovieCatalog movieCatalogFind = movieCatalogRepository.findById(movieRentalFind.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie Catalog not found" + movieRentalFind.getMovieId()));

        if (movieRentalFind.getStatus() == null) {
            throw new RuntimeException("This movie needs to be rented before been returned!");
        }

        if (movieRental.getStatus().equals("Returned")) {
            movieRentalFind.setStatus("Returned");
            movieRentalFind.setReturnedDate(new Timestamp(System.currentTimeMillis()));
            movieCatalogFind.setCopies(movieCatalogFind.getCopies() + 1);
        } else {
            throw new MovieRentalBadRequestException();
        }
        movieRentalRepository.save(movieRentalFind);
    }


}
