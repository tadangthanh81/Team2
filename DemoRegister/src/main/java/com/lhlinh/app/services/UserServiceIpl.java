package com.lhlinh.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lhlinh.app.entities.User;
import com.lhlinh.app.repository.UserRepository;
@Service
public class UserServiceIpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> search(String q) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(q);
	}

	@Override
	public Optional<User> findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
		
	}

}
