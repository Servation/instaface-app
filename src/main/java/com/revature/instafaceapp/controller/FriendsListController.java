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
    public List<FriendsList> pendingList(@RequestBody User user) {
        System.out.println(user);
        List<FriendsList> test = service.getAllPendingFriends(user);
        System.out.println(test);
        return test;
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
                System.out.println("Friend request sent");
                return true;
            }else {
                System.out.println("Something went wrong, please try again.");
                return false;
            }
        } else {
            System.out.println("Friendship already exist.");
            return false;
        }
    }

    @CrossOrigin
    @PutMapping("/update")
    public boolean updateFriend(@RequestBody FriendsList updateFriend){
        if (!updateFriend.getStatus().isEmpty()) {
            service.updateFriend(updateFriend);
            System.out.println("friend updated");
            return true;
        } else {
            System.out.println("could not update friend");
            return false;
        }
    }
}
