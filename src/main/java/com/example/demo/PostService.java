package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postrepo;

    public List<Post> listAllPosts(){
        return postrepo.findAll();
    }

    public void savePost(Post post){
        postrepo.save(post);
    }

    public Post get(Long id){
        return postrepo.findById(id).get();
    }
    public void deletePost(Long id) {
        postrepo.deleteById(id);
    }
}
