package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.service.FriendsListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendsListServiceImplTest {

    @Autowired
    private FriendsListService service;

    @Test
    void getRecordByUserIds() {
        System.out.println(service.getRecordByUserIds(16, 34));
    }
}