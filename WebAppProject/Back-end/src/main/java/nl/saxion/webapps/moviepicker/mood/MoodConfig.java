package nl.saxion.webapps.moviepicker.mood;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MoodConfig {
    CommandLineRunner commandLineRunner(MoodRepository repository){
        return args ->
                repository.saveAll(null);
    }
}
