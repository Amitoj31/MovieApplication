package com.niit.movieservice.service;

import com.niit.movieservice.exception.MovieNotFoundException;
import com.niit.movieservice.model.Movie;
import com.niit.movieservice.rabbitmq.MovieDTO;
import com.niit.movieservice.rabbitmq.Producer;
import com.niit.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;
@Autowired
Producer movieproducer;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getMovieById(String movieId) throws MovieNotFoundException {

        if(movieRepository.findById(movieId)==null) {
            throw new MovieNotFoundException();
        } else {

            System.out.println(movieId);
            return movieRepository.findByMovieId(movieId);
        }
        //return movieRepository.findByMovieId(movieId);
    }

    @Override
    public Movie getMovieByName(String movieName) throws MovieNotFoundException {
        if(movieRepository.findByMovieName(movieName)==null)
        {
            throw new MovieNotFoundException();
        }
        else
        {
            return movieRepository.findByMovieName(movieName);
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
       MovieDTO m=new MovieDTO();
       m.setMovieId(movie.getMovieId());
       m.setMovieCategory(movie.getMovieCategory());
       m.setAgeRating(movie.getAgeRating());
       m.setRating(movie.getRating());
       m.setYearOfRelease(movie.getYearOfRelease());
       m.setUrl(movie.getUrl());
       if(movie.getViews()==null)
       {
           m.setViews("0");
       }
       else {
           m.setViews(movie.getViews());
       }
       m.setMovieName(movie.getMovieName());
       movieproducer.sendMessageToMq(m);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String id) throws MovieNotFoundException {

        //  movieRepository.deleteById(id);
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);

        } else {
            throw new MovieNotFoundException();

        }
    }

    @Override
    public List<Movie> getMoviesByAllId(List<String> movieId) {

List<Movie> recomm=new ArrayList<>();
Movie m= movieRepository.findAllById(movieId).iterator().next();
recomm.add(m);
return recomm;
    }

    @Override
    public List<Movie> getMovieByFirstLetter(String movieName) throws MovieNotFoundException {
        return movieRepository.findAll().stream().filter(s-> s.getMovieName()!=null)
                .filter(c->c.getMovieName().startsWith(movieName))
                .collect(Collectors.toList());
    }

}









