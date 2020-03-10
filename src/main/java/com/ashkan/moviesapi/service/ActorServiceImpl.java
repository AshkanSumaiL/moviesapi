package com.ashkan.moviesapi.service;


import com.ashkan.moviesapi.dao.ActorRepository;

import com.ashkan.moviesapi.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(int theId) {
        Optional<Actor> result = actorRepository.findById(theId);
        Actor actor;
        if (result.isPresent()) {
            actor = result.get();
        }
        else {
            throw new RuntimeException("Did not find the actor- " + theId);
        }
        return actor;
    }

    @Override
    public void save(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void deleteById(int theId) {
        actorRepository.deleteById(theId);
    }
}
