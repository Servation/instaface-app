package com.revature.instafaceapp.service;

import com.revature.instafaceapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User getUserByLogin(User user);
    public User addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public Boolean getUserByEmail(User user);
}
