package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsListRepository extends JpaRepository<FriendsList, Integer> {
    @Query(
            value = "select * from friends_list f where f.requester = ?1 AND f.decider = ?2",
            nativeQuery = true
    )
    FriendsList getFriendRecord(int requester, int decider);
}
