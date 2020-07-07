package com.demo.registration.service;

import com.demo.registration.model.User;
import com.demo.registration.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepo registrationRepo;
 public User saveUser(User user)
 {
     return registrationRepo.save(user);
 }

 public User fetchUserByEmailId(String email)
 {
     return registrationRepo.findByEmail(email);
 }

    public User fetchUserByEmailIdAndPassword(String email, String password)
    {
        return registrationRepo.findByEmailAndPassword(email,password);
    }

}
