package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.config.ReviewConfig;
import nl.saxion.webapps.moviepicker.entity.Movie;

import nl.saxion.webapps.moviepicker.entity.Review;
import nl.saxion.webapps.moviepicker.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping
public class ReviewController {
    private final ReviewService reviewService;
    private Long id;
    private double rating;
    private String review;
    private Long movie;


    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping(path = "/getReviews")
    public List<Review> getReview() {
        List<Review> reviewList = reviewService.getReview();
        return reviewList;
    }

    @PostMapping(value = "/review/add")
    public void addReview(@RequestBody Review review){
//        Review r = new Review(id, review,rating,movieId);
        reviewService.addNewReview(review);
    }

//    @DeleteMapping(path = "{reviewsId}")
//    public void deleteReview(@PathVariable("reviewsId") Long reviewId) {
//        reviewService.deleteReview(reviewId);
//    }
//
//    @PutMapping(path = "{reviewsId}")
//    public void updateReview(
//            @PathVariable("reviewsId") Long reviewId,
//            @RequestParam(required = false) String review,
//            @RequestParam(required = false) double rating) {
//        reviewService.updateReview(reviewId, review, rating);
//    }

}
