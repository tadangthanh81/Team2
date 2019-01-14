package com.example.qluser.service;

import java.util.List;
import java.util.Optional;

import com.example.qluser.entity.Users;



public interface UserService {
	Iterable<Users> findAll();

//    Users findByEMail(String email);

    Optional<Users> findOne(int id);

    void save(Users user);

    void delete(int id);
}
