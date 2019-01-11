package com.anhnguyen.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhnguyen.hibernate.dao.PersonalDAO;
import com.anhnguyen.hibernate.entity.Personal;

@Service
public class PersonalService{

	@Autowired
	PersonalDAO personalDAO;
	
	public List<Personal> findAll() {
		return personalDAO.findAll();
	}
	
	public boolean insert(Personal personal) {
		boolean check = true;
		Personal checkPersonal = personalDAO.save(personal);
		if(checkPersonal==null) {
			return check;
		}
		else {
			return !check;
		}
	}
	
	public boolean update(Personal personal) {
		boolean check = true;
		Personal checkPersonal = personalDAO.save(personal);
		if(checkPersonal==null) {
			return check;
		}
		else {
			return !check;
		}
	}
	
	public boolean delete(int id) {
		boolean check = true;
		Personal personal = personalDAO.getOne(id);
		try {
			personalDAO.delete(personal);
			return check;
		}
		catch(Exception e) {
			return !check;
		}
	}
	
	public Personal getOne(int id) {
		return personalDAO.getOne(id);
	}
	
	public List<Personal> getByName(String lastName) {
		return personalDAO.findBylastNameContaining(lastName);
	}
	
	public boolean login(String firstName, String lastName) {
		boolean check = true;
		Personal personal = personalDAO.findByFullName(firstName, lastName);
		if(personal == null) {
			return !check;
		}
		else {
			return check;
		}
	}
}
