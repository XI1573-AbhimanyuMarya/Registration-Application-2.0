package com.demo.registration.repository;

import com.demo.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo  extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);
}
