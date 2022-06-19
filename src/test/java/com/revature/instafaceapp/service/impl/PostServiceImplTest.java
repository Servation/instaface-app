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
                .imgURL("https://randompicturegenerator.com/img/cat-generator/g37b82da0af399ee430f5787f93289fa6bf0cee78a334568707574b938b0c2dd44c1e6505904a70b5cb55dbb1f3116639_640.jpg")
                .message("other image")
                .privacy(false)
                .userId(2)
                .build();
        service.addPost(post);
    }
}