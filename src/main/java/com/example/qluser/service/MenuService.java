package com.example.qluser.service;

import java.util.List;
import java.util.Optional;

import com.example.qluser.entity.Users;



public interface MenuService {
	Iterable<Users> findAll();

    List<Users> search(String q);

    Optional<Users> findOne(int id);

    void save(Users contact);

    void delete(int id);
}
