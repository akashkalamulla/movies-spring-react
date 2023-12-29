package dev.farhan.movies.Service;

import dev.farhan.movies.Model.Movie;
import dev.farhan.movies.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie>allMovies(){
        return movieRepository.findAll();
    }
}
