package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.song.Song;
import com.example.demo.song.SongService;
import com.example.demo.user.User;
import com.example.demo.user.UserService;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {
    
    private final CommentService commentService;
    private final UserService userService;
    private final SongService songService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService, SongService songService){
        this.commentService = commentService;
        this.userService = userService;
        this.songService = songService;
    }

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @GetMapping(path = "{commentId}")
    public Comment getComment(@PathVariable("commentId") Long commentId){
        return commentService.getComment(commentId);
    }

    @PostMapping(path = "create/{userId}/{songId}")
    public void createNewComment(@RequestBody Comment comment, @PathVariable("userId") Long userId, @PathVariable("songId") Long songId){
        User creator = userService.getUserById(userId);
        Song song = songService.getSong(songId);

        comment.setCreator(creator);
        comment.setSong(song);
        commentService.createNewComment(comment);
    }

    @DeleteMapping(path = "delete/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
    }
}
