package com.myproject.firstRestApi.services;

import com.myproject.firstRestApi.error.UserNotFoundException;
import com.myproject.firstRestApi.models.User;

import java.util.List;

public interface UserService {


    List<User> getUsers();

    User getUserById(Long id ) throws UserNotFoundException;

    User updateUser(Long id, User user) throws UserNotFoundException;

    User createUser(User user);

    User deleteUser(Long id) throws UserNotFoundException;
}
