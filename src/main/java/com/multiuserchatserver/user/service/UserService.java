package com.multiuserchatserver.user.service;

import com.multiuserchatserver.user.entity.User;
import com.multiuserchatserver.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);

    }

    public List <User> getAllUsers(){
        return userRepository.findAll();
    }


    public void deleteUserbyId(Long userId) {
        userRepository.deleteById(userId);


    }

    public User getUserbyId(Long userId) {
        Optional<User> o=userRepository.findById(userId);
        if(o.isEmpty())
            return null;
        return o.get();
    }

    public User getUserByUsername(String username) {
        Optional<User>o=userRepository.findByUsername(username);
        if(o.isEmpty())
            return null;
        return o.get();
    }
}
