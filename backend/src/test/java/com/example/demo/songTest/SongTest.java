package com.example.demo.songTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.comment.Comment;
import com.example.demo.song.Song;
import com.example.demo.user.User;

@SpringBootTest
public class SongTest {
    
    private Song song;
    private User user;

    @BeforeEach
    public void setUp(){
        song = new Song(1L,"Sandstorm", "Darude", 360, 10, "Trance");
        user = new User("john", "john@doe.com", LocalDate.now());
    }

    @Test
    public void testCorrectValues() {
        assertNotNull(song);
        assertEquals(Long.valueOf(1), song.getId());
        assertEquals("Sandstorm", song.getTitle());
        assertEquals("Darude", song.getActor());
        assertEquals(Integer.valueOf(360), song.getSongDuration());
        assertEquals(Integer.valueOf(10), song.getLikes());
        assertEquals("Trance", song.getGenre());
    }

    @Test
    public void testGetterAndSetter(){
        song.setId(2L);
        assertEquals(2L, song.getId());

        song.setTitle("Money Trees");
        assertEquals("Money Trees", song.getTitle());

        song.setActor("Kendrick Lamar");
        assertEquals("Kendrick Lamar", song.getActor());

        song.setSongDuration(300);
        assertEquals(Integer.valueOf(300), song.getSongDuration());

        song.setLikes(12);
        assertEquals(Integer.valueOf(12), song.getLikes());

        song.setGenre("Rap");
        assertEquals("Rap", song.getGenre());
    }

    @Test
    public void testComments(){
        List<Comment> comments = List.of(new Comment("Test 1", user, song), new Comment("Test 2", user, song));

        song.setComments(comments);

        assertNotNull(song.getComments());
        
        assertEquals(2, song.getComments().size());
        
        assertEquals("Test 1", song.getComments().get(0).getText());
        assertEquals(user, song.getComments().get(0).getCreator());

        assertEquals("Test 2", song.getComments().get(1).getText());
        assertEquals(user, song.getComments().get(1).getCreator());
    }

    @Test
    public void testUserAssociation() {
        
        assertNull(song.getUser());

        song.setUser(user);

        assertNotNull(song.getUser());
        assertEquals("john", song.getUser().getName());
    }

    @Test
    public void testToString(){
        assertEquals(
            "Song [id=" + song.getId() + ", title=" + song.getTitle() 
                + ", actor="  + song.getActor() + ", songDuration=" + song.getSongDuration() 
                + ", likes=" + song.getLikes() 
                + ", user=" + song.getUser()
                + ", genre=" + song.getGenre() + "]", 
            song.toString()
        );
    }
}
