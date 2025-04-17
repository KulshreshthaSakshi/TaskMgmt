package com.example.TaskMgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.TaskMgmt.entity.User;
import com.example.TaskMgmt.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
	@Autowired
    UserService userService;
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session, RedirectAttributes redirectAttrs) {
    	
		User user = userService.authenticate(email, password);
        if (user != null) {
            session.setAttribute("email", user.getEmail());
            
            return "redirect:/home";
        } else {
            redirectAttrs.addFlashAttribute("error", "Invalid email or password.");
            return "redirect:/login";
        }
    }
}