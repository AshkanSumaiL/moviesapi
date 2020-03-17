package com.ashkan.moviesapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "actors_in_movies", schema = "moviedb", catalog = "")
public class ActorsInMovies {
    @JsonIgnore
    private int actorsInMoviesId;
    private int actorId;
    @JsonIgnore
    private int movieId;
    @JsonIgnore
    private Actor actor;
    @JsonIgnore
    private Movie movie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actors_in_movies_id")
    public int getActorsInMoviesId() {
        return actorsInMoviesId;
    }

    public void setActorsInMoviesId(int actorsInMoviesId) {
        this.actorsInMoviesId = actorsInMoviesId;
    }

    @Basic
    @Column(name = "actor_id", insertable = false, updatable = false)
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Basic
    @Column(name = "movie_id", insertable = false, updatable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", referencedColumnName = "id", nullable = false)
    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actorByActorId) {
        this.actor = actorByActorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movieByMovieId) {
        this.movie = movieByMovieId;
    }
}
