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
    @PostMapping("/add")
    public String addFriend(@RequestBody FriendsList newFriend){
        service.addNewFriend(newFriend);
        return "Friend request sent.";
    }

//    @CrossOrigin
//    @PostMapping("/update")
//    public String updateFriend();

}
