package com.scm.scm2.controllers;

import com.scm.scm2.entities.User;
import com.scm.scm2.forms.UserForm;
import com.scm.scm2.helpers.Message;
import com.scm.scm2.helpers.MessageType;
import com.scm.scm2.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
                                  HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // TODO::Validate userForm[Next Video]

        // save to database

        // userservice

        // UserForm--> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic(
        // "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        // add the message:

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }



}
