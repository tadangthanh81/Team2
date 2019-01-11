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
@Table(name = "role_menu")
public class RoleMenu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private int idRoleMenu;

	public int getIdRoleMenu() {
		return idRoleMenu;
	}

	public void setIdRoleMenu(int idRoleMenu) {
		this.idRoleMenu = idRoleMenu;
	}

	public RoleMenu(int idRoleMenu, Menu menu, Roles roles, String menuStatus) {
		super();
		this.idRoleMenu = idRoleMenu;
		this.menu = menu;
		this.roles = roles;
		this.menuStatus = menuStatus;
	}

	@OneToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@OneToOne
	@JoinColumn(name = "role_id")
	private Roles roles;

	@Column(name = "menu_status", nullable = false, length = 50)
	private String menuStatus;

	public RoleMenu(Menu menu, Roles roles, String menuStatus) {
		super();
		this.menu = menu;
		this.roles = roles;
		this.menuStatus = menuStatus;
	}

	public RoleMenu() {
		super();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

}
