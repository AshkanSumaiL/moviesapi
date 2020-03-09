package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
