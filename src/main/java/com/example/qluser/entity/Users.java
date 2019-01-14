package com.example.qluser.entity;




import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private int userID;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "password")
	private String password;

	@Column(name = "user_status")
	private String userStatus;
//	@Column(name = "confirmation_token")
//	private String confirmationToken;
	
//public String getConfirmationToken() {
//		return confirmationToken;
//	}
//
//	public void setConfirmationToken(String confirmationToken) {
//		this.confirmationToken = confirmationToken;
//	}


//	@JsonIgnore
//	   @ManyToOne
//	   @JoinColumn(name = "passagier_id") 
//	   private Passagier passagier;

//	private Set<News> news;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userN")
	private List<News> news = new ArrayList<>();

	public Users(int userID, String fullName, String email, String mobile, String password, String userStatus,
			List<News> news) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.userStatus = userStatus;
		this.news = news;
	}

	public Users() {
		super();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

}
