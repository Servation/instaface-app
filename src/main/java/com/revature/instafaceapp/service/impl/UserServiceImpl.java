package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.repository.UserRepository;
import com.revature.instafaceapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).get();
    }

    public Boolean getUserByEmail(User user){
        return repository.findByEmail(user.getEmail()) == null;
    }

    @Override
    public User getUserByLogin(User user) {
       return repository.findByLogin(user.getEmail(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        repository.save(user);
    }

    @Override
    public void updateUser(User user, int id) {
        User userDb = repository.findById(id).get();
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        userDb.setEmail(user.getEmail());
        userDb.setDescription(user.getDescription());
        userDb.setOccupation(user.getOccupation());
        userDb.setCity(user.getCity());
        userDb.setNationality(user.getNationality());
        userDb.setHobbies(user.getHobbies());
        userDb.setFacebook(user.getFacebook());
        userDb.setTwitter(user.getTwitter());
        userDb.setLinkedin(user.getLinkedin());
        userDb.setImgURL(user.getImgURL());
        repository.save(userDb);
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteById(id);
    }
}
