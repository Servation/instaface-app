package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsListRepository extends JpaRepository<FriendsList, Integer> {
    @Query(
            value = "select * from friends_list f where f.requester = ?1 AND f.decider = ?2",
            nativeQuery = true
    )
    FriendsList getFriendRecord(int requester, int decider);

    @Query(
            value = "select * from friends_list f where f.requester = ?1 OR f.decider = ?1",
            nativeQuery = true
    )
    List<FriendsList> getAllFriends(int userId);

    @Query(
            value = "select * from friends_list f where (f.requester = ?1 OR f.decider = ?1) AND f.status = 'Pending'",
            nativeQuery = true
    )
    List<FriendsList> getPendingFriendsList(int userId);
}
