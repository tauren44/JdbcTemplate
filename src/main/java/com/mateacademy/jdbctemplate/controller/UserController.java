package com.mateacademy.jdbctemplate.controller;

import com.mateacademy.jdbctemplate.model.User;
import com.mateacademy.jdbctemplate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService service;

    @GetMapping("/list")
    public String listUser(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "list-user";
    }

    @GetMapping("/create")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "show-user-form";
    }

    @GetMapping("/update")
    public String updateUser(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", service.findUserById(id));
        return "show-user-form";
    }

    @PostMapping("/processform")
    public String processForm(Model model, @ModelAttribute("user") User user) {
        service.createUser(user);
        model.addAttribute("users", service.getAllUsers());
        System.out.println("in process form");
        return "list-user";
    }

    @GetMapping("/delete")
    public String deleteUser(Model model, @RequestParam("id") Long id) {
        service.deleteUserById(id);
        model.addAttribute("customers", service.getAllUsers());
        return "list-customer";
    }
}
