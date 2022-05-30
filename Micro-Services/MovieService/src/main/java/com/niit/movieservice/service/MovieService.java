package com.niit.movieservice.service;

import com.niit.movieservice.exception.MovieNotFoundException;
import com.niit.movieservice.model.Movie;

import java.util.List;

public interface MovieService {
    public abstract Movie getMovieById(String movieId) throws MovieNotFoundException;
    public abstract Movie getMovieByName(String movieName)throws MovieNotFoundException;
    public abstract List<Movie> getAllMovies();
    public abstract Movie addMovie(Movie movie);
    public abstract void deleteMovie(String id)throws MovieNotFoundException;
    public abstract List<Movie> getMoviesByAllId(List<String> movieId);
    public abstract List<Movie> getMovieByFirstLetter(String movieName)throws MovieNotFoundException;
}
