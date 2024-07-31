package com.myproject.firstRestApi.services;

import com.myproject.firstRestApi.models.User;
import com.myproject.firstRestApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id ){
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        userRepository.save(user);
        return  user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
        return user;
    }
}
