package com.scm.scm2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String userDashboard(){

        return "user/dashboard";
    }


    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String userProfile(){

        return "user/profile";
    }
















}
