package com.niit.recommendedservice;

import com.niit.recommendedservice.exception.NotFoundException;
import com.niit.recommendedservice.model.RecommendedMovies;
import com.niit.recommendedservice.repository.RecommendedMovieRepo;
import com.niit.recommendedservice.service.RecommendedMovieServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecommendedMovieserviceTest {
    @Mock
    RecommendedMovieRepo repo;
    @InjectMocks
    RecommendedMovieServiceImpl recimpl;

    private RecommendedMovies rm1,rm2,rm3;
    private List<RecommendedMovies> listRm;
    private List<String> movieIds;
    @BeforeEach
    public void setup() {
        rm1=new RecommendedMovies("1",250,"233","genre",4.5,"2022","U/A","test","");
        rm2=new RecommendedMovies("2",250,"4000","comedy",10,"2020","U/A","test","");
        rm3=new RecommendedMovies("3",250,"100","action",9,"2022","U/A","test","");
        listRm=new ArrayList<>();
        movieIds=new ArrayList<>();
    }

    @AfterEach
    public void destroy() {
        rm1=null;
        rm2=null;
        rm3=null;
        listRm=null;
        movieIds=null;
    }
    @Test
    public void getLatestTest() throws NotFoundException {
        listRm.add(rm1);
        listRm.add(rm3);
        movieIds.add("1");
        movieIds.add("3");
        when(repo.findAllByYearOfRelease("2022")).thenReturn(listRm);
        assertEquals(movieIds,recimpl.getLatestMovies());
    }
    @Test
    public void recommendByCategoryTest() throws NotFoundException {
        listRm.add(rm2);
        movieIds.add("2");
        when(repo.findAllByCategories("comedy")).thenReturn(listRm);
        assertEquals(movieIds,recimpl.recommendByCategory("comedy"));
    }
    @Test
    public void recommendByRatingTest() throws NotFoundException {
        listRm.add(rm2);
        listRm.add(rm1);
        listRm.add(rm3);
        movieIds.add("2");
        movieIds.add("3");
        when(repo.findAll()).thenReturn(listRm);
        assertEquals(movieIds,recimpl.recommendByRating(9));
    }
    @Test
    public void recommendByViewsTest() throws NotFoundException {
        listRm.add(rm2);
        listRm.add(rm1);
        listRm.add(rm3);
        movieIds.add("2");
        movieIds.add("1");
        movieIds.add("3");
        when(repo.findAll()).thenReturn(listRm);
        assertEquals(movieIds,recimpl.recommendByView());
    }
}
