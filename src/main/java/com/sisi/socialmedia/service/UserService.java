package com.sisi.socialmedia.service;

//we import the necessary classes for this service: User and Repository
import com.sisi.socialmedia.model.User;
import com.sisi.socialmedia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//use to tell Spring this is service component, should be managed by the Spring Application
@Service 
public class UserService {
	
	//inject an instance of the UserRepository interface into the field userRepository when the service is created
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //use optional in case user is not existed
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    //use findById to find the user then update using setters. If not found, return error message
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
