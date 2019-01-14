package com.example.qluser.service;

import java.util.List;
import java.util.Optional;

import com.example.qluser.entity.News;

public interface NewsService {

	Iterable<News> findAll();

	List<News> search(String q);

	Optional<News> findOne(int id);

	void save(News contact);

	void delete(int id);
	
	int maxId();
}
