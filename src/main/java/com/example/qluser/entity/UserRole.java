package com.example.qluser.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_RoleId", nullable = false)
	private int userRolesID;

	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "user_id")
	Users user;

	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "role_id")
	Roles roles;

	@Column(name = "role_status", nullable = false, length = 50)
	private String roleStatus;

	@Column(name = "created_at", nullable = false, length = 50)
	private String createdAt;

	@Column(name = "updated_at", nullable = false, length = 50)
	private String updatedAt;

	public UserRole(int userRolesID, Users user, Roles roles, String roleStatus, String createdAt, String updatedAt) {
		super();
		this.userRolesID = userRolesID;
		this.user = user;
		this.roles = roles;
		this.roleStatus = roleStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserRole() {
		super();
	}

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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}	
}
