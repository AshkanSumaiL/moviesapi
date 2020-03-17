package com.ashkan.moviesapi.controllers;

import com.ashkan.moviesapi.entities.Actor;
import com.ashkan.moviesapi.services.interfaces.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("{id}")
    public Actor getActor(@PathVariable int id) {
        return actorService.findById(id);
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        actorService.save(actor);
        return actor;
    }
}
