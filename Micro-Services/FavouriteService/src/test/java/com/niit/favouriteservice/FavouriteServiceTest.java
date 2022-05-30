package com.niit.favouriteservice;

import com.niit.favouriteservice.exception.UserNotFoundException;
import com.niit.favouriteservice.model.UserFavourite;
import com.niit.favouriteservice.repository.UserFavouriteRepository;
import com.niit.favouriteservice.service.UserFavouriteServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FavouriteServiceTest {
    @Mock
    UserFavouriteRepository userFavouriteRepository;
    @InjectMocks
    UserFavouriteServiceImpl userFavouriteServiceImpl;

    private UserFavourite userFavourite;

    @BeforeEach
    public void setUp() {
        List<String> preferredCat=new ArrayList<>(Arrays.asList("Comedy","Romance","Action"));
        List<String> favMovies=new ArrayList<>(Arrays.asList("MV1","MV2"));
        userFavourite=new UserFavourite(10,"Kulwant","K@g.com","picadd1",81,favMovies,preferredCat);
    }
    @AfterEach
    public void destroy() {
        userFavourite=null;
    }

    @Test
    public void addUserTest() {
        when(userFavouriteRepository.save(userFavourite)).thenReturn(userFavourite);
        assertEquals(userFavourite, userFavouriteServiceImpl.addUser(userFavourite));
        verify(userFavouriteRepository, times(1)).save(userFavourite);
    }
    @Test
    public void addToFavourite() throws UserNotFoundException {
        when(userFavouriteRepository.findById(userFavourite.getUserId())).thenReturn(Optional.ofNullable(userFavourite));
        when(userFavouriteRepository.save(userFavourite)).thenReturn(userFavourite);
        assertEquals(userFavourite,userFavouriteServiceImpl.addToFavourites(userFavourite.getUserId(),"MV3"));
    }
    @Test
    public void addToFavouriteExceptionTest() throws UserNotFoundException {
        when(userFavouriteRepository.findById(userFavourite.getUserId())).thenReturn(Optional.ofNullable(null));
        assertThrows(UserNotFoundException.class, ()->userFavouriteServiceImpl.addToFavourites(userFavourite.getUserId(),"MV!"));
    }
    @Test
    public void getAllFavouriteTest() throws UserNotFoundException {
        when(userFavouriteRepository.findById(userFavourite.getUserId())).thenReturn(Optional.ofNullable(userFavourite));
//        when(userFavouriteRepository.save(userFavourite)).thenReturn(userFavourite);
        List<String> ste=new ArrayList<>(Arrays.asList("MV1","MV2"));
        assertEquals(ste,userFavouriteServiceImpl.getAllFavourites(userFavourite.getUserId()));
    }
    @Test
    public void getAllFavouriteTestException() throws UserNotFoundException {
        when(userFavouriteRepository.findById(userFavourite.getUserId())).thenReturn(Optional.ofNullable(null));
        assertThrows(UserNotFoundException.class, ()->userFavouriteServiceImpl.getAllFavourites(userFavourite.getUserId()));
    }
}
