package nl.saxion.webapps.moviepicker.movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {
    CommandLineRunner commandLineRunner(MovieRepository repository){

        return args ->
                repository.saveAll(null);
    }
}
