package com.lhlinh.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User {
	@Id
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="password")
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String fullName, String email, String mobile, String password) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + "]";
	}

}
