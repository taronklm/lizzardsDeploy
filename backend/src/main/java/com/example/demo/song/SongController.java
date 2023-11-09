package com.example.demo.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;
import com.example.demo.user.UserService;

@RestController
@RequestMapping(path = "api/v1/song")
public class SongController {
    
    private final SongService songService;

    private final UserService userService;
    
    @Autowired
    public SongController(SongService songService, UserService userService){
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping
    public List<Song> getSongs(){
        return songService.getSongs();
    }

    @PostMapping(path = "create/{userId}")
    public void createNewSong(@RequestBody Song song, @PathVariable("userId") Long userId){
        User user = userService.getUserById(userId);
        
        song.setUser(user);
        songService.createNewSong(song);
    }

    @DeleteMapping(path = "delete/{songId}")
    public void deleteSong(@PathVariable("songId") Long songId){
        songService.deleteSong(songId);
    }

    @PutMapping(path = "update/{songId}")
    public void updateSong(
        @PathVariable("songId") Long songId,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String actor,
        @RequestParam(required = false) Integer songDuration,
        @RequestParam(required = false) String genre){
            songService.updateSong(songId, title, actor, songDuration, genre);
    }
}
