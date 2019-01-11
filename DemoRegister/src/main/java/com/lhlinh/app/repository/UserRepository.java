package com.lhlinh.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lhlinh.app.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
List<User> findByEmail(String email);
}
