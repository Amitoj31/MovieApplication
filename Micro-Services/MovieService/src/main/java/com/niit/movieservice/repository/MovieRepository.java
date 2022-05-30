package com.niit.movieservice.repository;

import com.niit.movieservice.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {
    public abstract Movie findByMovieId(String movieId);
    public abstract Movie findByMovieName(String movieName);

}
