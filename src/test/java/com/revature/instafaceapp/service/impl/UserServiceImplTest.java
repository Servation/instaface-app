package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService service;

    @Test
    void updateUser() {
        User user = User.builder()
                .id(16)
                .firstName("FirstNameTest")
                .lastName("LastNameTest")
                .password("PasswordTest")
                .city("CityTest")
                .email("test@email.com")
                .build();
        service.updateUser(user, user.getId());
    }
}