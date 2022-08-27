package nl.saxion.webapps.moviepicker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
        @OneToMany(mappedBy = "mood")
        private Set<Movie> movies;


    public Mood() {
    }
    //    public Mood(Long moodId, String moodName) {
//        this.moodId = moodId;
//        this.moodName = moodName;
//    }
//
//    public Mood() {
//    }


    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Long getMoodId() {
        return moodId;
    }

    public void setMoodId(Long moodId) {
        this.moodId = moodId;
    }
}
