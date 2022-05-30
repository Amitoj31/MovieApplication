package com.niit.favouriteservice;

import com.niit.favouriteservice.model.UserFavourite;
import com.niit.favouriteservice.repository.UserFavouriteRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class FavouriteRepoTest {

    @Autowired
    UserFavouriteRepository favouriteRepository;

    private UserFavourite userFavourite;

    @BeforeEach
    public void setUp() {
        List<String> preferredCat=new ArrayList<>(Arrays.asList("Comedy","Romance","Action"));
        List<String> favMovies=new ArrayList<>(Arrays.asList("MV1","MV2"));
        userFavourite=new UserFavourite(10,"Kulwant","K@g.com","picadd1",81,preferredCat,favMovies);
    }
    @AfterEach
    public void destroy() {
        favouriteRepository.delete(userFavourite);
        userFavourite=null;
    }

    @Test
    public void addToDb() {
        assertEquals(userFavourite,favouriteRepository.save(userFavourite));
    }

    @Test
    public void delFromDb() {
        favouriteRepository.insert(userFavourite);
        assertThrows(Exception.class,()->favouriteRepository.insert(userFavourite));
    }

}
