package com.as.controller;

import com.as.model.User;
import com.as.servise.UserServise;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserServise userServise;

    public UserController(UserServise userServise) {
        this.userServise = userServise;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServise.getAllUsers());
        return "/index";
    }

    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping("/new")
    public String addUser2(@ModelAttribute("user") User user) {
        userServise.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServise.getUserById(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update2(@ModelAttribute("user") User user,
                          @PathVariable("id") int id) {
        userServise.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServise.removeUserById(id);
        return "redirect:/";
    }
}
