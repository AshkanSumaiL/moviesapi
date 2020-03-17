package com.ashkan.moviesapi.services.implementations;


import com.ashkan.moviesapi.exceptions.NotFound.NotFoundException;
import com.ashkan.moviesapi.repositories.ActorRepository;
import com.ashkan.moviesapi.entities.Actor;
import com.ashkan.moviesapi.services.interfaces.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {
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
    public Actor findById(int id) {
        Optional<Actor> result = actorRepository.findById(id);
        Actor actor;
        if (result.isPresent()) {
            actor = result.get();
        } else {
            throw new NotFoundException("Actors",id);
        }
        return actor;
    }

    @Override
    public void save(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void deleteById(int id) {
        actorRepository.deleteById(id);
    }
}
