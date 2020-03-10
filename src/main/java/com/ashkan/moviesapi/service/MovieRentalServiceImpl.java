package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.DTO.MovieRentalPatchDTO;
import com.ashkan.moviesapi.constants.constants;
import com.ashkan.moviesapi.dao.*;
import com.ashkan.moviesapi.entity.*;
import com.ashkan.moviesapi.exception.BadRequest.MovieRentalBadRequestException;
import com.ashkan.moviesapi.exception.NotFound.MemberNotFoundException;
import com.ashkan.moviesapi.exception.NotFound.MovieRentalNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    private ModelMapper modelMapper;



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

        MovieCatalog movieCatalog=movieCatalogRepository.findById(movieRental.getMovieId())
                .orElseThrow(() -> new RuntimeException("Movie catalog not found "+movieRental.getMovieId()));

        Timestamp currentDate=new Timestamp(System.currentTimeMillis());
        Timestamp returnDate=new Timestamp(System.currentTimeMillis()+ constants.DAYS_TO_ADD);

        movieRental.setMovieByMovieId(movie);
        movieRental.setMemberByMemberId(member);
        movieRental.setDate(currentDate);
        movieRental.setToReturnDate(returnDate);
        movieRental.setStatus("Rented");
        movieCatalog.setCopies(movieCatalog.getCopies()-1);
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

        MovieCatalog movieCatalogFind=movieCatalogRepository.findById(movieRentalFind.getMovieId())
                .orElseThrow(()->new RuntimeException("Movie Catalog not found"+movieRentalFind.getMovieId()));

        if(movieRentalFind.getStatus()==null){
            throw new RuntimeException("This movie needs to be rented before been returned!");
        }

        if(movieRental.getStatus().equals("Returned")){
            movieRentalFind.setStatus("Returned");
            movieRentalFind.setReturnedDate(new Timestamp(System.currentTimeMillis()));
            movieCatalogFind.setCopies(movieCatalogFind.getCopies()+1);
        }else{
            throw new MovieRentalBadRequestException(theId);
        }

        save(movieRentalFind);
    }


}
