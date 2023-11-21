package com.example.authentication_registration.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("recruiter")
public class Recruiter extends User implements Serializable {


    public Recruiter(String email, String password, String fullname, String image,char gender) {
        super(email, password, fullname, gender,image);
    }

// cascade = CascadeType.ALL

    public Recruiter() {}

}