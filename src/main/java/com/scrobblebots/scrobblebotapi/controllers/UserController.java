package com.scrobblebots.scrobblebotapi.controllers;


import com.scrobblebots.scrobblebotapi.exceptions.RecordNotFoundException;
import com.scrobblebots.scrobblebotapi.interfaces.UserService;
import com.scrobblebots.scrobblebotapi.models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username){
        User user = userService.GetUser(username);
        return new ResponseEntity<User>(user, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser  = userService.AddUser(user);
        return new ResponseEntity<User>(createdUser, new HttpHeaders(),HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public HttpStatus deleteUser(@PathVariable("username") String username) throws RecordNotFoundException {
        User user = userService.GetUser(username);
        userService.DeleteUser(user);
        return HttpStatus.ACCEPTED;
    }
}
