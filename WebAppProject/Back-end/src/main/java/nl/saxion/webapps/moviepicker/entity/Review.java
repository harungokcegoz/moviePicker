package nl.saxion.webapps.moviepicker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.saxion.webapps.moviepicker.entity.Movie;

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
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review(Long id, String review, double rating, Movie movie) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.movie = movie;
    }

    public Review() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


}
