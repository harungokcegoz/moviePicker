package nl.saxion.webapps.moviepicker.mood;

import nl.saxion.webapps.moviepicker.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MoodService {
    private final MoodRepository moodRepository;

    @Autowired
    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    public List<Mood> getMood(){
        return moodRepository.findAll();
    }
    public void addNewMood(Mood mood){
        moodRepository.save(mood);
    }
    public void deleteMood(String moodName){
        boolean exists = moodRepository.existsById(moodName);
        if (!exists){
            throw new IllegalStateException("Mood with name " + moodName + " does not found");
        }
        moodRepository.deleteById(moodName);
    }
    public void updateMood(String moodName){
        Mood mood = moodRepository.findById(moodName).orElseThrow(() -> new IllegalStateException("Mood with name "+moodName+" does not exist!"));
        if (moodName != null && moodName.length() > 0 && !Objects.equals(mood.getMoodName(), moodName)){
            mood.setMoodName(moodName);
        }
    }
}
