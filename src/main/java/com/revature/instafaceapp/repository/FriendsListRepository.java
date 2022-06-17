package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsListRepository extends JpaRepository<FriendsList, Integer> {
}
