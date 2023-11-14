package com.example.demo.song;

import java.util.List;

import com.example.demo.comment.Comment;
// import com.example.demo.comment.Comment;
import com.example.demo.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"song\"")
public class Song {
    
    @Id
    @SequenceGenerator(name = "song_sequence", sequenceName = "song_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_sequence")
    private long id;
    private String title;
    private String actor;
    private Integer songDuration;
    private Integer likes;
    
    @OneToMany(mappedBy = "song")
    private List<Comment> comments;
    
    @ManyToOne // relation one user, many songs
    @JoinColumn(name = "userId")
    private User user;

    private String genre;

    public Song(){
    }

    public Song(String title, String actor, Integer songDuration, Integer likes, String genre){
        this.title = title;
        this.actor = actor;
        this.songDuration = songDuration;
        this.likes = likes;
        this.genre = genre;
    }

    public Song(Long id, String title, String actor, Integer songDuration, Integer likes, String genre){
        this.id = id;
        this.title = title;
        this.actor = actor;
        this.songDuration = songDuration;
        this.likes = likes;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Integer getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(Integer songDuration) {
        this.songDuration = songDuration;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", title=" + title + ", actor=" + actor + ", songDuration=" + songDuration
                + ", likes=" + likes + ", user=" + user + ", genre=" + genre + "]";
    }
}