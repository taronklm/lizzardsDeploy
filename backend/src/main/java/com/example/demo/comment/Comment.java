package com.example.demo.comment;

import java.time.LocalDate;

import com.example.demo.song.Song;
import com.example.demo.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"comment\"")
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_sequence")
    private Long id;
    private String text;
    private LocalDate createdAt;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "songId")
    private Song song;

    public Comment(){
    }

    public Comment(String text) {
        this.text = text;
        this.createdAt = LocalDate.now();
    }

    public Comment(String text, Song song) {
        this.text = text;
        this.createdAt = LocalDate.now();
        this.song = song;
    }

    public Comment(String text, User creator, Song song) {
        this.text = text;
        this.createdAt = LocalDate.now();
        this.creator = creator;
        this.song = song;
    }

    public Comment(Long id, String text, User creator, Song song) {
        this.id = id;
        this.text = text;
        this.createdAt = LocalDate.now();
        this.creator = creator;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Comment [id=" + id + ", text=" + text + ", createdAt=" + createdAt + ", creator=" + creator + ", song="
                + song + "]";
    }
}
