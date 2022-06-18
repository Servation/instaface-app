package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendsListRepositoryTest {

    @Autowired
    FriendsListRepository repo;
    @Autowired
    UserRepository repo2;

    @Test
    public void SaveFriends() {
        List<User> user = repo2.findById(1).stream().collect(Collectors.toList());
        List<User> user1 = repo2.findById(2).stream().collect(Collectors.toList());
        System.out.println(user.get(0));

        FriendsList friendsList = FriendsList.builder()
                .requester(user.get(0))
                .requester(user1.get(0))
                .status("Pending")
                .build();

        repo.save(friendsList);
    }
}