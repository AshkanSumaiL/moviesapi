package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Actor;
import com.ashkan.moviesapi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {
    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping("/actors")
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping("/actors/{Id}")
    public Actor getActor(@PathVariable int Id) {
        Actor actor = actorService.findById(Id);
        if (actor == null) {
            throw new RuntimeException("Actor id not found - " + Id);
        }
        return actor;
    }



    @PostMapping("/actors")
    public Actor addActor(@RequestBody Actor actor) {
        //actor.setId(0);
        actorService.save(actor);
        return actor;
    }


/*
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.save(theEmployee);

        return theEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }*/
}
