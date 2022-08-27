package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.entity.Movie;

import nl.saxion.webapps.moviepicker.entity.Review;
import nl.saxion.webapps.moviepicker.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping
public class ReviewController {
    private final ReviewService reviewService;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping(path = "/getReviews")
    public List<Review> getReview() {
        List<Review> reviewList = reviewService.getReview();
        return reviewList;
    }

    @PostMapping(value = "/review/add/")
    public ResponseEntity<String> addReview(@RequestBody Review review, @PathVariable Long moviesId){
        reviewService.addNewReview(review);
        return ResponseEntity.ok("Review Saved");
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
