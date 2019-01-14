package com.example.qluser.repository;

import java.util.List;

import org.apache.commons.digester.plugins.strategies.FinderFromClass;
import org.springframework.data.repository.CrudRepository;

import com.example.qluser.entity.Users;





public interface UserReposity extends CrudRepository<Users, Integer>{
//	Users findByEmail(String email);
	
}
