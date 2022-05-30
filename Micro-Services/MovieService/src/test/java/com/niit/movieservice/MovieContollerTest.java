//package com.niit.movieappl.movie;
//
//import com.niit.movieappl.movie.controller.MovieController;
//import com.niit.movieappl.movie.exception.MovieNotFoundException;
//import com.niit.movieappl.movie.model.Movie;
//import com.niit.movieappl.movie.service.MovieService;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class MovieContollerTest {
//    @Mock
//    private MovieService movieService;//dependancy
//    @InjectMocks
//    private MovieController movieController;//dependant
//
//    @Autowired
//    private MockMvc mockMvc;
//    //is used to make controller to run standalone
//
//    private Movie movie;
//
//    @BeforeEach
//    public void setup()
//    {
//
//        movie=new Movie("10","test","hdsjd","shdss",4.5,"jhsd","jhsj","","");
//        mockMvc= MockMvcBuilders.standaloneSetup(movieController).build();
//
//    }
//    @AfterEach
//    public void destroy()
//    {
//
//        movie=null;
//
//    }
//    @Test
//    public void givenMovieIDSuccess() throws Exception {
//        when(movieService.getMovieById(any())).thenReturn(movie);
//        System.out.println(movie);
//        mockMvc.perform(
//                        get("/movieapp/movies/movie-byId/10")
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenMovienameSuccess() throws Exception {
//        when(movieService.getMovieByName(any())).thenReturn(movie);
//
//        mockMvc.perform(
//                        get("/movieapp/movies/movie-byName/test")
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenMovienameFailure() throws Exception {
//        when(movieService.getMovieByName(any())).thenReturn(null);
//
//        mockMvc.perform(
//                        get("/movieapp/movies/movie-byName/test")
//                                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//}
