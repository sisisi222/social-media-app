package com.sisi.socialmedia.controller;

import com.sisi.socialmedia.model.User;
import com.sisi.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//tell Spring this is REST API controller that should handling HTTP requests
@RestController

//base URL for all requests handled by this controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*handles HTTP GET requests to the base URL ("/api/users") 
     * return all User entities in the DB*/
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    /* URL "/api/users/{id}" 
     * retrieve a specific user by ID
     * response a ResponseEntity<User> if user exist
     * if not, 404 Not Found error*/
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*handles HTTP POST requests to the base URL ("/api/users") 
     * create a new User entity in the database from the JSON data in the request body
     * return a ResponseEntity<User> that contains the newly created user entity*/
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    /*handles HTTP PUT requests to the base URL ("/api/users/{id}") 
     * update an existing User entity in the DB with the given ID*/
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /*handles HTTP DELETE requests to the base URL ("/api/users/{id}") 
     * delete an existing User entity in the DB with the given ID
     * return ResponseEntity<Void> with a 204 No Content state code => successful*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
