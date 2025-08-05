package com.scm.scm2.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    private String userId;

    @Column(name="user_name",nullable=false)
    private String name;
    @Column(name="email",nullable=false,unique=true)
    private String email;
    private String password;

    @Column(length = 10000)
    private String about;

    @Column(length = 10000)
    private String profilePic;
    private String phoneNumber;

    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    // self google ,fb ,github etc how its signing up
    @Enumerated(value= EnumType.STRING)
    private Providers provider=Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL,fetch =  FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts= new ArrayList<>();


}
