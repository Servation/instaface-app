package com.revature.instafaceapp.controller;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.service.FriendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/friends")
@RestController
public class FriendsListController {

    @Autowired
    private FriendsListService service;

    @CrossOrigin
    @GetMapping("/friendlist")
    public List<FriendsList> friendsLists(@RequestBody User user) {
        return service.getAllFriends(user);
    }

    @CrossOrigin
    @PostMapping("/searchfriendlist")
    public List<FriendsList> pendingList(@RequestBody FriendsList friendsList) {
        return service.getAllFriends(friendsList);
    }

    @CrossOrigin
    @PutMapping("/getrecord")
    public FriendsList getFriendRecordByUserIds(@RequestBody FriendsList friendRecord) {
        return service.getRecordByUserIds(friendRecord.getRequester(), friendRecord.getDecider());
    }

    @CrossOrigin
    @PostMapping("/add")
    public boolean addFriend(@RequestBody FriendsList newFriend){
        if (service.getRecordByUserIds(newFriend.getDecider(), newFriend.getRequester()) == null) {
            if (newFriend.getDecider() != newFriend.getRequester()) {
                System.out.println(newFriend);
                service.addNewFriend(newFriend);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @CrossOrigin
    @PutMapping("/update")
    public boolean updateFriend(@RequestBody FriendsList updateFriend){
        if (!updateFriend.getStatus().isEmpty()) {
            service.updateFriend(updateFriend);
            return true;
        }
        return false;
    }
}
