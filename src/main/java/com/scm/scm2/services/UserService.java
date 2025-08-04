package com.scm.scm2.services;

import com.scm.scm2.entities.User;

import java.util.*;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);

    boolean isUserExistById(String userId);
    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();


}
