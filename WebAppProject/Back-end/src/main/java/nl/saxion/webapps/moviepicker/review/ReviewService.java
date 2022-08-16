package nl.saxion.webapps.moviepicker.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    private  final  ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReview(){
        return reviewRepository.findAll();
    }

    public void addNewReview(Review review){
        reviewRepository.save(review);
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
