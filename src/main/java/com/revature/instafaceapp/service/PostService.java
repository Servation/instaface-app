package com.revature.instafaceapp.service;

import com.revature.instafaceapp.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    List<Post> getAllFriendPostByUserId();
    List<Post> getPostByUserId(int id);
    List<Post> getAllPublicPost();
    void addPost(Post post);
}
