package com.example.myspringbootapp.service;

import com.example.myspringbootapp.model.User;
import com.example.myspringbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    //Get all users

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Get user by id
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //Create new user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Update an existing user
    public User updateUser(Long id, User user){
        if(userRepository.existsById(id)){
            user.setId();
            return userRepository.save(user);
        }
        return null;
    }

    //Delete a user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
