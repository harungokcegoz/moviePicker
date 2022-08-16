package nl.saxion.webapps.moviepicker.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.saxion.webapps.moviepicker.mood.Mood;
import nl.saxion.webapps.moviepicker.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    @Column(name = "movie_id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "description")
    private String description;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "image")
    private String image;


    @ManyToOne
    @JoinColumn(name = "mood_id")
    private Mood mood;


    @OneToMany
    @JoinColumn(name = "review_id")
    private List<Review> review;


    public Movie(Long id, String name, String category, String description, int releaseYear, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.releaseYear = releaseYear;
        this.image = image;

    }

    public Movie(Long id) {
        this.id = id;
    }

    public Movie(Long id, String name, String category, String description, int releaseYear, String image, Mood mood, List<Review> review) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.releaseYear = releaseYear;
        this.image = image;
        this.mood = mood;
        this.review = review;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }
}
