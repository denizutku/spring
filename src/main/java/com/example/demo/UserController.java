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


    @RequestMapping("/")
    public String home(Model model) {
        List<User> listUsers = serviceUser.listAll();
        model.addAttribute("listUsers", listUsers);
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


}
