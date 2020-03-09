package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
