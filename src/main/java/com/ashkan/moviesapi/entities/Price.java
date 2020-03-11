package com.ashkan.moviesapi.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Price {
    private int id;
    private BigDecimal price;
    private Timestamp date;
    private Collection<MovieCatalog> movieCatalogsById;

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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return id == price1.id &&
                Objects.equals(price, price1.price) &&
                Objects.equals(date, price1.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, date);
    }

    @OneToMany(mappedBy = "priceByPriceId")
    public Collection<MovieCatalog> getMovieCatalogsById() {
        return movieCatalogsById;
    }

    public void setMovieCatalogsById(Collection<MovieCatalog> movieCatalogsById) {
        this.movieCatalogsById = movieCatalogsById;
    }
}
