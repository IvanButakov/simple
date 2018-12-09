package com.but.simple;

import com.but.simple.entity.Role;
import com.but.simple.entity.User;
import com.but.simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Collections;

@SpringBootApplication
public class Application {
    @Autowired
    private UserRepository  userRepository;

    @PostConstruct
    public void setupDbWithData(){
        User user = new User();
        user.setPassword("password");
        user.setUsername("user");
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        User admin = new User();
        admin.setPassword("password");
        admin.setUsername("admin");
        admin.setActive(true);
        admin.setRoles(Collections.singleton(Role.ADMIN));
        userRepository.save(admin);

        User testuser = new User();
        testuser.setPassword("password");
        testuser.setUsername("testuser");
        testuser.setActive(true);
        testuser.setRoles(Collections.singleton(Role.TESTUSER));
        userRepository.save(testuser);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}