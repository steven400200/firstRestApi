package com.myproject.firstRestApi.services;

import com.myproject.firstRestApi.error.UserNotFoundException;
import com.myproject.firstRestApi.models.User;
import com.myproject.firstRestApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public User getUserById(Long id ) throws UserNotFoundException {
        Optional<User> aux =userRepository.findById(id);
       if (!aux.isPresent()){
           throw  new UserNotFoundException("User is not available");
       }
       return aux.get();
    }

    public User updateUser(Long id, User user) throws UserNotFoundException {
        User aux =userRepository.findById(id).get();
        if (aux.isEmpty()){
            throw  new UserNotFoundException("User is not available");
        }else{
            if (!user.getName().isBlank()){
                aux.setName(user.getName());
            }if (!user.getLastName().isBlank()){
                aux.setLastName(user.getLastName());
            }if (!user.getEmail().isBlank()){
                aux.setEmail(user.getEmail());
            }if (!user.getPhoneNumber().isBlank()){
                aux.setPhoneNumber(user.getPhoneNumber());
            }
            userRepository.save(aux);
        }
        return  aux;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).get();
        if (user.isEmpty()){
            throw  new UserNotFoundException("User is not available");
        }
        userRepository.deleteById(id);
        return user;
    }
}
