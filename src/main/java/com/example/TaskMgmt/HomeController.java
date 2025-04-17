package com.example.TaskMgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TaskMgmt.service.MailService;

@Controller
public class HomeController {

	@Autowired
    private MailService mailService;
	
    @GetMapping("/")
    public String index() {
    	mailService.sendEventReminders();
        return "index"; // maps to index.jsp
    }

    @GetMapping("/home")
    public String home() {
        return "Home"; // maps to Home.jsp
    }
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @GetMapping("/add-note")
    public String addNote() {
        return "AddNotes";
    }

    @GetMapping("/shared-notes")
    public String sharedNotes() {
        return "sharedNotes";
    }

    @GetMapping("/trash")
    public String showTrash() {
        return "showTrash";
    }

    @GetMapping("/update-trash")
    public String updateTrashUser() {
        return "updateTrashUser";
    }

//    @GetMapping("/calendar")
//    public String calendar() {
//        return "calendar";
//    }

    @GetMapping("/draw")
    public String draw() {
        return "draw";
    }

    @GetMapping("/user-panel")
    public String userPanel() {
        return "userPanel";
    }

    @GetMapping("/check-user")
    public String checkUserLogin() {
        return "checkUserLogin"; // Note: is this a typo? should it be checkUserLogin.jsp?
    }

//    @GetMapping("/error")
//    public String error() {
//        return "error"; // error.html, not JSP — let me know if you want this handled differently
//    }

    // These might be includes or templates, not full pages — used via JSP include?
    // If accessed directly, you can map them too:
    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/navbar")
    public String navbarNote() {
        return "navbarNote";
    }

    @GetMapping("/assets")
    public String allJsCss() {
        return "all_js_css";
    }
}