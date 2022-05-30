package com.niit.recommendedservice;

import com.niit.recommendedservice.model.RecommendedMovies;
import com.niit.recommendedservice.repository.RecommendedMovieRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class RecommnededMovieRepositoryTests {
@Autowired
private RecommendedMovieRepo repo;
private RecommendedMovies rmovies;
    @BeforeEach
    public void setup()
    {

       rmovies=new RecommendedMovies("1",250,"233","genre",4.5,"2022","U/A","test","");
        //  movieRepository.deleteAll();

    }
    @AfterEach
    public void destroy()
    {


        repo.delete(rmovies);
    }
@Test
    public void getallmoviesbycategory()
{
repo.save(rmovies);
List<RecommendedMovies> recmovies=repo.findAllByCategories("genre");
    assertEquals(1,recmovies.size());
assertEquals(recmovies.get(0).getMovieId(),rmovies.getMovieId());
}

    @Test
    public void getallmoviesbyyear()
    {
        repo.save(rmovies);
        List<RecommendedMovies> recmovies=repo.findAllByYearOfRelease("2022");
        assertEquals(1,recmovies.size());
        assertEquals(recmovies.get(0).getMovieName(),rmovies.getMovieName());
    }

}
