package com.scm.scm2.controllers;

import com.scm.scm2.forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        System.out.println("home page handler");
        return "home"; // Name of the HTML or JSP page (e.g., home.html in templates)
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About");
        System.out.println("about page handler");
        return "about"; // maps to about.html
    }

    @RequestMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "Services");
        System.out.println("services page handler");
        return "services"; // maps to about.html
    }

    @RequestMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();


        model.addAttribute("userForm", userForm);



        return "register"; // maps to about.html
    }
    // Register processing handelr
@RequestMapping(value = "/do-register" , method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("do register page handler");







        return "redirect:/register";

    }


}
