package com.anhnguyen.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Personal")
public class Personal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Personal_Id")
	private int personalID;

	@Column(name = "First_Name", length = 20, nullable = false)
	private String firstName;

	@Column(name = "Last_Name", length = 20, nullable = false)
	private String lastName;

	@Column(name = "Mobile", length = 11, nullable = true)
	private String mobile;

	@Column(name = "Email", length = 50, nullable = true)
	private String email;

	@Column(name = "Hobbies", nullable = true)
	private String hobbies;

	@Column(name = "Description", length = 200, nullable = true)
	private String description;

	public Personal(int personalID, String firstName, String lastName, String mobile, String email, String hobbies,
			String description) {
		super();
		this.personalID = personalID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.hobbies = hobbies;
		this.description = description;
	}

	public Personal() {
		super();
	}

	public int getPersonalID() {
		return personalID;
	}

	public void setPersonalID(int personalID) {
		this.personalID = personalID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
