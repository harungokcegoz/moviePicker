package nl.saxion.webapps.moviepicker.mood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "api/moods")
public class MoodController {
    private final MoodService moodService;

    @Autowired
    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }


    @GetMapping(path = "/get")
    public List<Mood> getMood() {
        List<Mood> moodList = moodService.getMood();
        return moodList;
    }

    @PostMapping(path = "/post")
    public void registerNewMood(Mood mood){
            moodService.addNewMood(mood);
    }

    @DeleteMapping(path = "{moodName}")
    public void deleteMood(@PathVariable("moodName") String moodName) {
        moodService.deleteMood(moodName);
    }

    @PutMapping(path = "{moodName}")
    public void updateMood(@PathVariable("moodName") String moodName) {
        moodService.deleteMood(moodName);
    }
}
