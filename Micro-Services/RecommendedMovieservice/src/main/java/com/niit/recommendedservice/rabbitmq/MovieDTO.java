package com.niit.recommendedservice.rabbitmq;

public class MovieDTO {

    private String movieId;
    private String movieName;
    private  String movieCategory;
    private String views;
    private double rating;
    private String ageRating;
     private String url;
    private  String yearOfRelease;

    public MovieDTO()
    {

    }

    public MovieDTO(String movieId, String movieCategory, String views, double rating, String ageRating, String yearOfRelease, String movieName,String url) {
        this.movieId = movieId;
        this.movieCategory = movieCategory;
        this.views = views;
        this.rating = rating;
        this.ageRating = ageRating;
        this.yearOfRelease = yearOfRelease;
        this.movieName=movieName;
        this.url=url;
    }




    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
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


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieCategory='" + movieCategory + '\'' +
                ", views='" + views + '\'' +
                ", rating=" + rating +
                ", ageRating='" + ageRating + '\'' +
                ", url='" + url + '\'' +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                '}';
    }
}
