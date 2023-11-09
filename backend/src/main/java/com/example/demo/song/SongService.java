package com.example.demo.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.UserRepository;

// import com.example.demo.user.User;

@Service
public class SongService {
    
    private final SongRepository songRepository;

    private UserRepository userRepository;

    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public SongService(SongRepository songRepository, UserRepository userRepository){
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    public List<Song> getSongs(){
        return songRepository.findAll();
    }

    public void createNewSong(Song song) {
        songRepository.save(song);
    }
}
