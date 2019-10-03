package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String listPosts(Model model) {
        List<Post> listPosts = postService.listAllPosts();
        model.addAttribute("listPosts", listPosts);
        return "posts";
    }

    @RequestMapping("/addpost")
    public String addUser(Model model){
        Post newPost = new Post();
        model.addAttribute("newPost", newPost);
        return "addpost";
    }

    @RequestMapping(value = "/savepost", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") Post post) {
        postService.savePost(post);
        return "redirect:/posts";
    }
}
