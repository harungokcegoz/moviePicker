package nl.saxion.webapps.moviepicker.review;

import nl.saxion.webapps.moviepicker.mood.Mood;
import nl.saxion.webapps.moviepicker.movie.Movie;
import nl.saxion.webapps.moviepicker.movie.MovieController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/review")
public class ReviewController {
    private final ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping(path = "/get")
    public List<Review> getReview() {
        List<Review> reviewList = reviewService.getReview();
        return reviewList;
    }

    @PostMapping(value = "/post")
    @ResponseStatus(HttpStatus.CREATED)
    public void process(@RequestBody Map<String, String> jsonBody) throws Exception {
        String review = jsonBody.get("review");
        Long movieId = Long.parseLong("movieId");
        Movie movie = new Movie(movieId);
        Review newReview = new Review(review, movie);
        reviewService.addNewReview(newReview);
    }

    @DeleteMapping(path = "{reviewsId}")
    public void deleteReview(@PathVariable("reviewsId") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @PutMapping(path = "{reviewsId}")
    public void updateReview(
            @PathVariable("reviewsId") Long reviewId,
            @RequestParam(required = false) String review,
            @RequestParam(required = false) double rating) {
        reviewService.updateReview(reviewId, review, rating);
    }

}
