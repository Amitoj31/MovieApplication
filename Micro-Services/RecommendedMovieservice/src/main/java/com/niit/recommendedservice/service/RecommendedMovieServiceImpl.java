package com.niit.recommendedservice.service;

import com.niit.recommendedservice.exception.NotFoundException;
import com.niit.recommendedservice.model.RecommendedMovies;
import com.niit.recommendedservice.repository.RecommendedMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendedMovieServiceImpl implements RecommendedMovieService {
    @Autowired
    public RecommendedMovieRepo repo;

    @Override
    public List<String> getLatestMovies() throws NotFoundException {
        Date date=new Date();
        SimpleDateFormat sfd=new SimpleDateFormat("YYYY");
        String sdate=sfd.format(date);
        System.out.println(sdate);
        if(repo.findAllByYearOfRelease("2013").isEmpty()) {
            throw new NotFoundException();
        }
        else {
            List<String> movieIds = repo.findAllByYearOfRelease("2013").stream().map(s -> s.getMovieId()).collect(Collectors.toList());
            return movieIds;
        }
    }

    @Override
    public RecommendedMovies savemovie(RecommendedMovies m) {
      return   repo.save(m);
    }

    @Override
    public List<String> recommendByCategory(String category) throws NotFoundException {
        if(repo.findAllByCategories(category).isEmpty()) {
            throw new NotFoundException();
        }
        else
        {
        return repo.findAllByCategories(category).stream().map(s->s.getMovieId()).collect(Collectors.toList());
        }
    }

    @Override
    public List<RecommendedMovies> recommendByYear(String year) throws NotFoundException {
        if(repo.findAllByYearOfRelease(year).isEmpty()) {
            throw new NotFoundException();
        }
        else {
            List<RecommendedMovies> movieIds = repo.findAllByYearOfRelease(year);
            return movieIds;
        }
    }

    @Override
    public List<String> recommendByRating(double ratings)throws NotFoundException {

        return repo.findAll().stream().filter(s->s.getRating()>=ratings).map(s->s.getMovieId()).collect(Collectors.toList());

    }

    @Override
    public List<String> recommendByView() {
        System.out.println(repo.findAll());
        List<RecommendedMovies> m=repo.findAll().stream().sorted((s1,s2)-> s2.getViews().compareTo(s1.getViews())).collect(Collectors.toList());
        System.out.println("test m list"+m);
        List<String> ids=new ArrayList<>();
        for(int i=0;i<m.size();i++) {
            if(m.get(i).getMovieId()!=null) {
                ids.add(m.get(i).getMovieId());
                System.out.println("test list ids"+ids);
            }
        }
        return ids;
    }

//    @Override
//    public List<String> recommendByLikes() {
//        List<RecommendedMovies> m=repo.findAll().stream().sorted((s1,s2)-> s1.getUserliked_count()>s2.getUserliked_count()).collect(Collectors.toList());
//        List<String> ids=new ArrayList<>();
//    }
}
