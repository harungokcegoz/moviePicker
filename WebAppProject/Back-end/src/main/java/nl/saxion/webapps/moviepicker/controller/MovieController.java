package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.entity.Movie;
import nl.saxion.webapps.moviepicker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController

public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/getMovies")
    public List<Movie> getAllMovies(){
        return movieService.getMovie();
    }

    @GetMapping(path = "/getMovie/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable Long movieId){
        Optional<Movie> movie = movieService.getMovieById(movieId);
        return movie;
    }

}
