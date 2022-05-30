package com.niit.recommendedservice.rabbitmq;



import com.niit.recommendedservice.model.RecommendedMovies;
import com.niit.recommendedservice.service.RecommendedMovieService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

   @Autowired
  private RecommendedMovieService movieservice;


@RabbitListener(queues="movie_queue")
public void getMovies(MovieDTO movieDTO) {
  RecommendedMovies m =new RecommendedMovies();
    m.setMovieId(movieDTO.getMovieId());
    m.setAgeRating(movieDTO.getAgeRating());
    m.setCategories(movieDTO.getMovieCategory());
    m.setViews(movieDTO.getViews());
    m.setRating(movieDTO.getRating());
   // m.setAgeRating(movieDTO.getAgeRating());
    m.setYearOfRelease(movieDTO.getYearOfRelease());
    m.setMovieName(movieDTO.getMovieName());
    m.setUrl(movieDTO.getUrl());
    movieservice.savemovie(m);
}
}

