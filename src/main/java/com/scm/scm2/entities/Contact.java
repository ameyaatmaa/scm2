package com.scm.scm2.entities;
import java.util.*;

import jakarta.persistence.*;

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

    @OneToMany(
            mappedBy = "contact",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<SocialLink> links = new ArrayList<>();

}