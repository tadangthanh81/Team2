package com.example.qluser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userRole")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userRoleId", nullable = false)
	private int userRolesID;

	@OneToOne
	@JoinColumn(name = "user_id")
	Users user;

	public int getUserRolesID() {
		return userRolesID;
	}

	public void setUserRolesID(int userRolesID) {
		this.userRolesID = userRolesID;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public UserRole(int userRolesID, Users user, Roles roles, String roleStatus, String createAt, String updateAt) {
		super();
		this.userRolesID = userRolesID;
		this.user = user;
		this.roles = roles;
		this.roleStatus = roleStatus;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	@OneToOne
	@JoinColumn(name = "role_id")
	Roles roles;

	@Column(name = "role_status", nullable = false, length = 50)
	private String roleStatus;

	@Column(name = "created_at", nullable = false, length = 50)
	private String createAt;

	@Column(name = "updated_at", nullable = false, length = 50)
	private String updateAt;

	public UserRole(Users users, Roles roles, String roleStatus, String createAt, String updateAt) {
		super();
		this.user = users;
		this.roles = roles;
		this.roleStatus = roleStatus;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public UserRole() {
		super();
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users users) {
		this.user = users;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}
}
