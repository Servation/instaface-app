package com.revature.instafaceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class FriendsList {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    private int userIdRequester;
    private int userIdDecider;

    //used to conntect to users ID
//    @ManyToMany
//    private User userID;

}
