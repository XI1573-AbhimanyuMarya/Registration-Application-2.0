package com.demo.registration.controller;

import com.demo.registration.model.User;
import com.demo.registration.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public User registerUser(User user) throws Exception {
        String userEmail = user.getEmail();
        if (userEmail != null && !"".equals(userEmail)) {
            User userObj = registrationService.fetchUserByEmailId(userEmail);
            if (userObj != null) {
                throw new Exception("User Email:  " + userEmail + " already Exists");
            }
        }

        User userObj = null;
        userObj = registrationService.saveUser(user);
        log.info(String.valueOf(userObj));
        return userObj;

    }

    @PostMapping("/login")
    public User loginUser(User user) throws Exception {
        String userEnteredEmail = user.getEmail();
        String userEnteredPassword = user.getPassword();
        User userObj = null;
        if (userEnteredEmail != null && userEnteredPassword != null) {
            userObj = registrationService.fetchUserByEmailIdAndPassword(userEnteredEmail, userEnteredPassword);

        }
        if (userObj == null) {
            throw new Exception("Bad Credentials");
        }
        return userObj;

    }

}
