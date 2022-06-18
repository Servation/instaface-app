package com.revature.instafaceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String description;
    private String occupation;
    private String city;
    private String nationality;
    private String hobbies;
    private String facebook;
    private String twitter;
    private String linkedin;
    private String imgURL;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
