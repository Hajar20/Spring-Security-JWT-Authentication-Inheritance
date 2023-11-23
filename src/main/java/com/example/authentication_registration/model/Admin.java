package com.example.authentication_registration.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("admin")
public class Admin extends User implements Serializable {
    public Admin() {
    }
    public Admin(String email, String password, String fullname) {
        super(email, password, fullname);
    }
}