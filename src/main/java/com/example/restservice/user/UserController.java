package com.example.restservice.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        LOG.info("Getting all users.");
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> createUser(@PathVariable("id") String id, @RequestBody User requestUser) {
        LOG.info("Starting my application with {} args.", requestUser.getUsername());
        return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createTutorial(@RequestBody User user) {
        try {
            User _user = userRepository.save(new User(user.getUsername(), user.getEmail(), user.getPassword()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user/{id}")
    public User editUser(@PathVariable("id") String id) {
        LOG.info("Getting all users.");
        return userRepository.findById(id).get();
    }
}