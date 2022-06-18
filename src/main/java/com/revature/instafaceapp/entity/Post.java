package com.revature.instafaceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class Post {
    private int id;

    private int userId;
    private String imgURL;
    private String message;
    private boolean privacy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
