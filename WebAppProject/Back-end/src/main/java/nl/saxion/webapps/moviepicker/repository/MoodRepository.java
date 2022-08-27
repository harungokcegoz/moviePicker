package nl.saxion.webapps.moviepicker.repository;

import nl.saxion.webapps.moviepicker.entity.Mood;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MoodRepository extends CrudRepository<Mood, String> {

}
