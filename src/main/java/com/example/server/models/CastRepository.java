package com.example.server.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CastRepository extends CrudRepository<Cast, String> {
    List<Cast> findByMovieMovieId(String movieId);

    List<Cast> findByCastNameContaining(String castName);
}