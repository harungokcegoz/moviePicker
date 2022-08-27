package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.entity.Movie;
import nl.saxion.webapps.moviepicker.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
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
    @GetMapping(path = "/movie/{movieId}")
    public Optional<Movie> getMovieById(@PathVariable("movie_id") Long movieId){
        Optional<Movie> movie = movieService.getMovieById(movieId);
        return movie;
    }

//    @PostMapping(path = "/post")
//    public void registerNewMovie(@RequestBody Movie movie){
//        movieService.addNewMovie(movie);
//    }
//    @DeleteMapping(path = "{moviesId}")
//    public void deleteMovie(@PathVariable("movie_id") Long movieId){
//        movieService.deleteMovie(movieId);
//    }
//    @PutMapping(path = "{moviesId}")
//    public void updateStudent(
//            @PathVariable("moviesId") Long moviesId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String category,
//            @RequestParam(required = false) String description,
//            @RequestParam(required = false) int releaseYear) {
//            movieService.updateMovie(moviesId, name, category, description, releaseYear);
//    }
}
