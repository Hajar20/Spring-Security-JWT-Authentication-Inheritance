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

	public Applicant(String email, String password, String fullname,Date birthDate, String address, int phone) {
		super(email, password, fullname);
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

}