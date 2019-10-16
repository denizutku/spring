package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String listPosts(Model model) {
        List<Post> postList = postService.listAllPosts();
        model.addAttribute("listPosts", postList);
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

    @RequestMapping(value = "/delete/{id}")
    public String deletePost(@PathVariable(name = "id") Long id){
        postService.deletePost(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editPost(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("edit_post");
        Post post = postService.get(id);
        mav.addObject("addPost", post);
        return mav;
    }


}
