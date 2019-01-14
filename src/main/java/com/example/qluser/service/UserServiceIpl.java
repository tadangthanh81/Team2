package com.example.qluser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qluser.entity.Users;
import com.example.qluser.repository.UserReposity;

@Service
public class UserServiceIpl implements UserService {
	
	@Autowired
	private UserReposity userReposity;

	@Override
	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return userReposity.findAll();
	}

	
	@Override
	public Optional<Users> findOne(int id) {
		// TODO Auto-generated method stub
		return userReposity.findById(id);
	}

	@Override
	public void save(Users user) {
		userReposity.save(user);
		
	}

	@Override
	public void delete(int id) {
		userReposity.deleteById(id);
		
	}
	


//	@Override
//	public Users findByEMail(String email) {
//		// TODO Auto-generated method stub
//		userReposity.
//	}
//	

}