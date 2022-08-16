package nl.saxion.webapps.moviepicker.mood;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.saxion.webapps.moviepicker.movie.Movie;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "mood")
public class Mood {
        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY
        )
        @Column(name = "mood_id")
        private Long moodId;
        @Column(name = "mood_name")
        private String moodName;

        @JsonIgnore
        @OneToMany
        @JoinColumn(name = "mood_id")
        private List<Movie> movies;


    public Mood(Long moodId, String moodName) {
        this.moodId = moodId;
        this.moodName = moodName;
    }

    public Mood() {
    }


    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Long getMoodId() {
        return moodId;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }
}
