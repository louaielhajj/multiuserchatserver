package com.multiuserchatserver.user.controller;


import com.multiuserchatserver.user.entity.User;
import com.multiuserchatserver.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;

    }


    @GetMapping("/test")
    public String test(){
        return "It's working";

    }
    @PostMapping("/login")
    public User login(@RequestParam String username,@RequestParam String password){
        User u=userService.getUserByUsername(username);
        if(u==null){
            //todo throw exception user doesn't exist
        }
        if(!u.getPassword().equals(password)){
            //todo throw exception invalid username or password
        }
        return u;
    }
    @GetMapping()
    public List <User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
    return userService.createUser(user);

    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUserbyId(userId);

    }

    @GetMapping("/{userId}")
    public User getUserbyId(@PathVariable Long userId) {
        return userService.getUserbyId(userId);

    }


}
