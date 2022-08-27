package nl.saxion.webapps.moviepicker.service;

import nl.saxion.webapps.moviepicker.entity.Review;
import nl.saxion.webapps.moviepicker.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    private  final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReview(){
        return (List<Review>) reviewRepository.findAll();
    }

    public void addNewReview(Review newReview){
        boolean exists = reviewRepository.existsById(newReview.getId());
        if (exists){
            throw new IllegalStateException("Review with ID " + newReview.getId() + " does already exist!");
        }else{

            reviewRepository.save(newReview);
        }
    }
    public void deleteReview(Long reviewId){
        boolean exists = reviewRepository.existsById(reviewId);
        if (!exists){
            throw new IllegalStateException("Review with ID " + reviewId + " does not exist!");
        }
        reviewRepository.deleteById(reviewId);
    }
    public void updateReview(Long reviewId, String review, double rating){
        Review r = reviewRepository.findById(reviewId).orElseThrow(() -> new IllegalStateException("Review with ID "+reviewId+" does not exist!"));
        if (review != null && review.length() > 0 && !Objects.equals(getReview(), review)){
            r.setReview(review);
        }
    }
}
