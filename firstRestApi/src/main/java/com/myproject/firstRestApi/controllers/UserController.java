package com.myproject.firstRestApi.controllers;

import com.myproject.firstRestApi.error.UserNotFoundException;
import com.myproject.firstRestApi.models.User;
import com.myproject.firstRestApi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id ) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(id, user));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.deleteUser(id));
    }
}

