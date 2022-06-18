package com.revature.instafaceapp.controller;


import com.revature.instafaceapp.entity.Post;
import com.revature.instafaceapp.entity.User;
import com.revature.instafaceapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/Posts")
@RestController
public class PostController {
    @Autowired
    private PostService service;


    @CrossOrigin
    @GetMapping
    public List<Post> getAllPost() {
        return service.getAllPublicPost();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public List<Post> getPostById(@PathVariable int id) {
        return service.getPostByUserId(id);
    }

    @CrossOrigin
    @PostMapping()
    public void addPost(@RequestBody Post post){
        service.addPost(post);
    }
}
