package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.entity.Mood;
import nl.saxion.webapps.moviepicker.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping()
public class MoodController {
    private final MoodService moodService;

    @Autowired
    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }


    @GetMapping(path = "/getMoods")
    public List<Mood> getMood() {
        return moodService.getMood();
    }

//    @PostMapping(path = "/post")
//    public void registerNewMood(Mood mood){
//            moodService.addNewMood(mood);
//    }
//
//    @DeleteMapping(path = "{moodName}")
//    public void deleteMood(@PathVariable("moodName") String moodName) {
//        moodService.deleteMood(moodName);
//    }
//
//    @PutMapping(path = "{moodName}")
//    public void updateMood(@PathVariable("moodName") String moodName) {
//        moodService.deleteMood(moodName);
//    }
}
