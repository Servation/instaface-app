package com.revature.instafaceapp.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class FriendsList {
    @Id
    @SequenceGenerator(
            name = "friends_sequence",
            sequenceName = "friends_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "friends_sequence"
    )
    private int friendsId;
    private int requester;
    private int decider;
    private String status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
