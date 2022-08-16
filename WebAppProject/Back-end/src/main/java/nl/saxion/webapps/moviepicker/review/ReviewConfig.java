package nl.saxion.webapps.moviepicker.review;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfig {
    CommandLineRunner commandLineRunner(ReviewRepository repository){
        return args -> repository.save(null);
    }
}
