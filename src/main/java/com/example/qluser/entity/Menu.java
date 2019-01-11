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
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id", nullable=false)
	private int menuID;
	
	@Column(name="menu_name", nullable=false, length=225)
	private String menuName;
	
	@Column(name="menu_desc", nullable=false, length=225)
	private String descrpition;
	
	@Column(name="controller", nullable=false, length=150)
	private String controller;
	
	@Column(name="functions", nullable=false, length=225)
	private String functions;
	
	@OneToMany
	@JoinColumn(name="menu_id")
	Set<RoleMenu> roleMenus;
	
}
