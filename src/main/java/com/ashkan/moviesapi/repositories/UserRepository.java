package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
