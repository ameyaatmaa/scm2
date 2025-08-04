package com.scm.scm2.forms;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    private String name;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;


}
