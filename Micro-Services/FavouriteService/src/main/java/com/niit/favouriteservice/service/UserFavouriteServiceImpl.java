package com.niit.favouriteservice.service;

import com.niit.favouriteservice.exception.UserNotFoundException;
import com.niit.favouriteservice.model.UserFavourite;
import com.niit.favouriteservice.repository.UserFavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserFavouriteServiceImpl implements UserFavouriteService{

    private UserFavouriteRepository userFavouriteRepository;
    @Autowired
    public UserFavouriteServiceImpl(UserFavouriteRepository userFavouriteRepository) {
        this.userFavouriteRepository=userFavouriteRepository;
    }

    @Override
    public UserFavourite addToFavourites(int userId, String movieId) throws UserNotFoundException {
        if(userFavouriteRepository.findById(userId).isPresent()) {
            UserFavourite user = userFavouriteRepository.findById(userId).get();
            List<String> favMovieId = user.getFavouriteMovies();
            if (favMovieId == null) {
                List<String> newfavList = new ArrayList<>();
                newfavList.add(movieId);
                user.setFavouriteMovies(newfavList);
                System.out.println(user);
            } else {
                favMovieId.add(movieId);
                user.setFavouriteMovies(favMovieId);
            }
            return userFavouriteRepository.save(user);
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserFavourite addUser(UserFavourite userFavourite) {
        return userFavouriteRepository.save(userFavourite);
    }

    @Override
    public List<String> getAllFavourites(int userId) throws UserNotFoundException {
        if(userFavouriteRepository.findById(userId).isPresent()) {
            return userFavouriteRepository.findById(userId).get().getFavouriteMovies();
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserFavourite delFromFavourites(int userId, String movieId) throws UserNotFoundException {
        if(userFavouriteRepository.findById(userId).isPresent()) {
            UserFavourite user = userFavouriteRepository.findById(userId).get();
            user.getFavouriteMovies().remove(movieId);
            return userFavouriteRepository.save(user);
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserFavourite getUserById(int userId) throws UserNotFoundException {
        if(userFavouriteRepository.findById(userId).isPresent()) {
            return userFavouriteRepository.findById(userId).get();
        }
        else {
            throw new UserNotFoundException();
        }
    }
}
