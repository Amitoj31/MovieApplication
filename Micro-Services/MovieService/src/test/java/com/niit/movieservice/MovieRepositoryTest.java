//package com.niit.movieappl.movie;
//
//import com.niit.movieappl.movie.model.Movie;
//import com.niit.movieappl.movie.repository.MovieRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class MovieRepositoryTest {
//    @Autowired
//    private MovieRepository movieRepository;
//    private Movie movie;
//    @BeforeEach
//    public void setup()
//    {
//
//        movie=new Movie("1","test","hdsjd","shdss",4.5,"jhsd","jhsj","","");
//        //  movieRepository.deleteAll();
//
//    }
//    @AfterEach
//    public void destroy()
//    {
//
//        movie=null;
//        movieRepository.deleteAll();
//    }
//    @Test
//    public void getallmoviedetails()
//    {
//        movieRepository.save(movie);
//        Movie m=movieRepository.findByMovieId("1");
//        assertEquals(m.getMovieId(),movie.getMovieId());
//    }
//    @Test
//    public void getallmoviedetailsByName()
//    {
//        movieRepository.save(movie);
//   Movie m= movieRepository.findByMovieName("test");
//
//        assertEquals(m.getMovieName(),movie.getMovieName());
//    }
//}
