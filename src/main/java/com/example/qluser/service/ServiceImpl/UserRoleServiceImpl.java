package com.example.qluser.service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qluser.entity.Users;
import com.example.qluser.repository.UserRepository;
import com.example.qluser.service.UserService;
@Service
public class UserRoleServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userReposity;

	@Override
	public Iterable<Users> findAll() {
		// TODO Auto-generated method stub
		return userReposity.findAll();
	}

	@Override
	public List<Users> search(String q) {
		// TODO Auto-generated method stub
		return userReposity.findByEmail(q);
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

}
