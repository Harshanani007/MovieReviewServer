package com.example.server.models;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrendingRepository extends CrudRepository<Trending, String> {

   Optional<Trending> findByMovieMovieId(String movieId);

   public void deleteById(String id);

}