package com.scm.scm2;

import com.scm.scm2.entities.User;
import com.scm.scm2.repositories.UserRepo;
import com.scm.scm2.helpers.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Scm2Application implements CommandLineRunner {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(Scm2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setName("admin");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoleList(List.of(AppConstants.ROLE_USER));
        user.setEmailVerified(true);
        user.setEnabled(true);
        user.setAbout("This is dummy user created initially");
        user.setPhoneVerified(true);

        userRepo.findByEmail("admin@gmail.com").ifPresentOrElse(
                u -> {},
                () -> {
                    userRepo.save(user);
                    System.out.println("✅ Admin user created");
                }
        );
    }
}
