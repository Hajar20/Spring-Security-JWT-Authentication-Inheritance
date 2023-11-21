package com.example.authentication_registration.model;
import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;

@Entity

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("applicant")
public class Applicant extends User implements Serializable {
	@Column
	private Date birthDate;
	@Column
	private String address;

	@Column
	private int phone;
	@Column
	private String status;



	public Applicant(String email, String password, String fullname,String image ,Date birthDate, String address, int phone,char gender) {
		super(email, password, fullname,gender,image);
		this.birthDate = birthDate;
		this.address = address;
		this.phone = phone;
	}

	public Applicant() {

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}