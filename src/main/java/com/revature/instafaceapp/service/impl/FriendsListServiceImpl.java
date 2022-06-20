package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.repository.FriendsListRepository;
import com.revature.instafaceapp.repository.UserRepository;
import com.revature.instafaceapp.service.FriendsListService;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsListServiceImpl implements FriendsListService {

    @Autowired
    private FriendsListRepository repo;

    @Override
    public List<FriendsList> getAllFriends(User user) {
        return repo.getAllFriends(user.getId()).stream().toList();
    }

    @Override
    public List<FriendsList> getAllFriends(FriendsList friendsList) {
        return repo.getFriendsList(friendsList.getRequester(), friendsList.getStatus()).stream().toList();
    }

    @Override
    public void addNewFriend(FriendsList newFriend) {
        repo.save(newFriend);
    }

    @Override
    public FriendsList findFriend(int userID) {
        return repo.findById(userID).get();
    }

    @Override
    public void updateFriend(FriendsList updateFriend) {
        System.out.println("inside update");
        System.out.println(updateFriend);
        FriendsList fListDb = repo.findById(updateFriend.getFriendsId()).get();
        System.out.println(fListDb);
        fListDb.setStatus(updateFriend.getStatus());
        repo.save(fListDb);
    }

    @Override
    public FriendsList getRecordByUserIds(int userId1, int userId2) {

        FriendsList friendRecord = repo.getFriendRecord(userId1, userId2);
        if (friendRecord == null) {
            friendRecord = repo.getFriendRecord(userId2, userId1);
        }
        return friendRecord;
    }

}
