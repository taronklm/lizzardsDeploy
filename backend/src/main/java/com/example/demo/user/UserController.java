package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService UserService) {
        this.userService = UserService;
    }

    @GetMapping(path = "get/{userId}")
    public User gerUser(@PathVariable("userId") Long id) {
        return userService.getUser(id);
    }

    @GetMapping(path = "getAll")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path = "create")
    public void registerNewUser(@RequestBody User User) {
        userService.addNewUser(User);
    }

    @DeleteMapping(path = "delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "update/{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
            @RequestBody(required = false) String name,
            @RequestBody(required = false) String email) {
        userService.updateUser(userId, name, email);
    }
}
