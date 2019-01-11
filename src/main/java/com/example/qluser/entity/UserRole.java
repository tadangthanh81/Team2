package com.example.qluser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userRole")
public class UserRole {

	@OneToOne
	@JoinColumn(name = "userID")
	Users users;

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
		this.users = users;
		this.roles = roles;
		this.roleStatus = roleStatus;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public UserRole() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
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
