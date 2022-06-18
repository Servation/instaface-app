package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.repository.FriendsListRepository;
import com.revature.instafaceapp.service.FriendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsListServiceImpl implements FriendsListService {

    @Autowired
    private FriendsListRepository repo;

    @Override
    public List<FriendsList> getAllFriends() {
        return repo.findAll();
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
    public void updateFriend(FriendsList friendslist, int id) {
        FriendsList fListDb = repo.findById(id).get();
        repo.save(fListDb);
    }
}
