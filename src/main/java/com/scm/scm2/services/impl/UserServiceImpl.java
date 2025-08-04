package com.scm.scm2.services.impl;

import com.scm.scm2.entities.User;
import com.scm.scm2.helpers.ResourceNotFoundException;
import com.scm.scm2.repositories.UserRepo;
import com.scm.scm2.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService
{

@Autowired
private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
      User user2 =  userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
   user2.setName(user.getName());
   user2.setEmail(user.getEmail());
   user2.setPassword(user.getPassword());
   user2.setPhoneNumber(user.getPhoneNumber());
   user2.setAbout(user.getAbout());
   user2.setProfilePic(user.getProfilePic());
   user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        // save the user in database
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public boolean isUserExistById(String userId) {
        return false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
