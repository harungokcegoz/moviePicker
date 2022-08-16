    package nl.saxion.webapps.moviepicker;

    import nl.saxion.webapps.moviepicker.movie.Movie;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;

    @SpringBootApplication
    public class MoviePickerApplication {
        public static void main(String[] args) {
            SpringApplication.run(MoviePickerApplication.class, args);
        }
    }

