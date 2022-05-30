package com.niit.recommendedservice.controller;

import com.niit.recommendedservice.exception.NotFoundException;
import com.niit.recommendedservice.service.RecommendedMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("movieapp/recom-movies")
public class RecommendedMovieController {

    @Autowired
    RecommendedMovieService rservice;

    @GetMapping("/latest")
    public ResponseEntity<?> getAllLatestMovies() throws NotFoundException {
    return new ResponseEntity<>(rservice.getLatestMovies(), HttpStatus.OK);
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<?> getAllMoviesByYear(@PathVariable String year) throws NotFoundException {
        return new ResponseEntity(rservice.recommendByYear(year), HttpStatus.OK);
    }
    @GetMapping("/category/{Category}")
    public ResponseEntity<?> getAllByCategories(@PathVariable String Category) throws NotFoundException {
        return new ResponseEntity<>(rservice.recommendByCategory(Category), HttpStatus.OK);
    }
    @GetMapping("/view")
    public ResponseEntity<?> getAllByViews() {
        return new ResponseEntity<>(rservice.recommendByView(), HttpStatus.OK);
    }
    @GetMapping("/rating/{ratings}")
    public ResponseEntity<?> getAllByRating(@PathVariable double ratings) throws NotFoundException {
        return new ResponseEntity<>(rservice.recommendByRating(ratings),HttpStatus.OK);
    }

}
