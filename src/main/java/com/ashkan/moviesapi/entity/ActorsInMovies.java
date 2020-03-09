package com.ashkan.moviesapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actors_in_movies", schema = "moviedb", catalog = "")
public class ActorsInMovies {
    private int actorsInMoviesId;
    private int actorId;
    private int movieId;
    @JsonIgnore
    private Actor actorByActorId;
    @JsonIgnore
    private Movie movieByMovieId;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "actors_in_movies_id")
    public int getActorsInMoviesId() {
        return actorsInMoviesId;
    }

    public void setActorsInMoviesId(int actorsInMoviesId) {
        this.actorsInMoviesId = actorsInMoviesId;
    }

    @Basic
    @Column(name = "actor_id",insertable = false,updatable = false)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "movie_id",insertable = false,updatable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorsInMovies that = (ActorsInMovies) o;
        return actorsInMoviesId == that.actorsInMoviesId &&
                actorId == that.actorId &&
                movieId == that.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorsInMoviesId, actorId, movieId);
    }

    @ManyToOne
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    public Actor getActorByActorId() {
        return actorByActorId;
    }

    public void setActorByActorId(Actor actorByActorId) {
        this.actorByActorId = actorByActorId;
    }

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    public Movie getMovieByMovieId() {
        return movieByMovieId;
    }

    public void setMovieByMovieId(Movie movieByMovieId) {
        this.movieByMovieId = movieByMovieId;
    }
}
