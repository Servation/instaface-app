package com.revature.instafaceapp.controller;

import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/Users")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    String registerUser(@RequestBody User user) {
        if (service.getUserByEmail(user)){
            service.addUser(user);
            return "User added";
        }
        return "User already exists";
    }
    @PostMapping("/user")
    public User getUserByLogin(@RequestBody User user){
        return service.getUserByLogin(user);
    }
}
