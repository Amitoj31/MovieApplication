//package com.niit.movieappl.movie;
//
//import com.niit.movieappl.movie.exception.MovieNotFoundException;
//import com.niit.movieappl.movie.model.Movie;
//import com.niit.movieappl.movie.repository.MovieRepository;
//import com.niit.movieappl.movie.service.MovieServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class MovieServiceTests {
//    @Mock
//    MovieRepository movieRepository;//dependancy
//
//    @InjectMocks
//    MovieServiceImpl movieService;//dependant
//
//    private Movie movie;
//
//    @BeforeEach
//    public void setup() {
//
//        movie = new Movie("14", "test", "hdsjd", "shdss", 4.5, "jhsd", "jhsj", "", "");
//
//
//    }
//
//    @AfterEach
//    public void destroy() {
//
//        movie = null;
//
//    }
//
//    @Test
//    public void getMovieById() throws MovieNotFoundException {
//        when(movieRepository.findByMovieId(movie.getMovieId())).thenReturn(movie);
//
//        assertEquals(movie, movieService.getMovieById(movie.getMovieId()));
//        System.out.println(movieService.getMovieById(movie.getMovieId()));
//
//    }
//    @Test
//    public void getmoviebyname() throws MovieNotFoundException {
//        when(movieRepository.findByMovieName(movie.getMovieName())).thenReturn(movie);
//
//        assertEquals(movie,movieService.getMovieByName(movie.getMovieName()));
//        verify(movieRepository,times(2)).findByMovieName(movie.getMovieName());
//    }
//    @Test
//    public void getmoviebynameReturnFailure() throws MovieNotFoundException {
//        when(movieRepository.findByMovieName(movie.getMovieName())).thenReturn(null);
//
//        assertThrows(MovieNotFoundException.class,()->movieService.getMovieByName(movie.getMovieName()));
//        verify(movieRepository,times(1)).findByMovieName(movie.getMovieName());
//    }
//}
//
