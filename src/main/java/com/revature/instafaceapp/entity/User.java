package com.revature.instafaceapp.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Builder
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
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
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
