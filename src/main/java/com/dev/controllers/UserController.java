package com.dev.controllers;

import com.dev.dao.UserJdbcDao;
import com.dev.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// import java.util.List;

@Controller
public class UserController {

    private UserJdbcDao userJdbcDao;

    @Autowired
    public UserController(UserJdbcDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }
    @PostMapping("/register")
    @ResponseBody
    public User registerUser(User user) {
        userJdbcDao.createUser(user);
        System.out.println(user.toString());
        return user;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userJdbcDao.getAllUsers());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String getUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userJdbcDao.getUserById(id));
        return "user";
    }

    @GetMapping(value = {"/signin", "/login"})
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login2";
    }

    @GetMapping("/login.css")
    public String loginCss() {
        return "login.css";
    }

}
