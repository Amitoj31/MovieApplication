package com.niit.favouriteservice.repository;

import com.niit.favouriteservice.model.UserFavourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavouriteRepository extends MongoRepository<UserFavourite, Integer> {

    public UserFavourite findByEmail(String email);

}
