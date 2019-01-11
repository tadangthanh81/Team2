package com.example.qluser.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.qluser.entity.Users;


public interface UserReposity extends CrudRepository<Users, Integer>{
	List<Users> findByEmail(String email);
}
