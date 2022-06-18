package com.revature.instafaceapp.repository;

import com.revature.instafaceapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int Id);
}
