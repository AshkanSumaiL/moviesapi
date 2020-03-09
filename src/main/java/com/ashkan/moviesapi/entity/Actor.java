package com.ashkan.moviesapi.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Actor {
    private int id;
    private String name;
    private Collection<ActorsInMovies> actorsInMoviesById;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id &&
                Objects.equals(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "actorByActorId")
    public Collection<ActorsInMovies> getActorsInMoviesById() {
        return actorsInMoviesById;
    }

    public void setActorsInMoviesById(Collection<ActorsInMovies> actorsInMoviesById) {
        this.actorsInMoviesById = actorsInMoviesById;
    }
}
