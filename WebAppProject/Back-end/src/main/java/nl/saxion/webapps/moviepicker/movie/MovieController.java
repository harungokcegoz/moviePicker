package nl.saxion.webapps.moviepicker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/get")
    public List<Movie> getMovie(){
        List<Movie> movieList = movieService.getMovie();
        return movieList;
    }

    @PostMapping(path = "/post")
    public void registerNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }
    @DeleteMapping(path = "{moviesId}")
    public void deleteMovie(@PathVariable("movie_id") Long movieId){
        movieService.deleteMovie(movieId);
    }
    @PutMapping(path = "{moviesId}")
    public void updateStudent(
            @PathVariable("moviesId") Long moviesId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int releaseYear) {
            movieService.updateMovie(moviesId, name, category, description, releaseYear);
    }
}
