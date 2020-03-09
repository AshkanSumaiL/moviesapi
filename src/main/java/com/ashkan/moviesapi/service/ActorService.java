package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.Actor;

import java.util.List;

public interface ActorService {
    public List<Actor> findAll();

    public Actor findById(int theId);

    public void save(Actor actor);

    public void deleteById(int theId);
}
