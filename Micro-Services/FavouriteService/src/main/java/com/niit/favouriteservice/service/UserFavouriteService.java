package com.niit.favouriteservice.service;

import com.niit.favouriteservice.exception.UserNotFoundException;
import com.niit.favouriteservice.model.UserFavourite;

import java.util.List;

public interface UserFavouriteService {
    public UserFavourite addToFavourites(int userId, String movieId) throws UserNotFoundException;
    public UserFavourite addUser(UserFavourite userFavourite);
    public List<String> getAllFavourites(int userId) throws UserNotFoundException;
    public UserFavourite delFromFavourites(int userId, String movieId) throws UserNotFoundException;
    public UserFavourite getUserById(int userId) throws UserNotFoundException;
}
