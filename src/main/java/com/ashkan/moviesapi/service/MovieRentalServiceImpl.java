package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.constants.constants;
import com.ashkan.moviesapi.dao.*;
import com.ashkan.moviesapi.entity.*;
import com.ashkan.moviesapi.exception.BadRequest.MovieRentalBadRequestException;
import com.ashkan.moviesapi.exception.NotFound.MemberNotFoundException;
import com.ashkan.moviesapi.exception.NotFound.MovieRentalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class MovieRentalServiceImpl implements  MovieRentalService{
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
        this.movieRepository=movieRepository;
        this.memberRepository=memberRepository;
        this.movieCatalogRepository=movieCatalogRepository;

    }

    @Override
    public List<MovieRental> findAll() {
        return movieRentalRepository.findAll();
    }

    @Override
    public MovieRental findById(int theId) {
        return  movieRentalRepository.findById(theId)
                .orElseThrow(()->new MovieRentalNotFoundException(theId));
    }

    @Override
    public void save(MovieRental movieRental) {
        Movie movie = movieRepository.findById(movieRental.getMovieId())
                .orElseThrow(()->new MovieRentalNotFoundException(movieRental.getMovieId()));

        Member member = memberRepository.findById(movieRental.getMemberId())
                .orElseThrow(()->new MovieRentalNotFoundException(movieRental.getMemberId()));


        Timestamp currentDate=new Timestamp(System.currentTimeMillis());
        Timestamp returnDate=new Timestamp(System.currentTimeMillis()+ constants.DAYS_TO_ADD);

        movieRental.setMovieByMovieId(movie);
        movieRental.setMemberByMemberId(member);
        movieRental.setDate(currentDate);
        movieRental.setToReturnDate(returnDate);
        movieRentalRepository.save(movieRental);
    }

    @Override
    public void deleteById(int theId) {
        movieRentalRepository.deleteById(theId);
    }

    @Override
    public void patchStatus(MovieRental movieRental,int theId) {
        MovieRental movieRentalFind= movieRentalRepository.findById(theId)
                .orElseThrow(()->new MovieRentalNotFoundException(theId));

        if(movieRentalFind.getStatus()!=null){
            throw new RuntimeException("This movie has already an status assigned!");
        }

        if(movieRental.getStatus().equals("Returned")){
            movieRentalFind.setStatus("Returned");
            movieRentalFind.setReturnedDate(new Timestamp(System.currentTimeMillis()));
        }else{
            throw new MovieRentalBadRequestException(theId);
        }

        MovieCatalog movieCatalogFind=movieCatalogRepository.findById(movieRentalFind.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie catalog not found "+movieRentalFind.getMovieId()));

        movieCatalogFind.setCopies(movieCatalogFind.getCopies()+1);

        save(movieRentalFind);
    }
}
