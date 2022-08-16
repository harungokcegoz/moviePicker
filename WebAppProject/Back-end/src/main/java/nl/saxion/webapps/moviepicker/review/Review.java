package nl.saxion.webapps.moviepicker.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.saxion.webapps.moviepicker.movie.Movie;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Long id;
    @Column(name = "review")
    private String review;
    @Column(name = "rating")
    private double rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Review(String review, Movie movie) {
        this.review = review;
        this.movie = movie;
    }

    public Review(Long reviewId, String review, double rating) {
//        this.reviewId = reviewId;
        this.review = review;
        this.rating = rating;
    }

    public Review(String review) {
        this.review = review;
    }

    public Review() {
    }


//    public Long getReviewId() {
//        return reviewId;
//    }
//
//    public void setReviewId(Long reviewId) {
//        this.reviewId = reviewId;
//    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
