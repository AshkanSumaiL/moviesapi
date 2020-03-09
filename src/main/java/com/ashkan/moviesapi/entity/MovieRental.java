package com.ashkan.moviesapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "movie_rental", schema = "moviedb", catalog = "")
public class MovieRental {
    private int movieRentalId;
    private int movieId;
    private int memberId;
    private Timestamp date;
    private Timestamp toReturnDate;
    private Timestamp returnedDate;
    private String status;
    @JsonIgnore
    private Movie movieByMovieId;
    @JsonIgnore
    private Member memberByMemberId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "movie_rental_id")
    public int getMovieRentalId() {
        return movieRentalId;
    }

    public void setMovieRentalId(int movieRentalId) {
        this.movieRentalId = movieRentalId;
    }

    @Basic
    @Column(name = "movie_id",insertable = false,updatable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "member_id",insertable = false,updatable = false)
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "to_return_date")
    public Timestamp getToReturnDate() {
        return toReturnDate;
    }

    public void setToReturnDate(Timestamp toReturnDate) {
        this.toReturnDate = toReturnDate;
    }

    @Basic
    @Column(name = "returned_date")
    public Timestamp getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Timestamp returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieRental that = (MovieRental) o;
        return movieRentalId == that.movieRentalId &&
                movieId == that.movieId &&
                memberId == that.memberId &&
                Objects.equals(date, that.date) &&
                Objects.equals(toReturnDate, that.toReturnDate) &&
                Objects.equals(returnedDate, that.returnedDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieRentalId, movieId, memberId, date, toReturnDate, returnedDate, status);
    }

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    public Movie getMovieByMovieId() {
        return movieByMovieId;
    }

    public void setMovieByMovieId(Movie movieByMovieId) {
        this.movieByMovieId = movieByMovieId;
    }

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
    public Member getMemberByMemberId() {
        return memberByMemberId;
    }

    public void setMemberByMemberId(Member memberByMemberId) {
        this.memberByMemberId = memberByMemberId;
    }
}
