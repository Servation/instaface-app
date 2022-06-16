package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2")
    User findByLogin(String email, String password);

    @Query("SELECT u From User u WHERE u.email=?1")
    User findByEmail(String email);
}
