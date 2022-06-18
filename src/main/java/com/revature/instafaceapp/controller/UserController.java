package com.revature.instafaceapp.controller;

import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/Users")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @CrossOrigin
    @PostMapping
    boolean registerUser(@RequestBody User user) {
        if (service.getUserByEmail(user) && !user.getEmail().isEmpty()) {
            User user1 = User.builder()
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .password(user.getPassword())
                    .imgURL("https://i1.lensdump.com/i/t7Evea.png?open=true")
                    .build();
            service.addUser(user1);
            return true;
        }
        return false;
    }

    @CrossOrigin
    @PostMapping("/user")
    public User getUserByLogin(@RequestBody User user) {
        return service.getUserByLogin(user);
    }

    @CrossOrigin
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        service.updateUser(user, user.getId());
        return  service.getUserById(user.getId());
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return service.getUserById(id);
    }
}
