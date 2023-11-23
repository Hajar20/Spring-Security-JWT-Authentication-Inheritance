package com.example.authentication_registration.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class SignupRequest {
  @NotBlank

  private String fullname;
  @NotBlank
  @Email
  private String email;
  private String role;
  @NotBlank
  private String password;
  private Date birthDate=null;
  private String address=null;
  private int phone=0;
  public String getFullname() {
    return fullname;
  }

  public void setFullname(String username) {
    this.fullname = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }



  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
