package com.revature.instafaceapp.service;

import com.revature.instafaceapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     List<User> getAllUsers();
     User getUserById(int id);
     User getUserByLogin(User user);
     void addUser(User user);
     void updateUser(User user, int id);
     void deleteUser(int id);
     Boolean getUserByEmail(User user);
}
