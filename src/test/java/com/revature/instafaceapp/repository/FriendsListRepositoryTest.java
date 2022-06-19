package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendsListRepositoryTest {

    @Autowired
    FriendsListRepository repo;

    @Test
    public void SaveFriends() {
        FriendsList friendsList = FriendsList.builder()
                .requester(2)
                .decider(3)
                .status("Pending")
                .build();
        repo.save(friendsList);
    }

    @Test
    public void updateFriend() {
        System.out.println("something");
        FriendsList fListDb = repo.findById(1).get();
        System.out.println(fListDb);
        fListDb.setStatus("Approved");
        repo.save(fListDb);
    }
}