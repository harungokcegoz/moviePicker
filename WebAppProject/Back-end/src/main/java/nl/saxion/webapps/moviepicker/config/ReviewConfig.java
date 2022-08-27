package nl.saxion.webapps.moviepicker.config;

import nl.saxion.webapps.moviepicker.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfig {
    CommandLineRunner commandLineRunner(ReviewRepository repository){
        return args -> repository.save(null);
    }
}
