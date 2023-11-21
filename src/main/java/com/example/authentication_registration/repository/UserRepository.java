package com.example.authentication_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authentication_registration.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String username);
    Boolean existsByEmail(String email);

}
