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
@Table(name = "role_menu")
public class RoleMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_role_menu")
	private int idRoleMenu;	

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name = "role_id")
	private Roles roles;

	@Column(name = "menu_status", nullable = false, length = 50)
	private String menuStatus;

	public RoleMenu(int idRoleMenu, Menu menu, Roles roles, String menuStatus) {
		super();
		this.idRoleMenu = idRoleMenu;
		this.menu = menu;
		this.roles = roles;
		this.menuStatus = menuStatus;
	}

	public RoleMenu() {
		super();
	}

	public int getIdRoleMenu() {
		return idRoleMenu;
	}

	public void setIdRoleMenu(int idRoleMenu) {
		this.idRoleMenu = idRoleMenu;
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
