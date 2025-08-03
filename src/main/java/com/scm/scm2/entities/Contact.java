package com.scm.scm2.entities;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Contact {

    @Id
    private String id;
    private String name;
    private String Email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 10000)
    private String description;
    private boolean favorite=false;
    private String websiteLink;
    private String linkedInLink;

    //    private List<String> SocialLinks = new ArrayList<>();
//
    @ManyToOne
    private User user;

}