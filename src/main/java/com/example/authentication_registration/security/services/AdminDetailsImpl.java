package com.example.authentication_registration.security.services;

import com.example.authentication_registration.model.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class AdminDetailsImpl extends UserDetailsImpl{

    public AdminDetailsImpl(Admin rec,Collection<? extends GrantedAuthority> authorities) {
        super(rec.getId(),
                rec.getFullname(),
                rec.getEmail(),
                rec.getPassword(),
                authorities);
    }

    public static AdminDetailsImpl build(Admin ad) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new AdminDetailsImpl(
                ad,
                authorities);
    }
}
