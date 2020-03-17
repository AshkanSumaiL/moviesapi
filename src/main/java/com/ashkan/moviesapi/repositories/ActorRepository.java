package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.Actor;
import com.ashkan.moviesapi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT id FROM Actor")
    List<Integer> findAllIds();
}
