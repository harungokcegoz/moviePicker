package nl.saxion.webapps.moviepicker.repository;

import nl.saxion.webapps.moviepicker.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

}
