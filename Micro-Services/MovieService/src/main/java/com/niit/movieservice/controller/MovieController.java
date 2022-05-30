package com.niit.movieservice.controller;

import com.niit.movieservice.exception.MovieNotFoundException;
import com.niit.movieservice.model.Message;
import com.niit.movieservice.model.Movie;
import com.niit.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/movieapp/movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService=movieService;
    }

    @GetMapping("/movie")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping("/movie-byId/{movieId}")
    public ResponseEntity<?> getMovieById(@PathVariable String movieId)throws MovieNotFoundException
    {


        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }
    @GetMapping("/movie-byName/{movieName}")
    public ResponseEntity<?> getMovieByMovieName(@PathVariable String movieName)throws MovieNotFoundException
    {


        return new ResponseEntity<>(movieService.getMovieByName(movieName), HttpStatus.OK);
    }
    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);
    }
    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable String movieId)throws MovieNotFoundException
    {
        movieService.deleteMovie(movieId);
        return  new ResponseEntity<>(new Message("SUCCESS","RECORD DELETED") ,HttpStatus.OK);


    }

    @GetMapping("/movie-byFirstLetter/{movieName}")
    public ResponseEntity<?> getMovieByFirstLetter(@PathVariable String movieName)throws MovieNotFoundException
    {


        return new ResponseEntity<>(movieService.getMovieByFirstLetter(movieName), HttpStatus.OK);
    }




//    @GetMapping("/movie/{movie}")
//    public ResponseEntity<?> getMovieByAllId(@RequestBody Movie movie)
//    {
//
//
//        return new ResponseEntity<>(movieService.getMoviesByAllId(movie), HttpStatus.OK);
//    }
}

