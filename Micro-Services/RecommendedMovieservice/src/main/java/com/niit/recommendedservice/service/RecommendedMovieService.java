package com.niit.recommendedservice.service;

import com.niit.recommendedservice.exception.NotFoundException;
import com.niit.recommendedservice.model.RecommendedMovies;

import java.util.List;

public interface RecommendedMovieService {
    public List<String> getLatestMovies() throws NotFoundException;
    public RecommendedMovies savemovie(RecommendedMovies m);
    public List<String> recommendByCategory(String category) throws NotFoundException;
    public List<RecommendedMovies> recommendByYear(String year) throws NotFoundException;
    public List<String> recommendByRating(double ratings) throws NotFoundException;
    public List<String> recommendByView();
//    public List<String> recommendByLikes();
}
