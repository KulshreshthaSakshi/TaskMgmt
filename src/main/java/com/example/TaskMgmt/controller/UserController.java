package com.example.TaskMgmt.controller;

import com.example.TaskMgmt.entity.User;
import com.example.TaskMgmt.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String saveUser(
            @RequestParam String email,
            @RequestParam String fname,
            @RequestParam String lname,
            @RequestParam String pass) {

        User user = new User(email, fname, lname, pass);
        boolean saved = userService.saveUser(user);
        return saved ? "redirect:/login" : "redirect:/register";
    }
    
    
    
//    @GetMapping("/userPanel")
//    public String userPanel(HttpSession session, HttpServletRequest request) {
//        String email = (String) session.getAttribute("email");
//        User user = userService.getUserByEmail(email);
//        request.setAttribute("user", user);
//        return "userPanel.jsp";
//    }
//    
//    @PostMapping("/updateUser")
//    public String updateUser(HttpServletRequest request) {
//        String firstName = request.getParameter("first_name");
//        String lastName = request.getParameter("last_name");
//        String email = request.getParameter("email");
//        String otp = request.getParameter("otp");
//
//        // Update logic...
//        userService.updateUser(firstName, lastName, email, otp);
//
//        return "redirect:/userPanel"; // or to a success page
//    }

}
