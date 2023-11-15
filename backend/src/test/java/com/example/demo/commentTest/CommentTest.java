package com.example.demo.commentTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.example.demo.comment.Comment;
import com.example.demo.song.Song;
import com.example.demo.user.User;

public class CommentTest {
    
    private Comment comment;
    private Song song;
    private User user;

    @BeforeEach
    public void setUp(){
        song = new Song(1L,"Sandstorm", "Darude", 360, 10, "Trance");
        user = new User("john", "john@doe.com", LocalDate.now());
        comment = new Comment(1L, "Nicer Song", user, song);
    }

    @Test
    public void testCorrectValues(){
        assertNotNull(comment);
        assertEquals(Long.valueOf(1L), comment.getId());
        assertEquals("Nicer Song", comment.getText());
        assertEquals(user, comment.getCreator());
        assertEquals(song, comment.getSong());
    }

    @Test
    public void testGetterAndSetter() {
        comment.setId(2L);
        assertEquals(Long.valueOf(2L), comment.getId());

        comment.setText("Sehr Nicer Song");
        assertEquals("Sehr Nicer Song", comment.getText());
    }

    @Test
    public void testUserAssociation() {
        assertNotNull(comment.getCreator());
        assertEquals("john", comment.getCreator().getName());
    }

    @Test
    public void testSongAssociation(){
        assertNotNull(comment.getSong());
        assertEquals("Sandstorm", comment.getSong().getTitle());
    }
}
