package com.niit.recommendedservice.repository;

import com.niit.recommendedservice.model.RecommendedMovies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendedMovieRepo extends MongoRepository<RecommendedMovies, String> {
    public List<RecommendedMovies> findAllByYearOfRelease(String Yearofrelease);
    public List<RecommendedMovies> findAllByCategories(String Categories);
}
