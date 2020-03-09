package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.MovieCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCatalogRepository extends JpaRepository<MovieCatalog, Integer> {
}
