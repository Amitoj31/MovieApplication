package com.niit.movieservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    @Id
  private  String movieId;
    private  String movieName;
    private String movieCategory;
    private String movieDirector;
    private  double rating;
    private String ageRating;
    private  String yearOfRelease;
    private String views;
    private  String url;

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Movie()
    {

    }
    public Movie(String movieId, String movieName, String movieCategory, String movieDirector, double rating, String ageRating, String yearOfRelease,String views,String url) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieCategory = movieCategory;
        this.movieDirector = movieDirector;
        this.rating = rating;
        this.ageRating = ageRating;
        this.yearOfRelease=yearOfRelease;
        this.views=views;
        this.url=url;

    }
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
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
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieCategory='" + movieCategory + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", rating=" + rating +
                ", ageRating='" + ageRating + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", views='" + views + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}

