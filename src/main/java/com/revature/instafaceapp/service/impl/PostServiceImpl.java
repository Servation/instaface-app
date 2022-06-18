package com.revature.instafaceapp.service.impl;

import com.revature.instafaceapp.entity.Post;
import com.revature.instafaceapp.repository.PostRepository;
import com.revature.instafaceapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public List<Post> getAllFriendPostByUserId() {
        return null;
    }

    @Override
    public List<Post> getPostByUserId(int id) {
        return repository.findByUserId(id);
    }

    @Override
    public List<Post> getAllPublicPost() {
        return repository.findByPrivacy(false);
    }

    @Override
    public void addPost(Post post) {
        repository.save(post);
    }
}
