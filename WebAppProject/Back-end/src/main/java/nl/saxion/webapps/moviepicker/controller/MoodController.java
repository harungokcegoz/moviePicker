package nl.saxion.webapps.moviepicker.controller;

import nl.saxion.webapps.moviepicker.entity.Mood;
import nl.saxion.webapps.moviepicker.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
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

}
