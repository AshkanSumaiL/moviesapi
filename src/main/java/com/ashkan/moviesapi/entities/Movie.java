package com.ashkan.moviesapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={ "id","description","registeringUser",
        "updatingUser","deleted","userId"}, allowSetters= true)
public class Movie {

    private int id;
    private String title;
    private Integer year;
    private String description;
    private String rate;
    private Integer registeringUser;
    private Integer updatingUser;
    private Byte deleted;
    private int userId;
    private Collection<ActorsInMovies> actorsInMoviesById;
    @JsonIgnore
    private User userByUserId;
    private Collection<MovieCatalog> movieCatalogsById;
    @JsonIgnore
    private Collection<MovieRental> movieRentalsById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Size(max = 50)
    @NotBlank
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @NotBlank
    @Size(max = 150)
    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rate")
    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "registering_user")
    public Integer getRegisteringUser() {
        return registeringUser;
    }

    public void setRegisteringUser(Integer registeringUser) {
        this.registeringUser = registeringUser;
    }

    @Basic
    @Column(name = "updating_user")
    public Integer getUpdatingUser() {
        return updatingUser;
    }

    public void setUpdatingUser(Integer updatingUser) {
        this.updatingUser = updatingUser;
    }

    @Basic
    @Column(name = "deleted")
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "user_id", insertable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                userId == movie.userId &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(rate, movie.rate) &&
                Objects.equals(registeringUser, movie.registeringUser) &&
                Objects.equals(updatingUser, movie.updatingUser) &&
                Objects.equals(deleted, movie.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, description, rate, registeringUser, updatingUser, deleted, userId);
    }

    @OneToMany(mappedBy = "movieByMovieId")
    public Collection<ActorsInMovies> getActorsInMoviesById() {
        return actorsInMoviesById;
    }

    public void setActorsInMoviesById(Collection<ActorsInMovies> actorsInMoviesById) {
        this.actorsInMoviesById = actorsInMoviesById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "movieByMovieId")
    public Collection<MovieCatalog> getMovieCatalogsById() {
        return movieCatalogsById;
    }

    public void setMovieCatalogsById(Collection<MovieCatalog> movieCatalogsById) {
        this.movieCatalogsById = movieCatalogsById;
    }

    @OneToMany(mappedBy = "movieByMovieId")
    public Collection<MovieRental> getMovieRentalsById() {
        return movieRentalsById;
    }

    public void setMovieRentalsById(Collection<MovieRental> movieRentalsById) {
        this.movieRentalsById = movieRentalsById;
    }
}
