package com.example.authentication_registration.payload.response;

import java.util.Date;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String fullName;
  private String email;
  private List<String> roles;

  private  Date birthDate;
  private String address;
  private int phone;

  public JwtResponse(String accessToken, Long id, String username, String email,List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.fullName = username;
    this.email = email;
    this.roles = roles;
  }
  public JwtResponse(String accessToken, Long id, String username, String email,Date birthday,String address,int phone, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.fullName = username;
    this.email = email;
    this.birthDate = birthday;
    this.address = address;
    this.phone = phone;

    this.roles = roles;
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

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String username) {
    this.fullName = username;
  }

  public List<String> getRoles() {
    return roles;
  }
}
