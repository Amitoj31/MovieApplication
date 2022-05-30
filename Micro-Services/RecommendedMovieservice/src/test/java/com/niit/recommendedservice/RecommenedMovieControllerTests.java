package com.niit.recommendedservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.recommendedservice.controller.RecommendedMovieController;
import com.niit.recommendedservice.model.RecommendedMovies;
import com.niit.recommendedservice.service.RecommendedMovieService;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RecommenedMovieControllerTests {
    @Mock
    private RecommendedMovieService rservice;
    @InjectMocks
    private RecommendedMovieController rc;

    @Autowired
    private MockMvc mockMvc;

    private RecommendedMovies rm1,rm2,rm3;
    private List<RecommendedMovies> listRm;
    private List<String> movieIds;
    @BeforeEach
    public void setup() {
        rm1=new RecommendedMovies("1",250,"233","genre",4.5,"2022","U/A","test","/assests/image.jpg");
        rm2=new RecommendedMovies("2",250,"4000","comedy",10,"2020","U/A","test","");
        rm3=new RecommendedMovies("3",250,"100","action",9,"2022","U/A","test","");
        listRm=new ArrayList<>();
        movieIds=new ArrayList<>();
        mockMvc= MockMvcBuilders.standaloneSetup(rc).build();
    }

    @AfterEach
    public void destroy() {
        rm1=null;
        rm2=null;
        rm3=null;
        listRm=null;
        movieIds=null;
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
    public void getLatestTest() throws Exception {
        movieIds.add("1");
        movieIds.add("3");
        when(rservice.getLatestMovies()).thenReturn(movieIds);

        mockMvc.perform(
                        get("/movieapp/recom-movies/latest")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJson(movieIds)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void getByCategoryTest() throws Exception {
        movieIds.add("2");

        when(rservice.recommendByCategory("comedy")).thenReturn(movieIds);

        mockMvc.perform(
                        get("/movieapp/recom-movies/category/comedy")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJson(movieIds)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void getByRatingTest() throws Exception {
        movieIds.add("2");
        movieIds.add("3");
        when(rservice.recommendByRating(5)).thenReturn(movieIds);

        mockMvc.perform(
                        get("/movieapp/recom-movies/rating/5")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(convertToJson(movieIds)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
