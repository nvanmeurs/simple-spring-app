package com.tutorial.simple.user;

import com.tutorial.simple.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {
    private final UsersDaoService usersDaoService;

    @Autowired
    public UserResource(UsersDaoService usersDaoService) {
        this.usersDaoService = usersDaoService;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return usersDaoService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        User user = usersDaoService.findOne(id);

        if (user == null) {
            throw new ResourceNotFoundException("ID: " + id);
        }

        return user;
    }

    @PostMapping("")
    public ResponseEntity<URI> createUser(@RequestBody User user) {
        User savedUser = usersDaoService.save(user);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        boolean userHasBeenDeleted = usersDaoService.deleteById(id);

        if (!userHasBeenDeleted) {
            throw new ResourceNotFoundException("ID: " + id);
        }
    }
}
