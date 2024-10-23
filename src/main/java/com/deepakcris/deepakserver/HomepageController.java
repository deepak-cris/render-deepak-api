package com.deepakcris.deepakserver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/")
    public String homePage(Model model) {
        // Adding website owner information to the model
        model.addAttribute("name", "Deepak Kumar");
        model.addAttribute("bio", "A passionate software engineer and technology enthusiast.");
        model.addAttribute("email", "deepak.cris2030@gmail.com");
        model.addAttribute("socialMedia", new String[]{"GitHub", "LinkedIn", "Twitter"});

        return "home";  // Returns home.html from templates folder
    }
}