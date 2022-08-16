package nl.saxion.webapps.moviepicker.mood;

import nl.saxion.webapps.moviepicker.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MoodRepository extends JpaRepository<Mood, String> {

}
