package com.example.demo.song;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.UserRepository;

import jakarta.transaction.Transactional;

// import com.example.demo.user.User;

@Service
public class SongService {
    
    private final SongRepository songRepository;


    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    public List<Song> getSongs(){
        return songRepository.findAll();
    }

    public void createNewSong(Song song) {
        songRepository.save(song);
    }

    public void deleteSong(Long songId) {
        Boolean exists = songRepository.existsById(songId);
        if (!exists) {
            throw new IllegalStateException("song with id " + songId + " does not exists");
        }
        songRepository.deleteById(songId);
    }

    @Transactional
    public void updateSong(Long songId, String title, String actor, Integer songDuration, String genre) {
        Song song = songRepository.findById(songId).orElseThrow(() -> new IllegalStateException(
            "song with id " + songId + " does not exists"
        ));

        if(title != null && title.length() > 0 && !Objects.equals(song.getTitle(), title)){
            song.setTitle(title);
        }

        if(actor != null && actor.length() > 0 && !Objects.equals(song.getActor(), actor)){
            song.setActor(actor);
        }

        if(songDuration != null && songDuration > 0 && !Objects.equals(song.getSongDuration(), songDuration)){
            song.setSongDuration(songDuration);
        }

        if(genre != null && genre.length() > 0 && !Objects.equals(song.getGenre(), genre)){
            song.setGenre(genre);
        }
    }    
}
