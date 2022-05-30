package com.niit.favouriteservice.controller;

import com.niit.favouriteservice.exception.UserNotFoundException;
import com.niit.favouriteservice.model.UserFavourite;
import com.niit.favouriteservice.service.UserFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/movieapp/user-fav")
public class UserFavouriteController {

    private UserFavouriteService userFavouriteService;
    @Autowired
    public UserFavouriteController(UserFavouriteService userFavouriteService) {
        this.userFavouriteService=userFavouriteService;
    }

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody UserFavourite userFavourite) {
        return new ResponseEntity<>(userFavouriteService.addUser(userFavourite), HttpStatus.OK);
    }
//    @CrossOrigin("*")
    @PutMapping("/fav/{userId}")
    public ResponseEntity<?> addToFavoriteList(@PathVariable int userId, @RequestBody String movieId) throws UserNotFoundException {
//        System.out.println("In Terminal"+movieId);
        return new ResponseEntity<>(userFavouriteService.addToFavourites(userId, movieId), HttpStatus.OK);
    }
//    @CrossOrigin("http://localhost:4200")
    @GetMapping("/fav/{userId}")
    public ResponseEntity<?> getFavouritesList(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(userFavouriteService.getAllFavourites(userId), HttpStatus.OK);
    }

    @DeleteMapping("/fav/{userId}/{movieId}")
    public ResponseEntity<?> delFromFavourites(@PathVariable int userId, @PathVariable String movieId) throws UserNotFoundException {
        return new ResponseEntity<>(userFavouriteService.delFromFavourites(userId,movieId), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(userFavouriteService.getUserById(userId), HttpStatus.OK);
    }
}
