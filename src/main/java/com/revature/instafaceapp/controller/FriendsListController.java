package com.revature.instafaceapp.controller;

import com.revature.instafaceapp.entity.FriendsList;
import com.revature.instafaceapp.service.FriendsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/friends")
@RestController
public class FriendsListController {

    @Autowired
    private FriendsListService service;

    @CrossOrigin
    @GetMapping("/friendlist")
    public List<FriendsList> friendsLists() {
        return service.getAllFriends();
    }

    @CrossOrigin
    @PutMapping("/getrecord")
    public FriendsList getFriendRecordByUserIds(@RequestBody FriendsList friendRecord) {
        return service.getRecordByUserIds(friendRecord.getRequester(), friendRecord.getDecider());
    }


    @CrossOrigin
    @PostMapping("/add")
    public boolean addFriend(@RequestBody FriendsList newFriend){
        if (newFriend != null) {
            System.out.println(newFriend);
            service.addNewFriend(newFriend);
            System.out.println("Friend request sent");
            return true;
        }else {
            System.out.println("Something went wrong, please try again.");
            return false;
        }
    }

    @CrossOrigin
    @PutMapping("/update")
    public String updateFriend(@RequestBody FriendsList updateFriend){
        if (!updateFriend.getStatus().isEmpty()) {
            service.updateFriend(updateFriend);
            return "friend updated";
        } else {
            return "could not update";
        }
    }

}
