package com.example.authentication_registration.controller;

import com.example.authentication_registration.model.Admin;
import com.example.authentication_registration.model.Applicant;
import com.example.authentication_registration.model.Recruiter;
import com.example.authentication_registration.model.User;
import com.example.authentication_registration.payload.request.LoginRequest;
import com.example.authentication_registration.payload.request.SignupRequest;
import com.example.authentication_registration.payload.response.JwtResponse;
import com.example.authentication_registration.payload.response.MessageResponse;
import com.example.authentication_registration.repository.UserRepository;
import com.example.authentication_registration.security.jwt.JwtUtils;
import com.example.authentication_registration.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Tonarose/hajar")
public class API {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), (loginRequest.getPassword())));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        System.out.println("roles :"+roles);
        if(roles.contains("ROLE_APPLICANT")){
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getFullName(),
                    userDetails.getUsername(),
                    userDetails.getBirthDate(),
                    userDetails.getAddress(),
                    userDetails.getPhone(),
                    roles));
        }
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getFullName(),
                userDetails.getUsername(),
                roles));

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFullname());

        String strRoles = signUpRequest.getRole();
         System.out.println("role :"+strRoles);
        if (strRoles == null) {
            signUpRequest.setRole("user"); userRepository.save(user);
        } else {
                switch (strRoles) {
                    case "admin":
                        Admin admin = new Admin(user.getEmail(),user.getPassword(),user.getFullname());
                        userRepository.save(admin);
                        break;
                    case "recruiter":
                        Recruiter rec = new Recruiter(user.getEmail(),user.getPassword(),user.getFullname());
                        userRepository.save(rec);
                        break;
                    case "applicant" :
                                Applicant applicant = new Applicant(
                                signUpRequest.getEmail(),
                                encoder.encode(signUpRequest.getPassword()),
                                signUpRequest.getFullname(),
                                signUpRequest.getBirthDate(),
                                signUpRequest.getAddress(),
                                signUpRequest.getPhone()
                        );

                        userRepository.save(applicant);
                        break;
                    default:
                        return ResponseEntity.ok(new MessageResponse("RoleNotFoundException !!!"));

            }
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
