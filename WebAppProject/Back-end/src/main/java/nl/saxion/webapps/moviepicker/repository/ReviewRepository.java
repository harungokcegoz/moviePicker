package nl.saxion.webapps.moviepicker.repository;

import nl.saxion.webapps.moviepicker.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
}
