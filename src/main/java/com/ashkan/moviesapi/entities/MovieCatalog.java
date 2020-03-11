package com.ashkan.moviesapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_catalog", schema = "moviedb", catalog = "")
public class MovieCatalog {
    @JsonIgnore
    private int movieCatalogId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int movieId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int priceId;
    private Integer copies;
    @JsonIgnore
    private Movie movieByMovieId;
    @JsonIgnore
    private Price priceByPriceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_catalog_id")
    public int getMovieCatalogId() {
        return movieCatalogId;
    }

    public void setMovieCatalogId(int movieCatalogId) {
        this.movieCatalogId = movieCatalogId;
    }

    @Basic
    @Column(name = "movie_id", insertable = false, updatable = false)
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    @Column(name = "price_id", insertable = false, updatable = false)
    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "copies")
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCatalog that = (MovieCatalog) o;
        return movieCatalogId == that.movieCatalogId &&
                movieId == that.movieId &&
                priceId == that.priceId &&
                Objects.equals(copies, that.copies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieCatalogId, movieId, priceId, copies);
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
    @JoinColumn(name = "price_id", referencedColumnName = "id", nullable = false)
    public Price getPriceByPriceId() {
        return priceByPriceId;
    }

    public void setPriceByPriceId(Price priceByPriceId) {
        this.priceByPriceId = priceByPriceId;
    }
}
