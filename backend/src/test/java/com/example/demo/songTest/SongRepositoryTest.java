package com.example.demo.songTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.song.Song;
import com.example.demo.song.SongRepository;
import com.example.demo.user.User;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureEmbeddedDatabase
public class SongRepositoryTest {

    @Autowired
    private SongRepository songRepositoryTest;

    @Test
    void testFindByUser() {
        Song song = new Song(
            "Sandstorm", "Darude", 360, 10, "Trance"
        );

        User user = new User(
            1L, "john", "john@doe.com", LocalDate.now()
        );

        song.setUser(user);
        songRepositoryTest.save(song);

        Optional<List<Song>> exp = songRepositoryTest.findByUser(1L);

        assertNotNull(exp);
        assertEquals(song.getTitle(), exp.get().get(0).getTitle());
        assertEquals(song.getActor(), exp.get().get(0).getActor());
        assertEquals(song.getSongDuration(), exp.get().get(0).getSongDuration());
        assertEquals(song.getLikes(), exp.get().get(0).getLikes());
        assertEquals(song.getGenre(), exp.get().get(0).getGenre());
    }
}
