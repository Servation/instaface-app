package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.Post;
import com.revature.instafaceapp.repository.PostRepository;
import com.revature.instafaceapp.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    private PostService service;

    @Test
    void getAllFriendPostByUserId() {
    }

    @Test
    void getPostByUserId() {
    }

    @Test
    void getAllPublicPost() {
        System.out.println(service.getAllPublicPost());
    }

    @Test
    void addPost() {
        Post post = Post.builder()
                .imgURL("more.com")
                .message("Test Me123ssage2")
                .privacy(false)
                .userId(2)
                .build();
        service.addPost(post);
    }
}