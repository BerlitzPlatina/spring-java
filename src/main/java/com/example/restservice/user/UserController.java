package com.example.restservice.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @PostMapping("/user/{id}")
    public User createUser(@PathVariable("id") String id, @RequestBody User requestUser) {
        LOG.info("Starting my application with {} args.", requestUser.getUsername());
        return userRepository.findById(id).get();
    }

    @PutMapping("/user/{id}")
    public User editUser(@PathVariable("id") String id) {
        LOG.info("Getting all users.");
        return userRepository.findById(id).get();
    }
}