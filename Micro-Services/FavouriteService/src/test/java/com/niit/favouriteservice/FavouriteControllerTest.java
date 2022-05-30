package com.niit.favouriteservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.favouriteservice.controller.UserFavouriteController;
import com.niit.favouriteservice.model.UserFavourite;
import com.niit.favouriteservice.service.UserFavouriteServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class FavouriteControllerTest {
    @Mock
    private UserFavouriteServiceImpl userFavouriteService;
    @InjectMocks
    private UserFavouriteController userFavouriteController;

    private UserFavourite userFavourite;
    private List<String> preferredCat;
    private List<String> favMovies;
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    public void setUp() {
        preferredCat=new ArrayList<>(Arrays.asList("Comedy","Romance","Action"));
        favMovies=new ArrayList<>(Arrays.asList("MV1","MV2"));
        userFavourite=new UserFavourite(10,"Kulwant","K@g.com","picadd1",81,favMovies,preferredCat);
        mockMvc= MockMvcBuilders.standaloneSetup(userFavouriteController).build();
    }
    @AfterEach
    public void destroy() {
        preferredCat=null;
        favMovies=null;
        userFavourite=null;
    }
    private String convertToJson(final Object object) {
        String result="";
        try {
            ObjectMapper mapper=new ObjectMapper();
            result=mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Test
    public void addUserTest() throws Exception {
        when(userFavouriteService.addUser(any())).thenReturn(userFavourite);
        mockMvc.perform(post("/movieapp/user-fav/adduser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertToJson(userFavourite)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

//    @Test
//    public void saveToFavouriteTest() throws Exception {
////        favMovies.add("MV4");
////        userFavourite.setFavouriteMovies(favMovies);
//        String id="MV4";
//        when(userFavouriteService.addToFavourites(userFavourite.getUserId(),id)).thenReturn(userFavourite);
//
//        mockMvc.perform(put("/movieapp/user-fav/fav/10")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(convertToJson("MV4")))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
    @Test
    public void getFavoutites() throws Exception {
        when(userFavouriteService.getAllFavourites(10)).thenReturn(userFavourite.getFavouriteMovies());
        mockMvc.perform(get("/movieapp/user-fav/fav/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(convertToJson(userFavourite)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
