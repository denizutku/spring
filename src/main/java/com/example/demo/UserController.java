package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService serviceUser;
    @Autowired
    private PostService postService;


    @RequestMapping("/")
    public String home(Model model) {
        List<Post> postList = postService.listAllPosts();
        model.addAttribute("postList", postList);
        return "index";
    }

    @RequestMapping("/adduser")
    public String add(Model model) {
        User newuser = new User();
        model.addAttribute("newuser", newuser);
        return "adduser";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        serviceUser.save(user);

        return "redirect:/";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        List<User> userList = serviceUser.listAll();
        model.addAttribute("userList", userList);
        return "users";

    }


}
