package com.lhlinh.app.services;

import java.util.List;
import java.util.Optional;

import com.lhlinh.app.entities.User;

public interface UserService {
	Iterable<User> findAll();

    List<User> search(String q);

    Optional<User> findOne(int id);

    void save(User contact);

    void delete(int id);
}
