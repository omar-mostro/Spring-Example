package com.ejemplo.controller;

import com.ejemplo.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String redirectToLogin(){

        return "redirect:/login";

    }

    @GetMapping("/login")
    public String showLoginForm(@RequestParam (name = "error", required = false) String error){

        return "login";
    }

    @PostMapping
    public String loginCheck(@ModelAttribute (name = "userCredentials") UserCredential userCredential){

        if (userCredential.getUserName().equals("user") && userCredential.getPassword().equals("user")){

            return "contacts";
        }

        else {

            return "redirect:/login?error";
        }

    }
}
