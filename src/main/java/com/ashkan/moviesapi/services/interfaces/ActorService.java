package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(int id);

    void save(Actor actor);

    void deleteById(int id);
}
