package com.niit.recommendedservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RecommendedMovies {
    @Id
  private  String movieId;
    private  int userliked_count;
    private  String views;
   private String categories;
    private double rating;
    private String yearOfRelease;
    private String ageRating;
    private String movieName;
    private String url;
    public RecommendedMovies()
    {

    }

    public RecommendedMovies(String movieId, int userliked_count, String views, String categories, double rating, String yearOfRelease, String ageRating,String movieName,String url) {
        this.movieId = movieId;
        this.userliked_count = userliked_count;
        this.views = views;
        this.categories = categories;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
        this.ageRating=ageRating;
        this.movieName=movieName;
        this.url=url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

   public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getUserliked_count() {
        return userliked_count;
    }

    public void setUserliked_count(int userliked_count) {
        this.userliked_count = userliked_count;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return "RecommendedMovies{" +
                "movieId='" + movieId + '\'' +
                ", userliked_count=" + userliked_count +
                ", views='" + views + '\'' +
                ", categories='" + categories + '\'' +
                ", rating=" + rating +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", ageRating='" + ageRating + '\'' +
                ", movieName='" + movieName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
