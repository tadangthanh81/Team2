package gdp5.team2.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private int userID;

	@Column(name = "fullname", nullable = false, length = 225)
	private String fullName;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "mobile", nullable = false, length = 20)
	private String mobile;

	@Column(name = "password", nullable = false, length = 225)
	private String password;

	@Column(name = "user_status", length = 225)
	private String userStatus;


	public Users(int userID, String fullName, String email, String mobile, String password, String userStatus) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.userStatus = userStatus;
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


}
