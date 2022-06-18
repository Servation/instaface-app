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
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User requester;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User decider;
    @Column(unique = true)
    private String status;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
