package com.example.qluser.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false)
	private int roleID;

	@Column(name = "rolename", nullable = false, length = 225)
	private String roleName;

	@Column(name = "role_desc", nullable = false, length = 150)
	private String descrpition;

	@OneToMany
	@JoinColumn(name = "role_id")
	Set<RoleMenu> roleMenus;

	@OneToMany
	@JoinColumn(name = "role_id")
	Set<UserRole> userRoles;

	public Roles(int roleID, String roleName, String descrpition, Set<RoleMenu> roleMenus) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.descrpition = descrpition;
		this.roleMenus = roleMenus;
	}

	public Roles() {
		super();
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescrpition() {
		return descrpition;
	}

	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
	}

	public Set<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
