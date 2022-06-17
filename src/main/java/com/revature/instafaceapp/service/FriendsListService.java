package com.revature.instafaceapp.service;

import com.revature.instafaceapp.entity.FriendsList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FriendsListService {

    List<FriendsList> getAllFriends();
    void addNewFriend(FriendsList newFriend);
    FriendsList findFriend(int userID);
    void updateFriend(FriendsList friendsList, int id);
}
