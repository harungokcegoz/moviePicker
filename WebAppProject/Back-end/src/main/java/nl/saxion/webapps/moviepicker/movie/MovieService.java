package nl.saxion.webapps.moviepicker.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }


    public void addNewMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("movie with id " + movieId + " does not exists");
        }
        movieRepository.deleteById(movieId);
    }

    public void updateMovie(Long moviesId, String name, String category, String description, int relaseYear) {
        Movie movie = movieRepository.findById(moviesId).orElseThrow(() -> new IllegalStateException("Movie with ID " + moviesId + " does not exist!"));

        if (name != null && name.length() > 0 && !Objects.equals(movie.getName(), name)) {
            movie.setName(name);
        }
        if (category != null && category.length() > 0) {
            movie.setCategory(category);
        }
        if (description != null && description.length() > 0) {
            movie.setDescription(description);
        }
        if (relaseYear > 0) {
            movie.setReleaseYear(relaseYear);
        }
    }
}
