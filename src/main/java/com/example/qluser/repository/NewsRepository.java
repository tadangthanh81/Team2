package com.example.qluser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.qluser.entity.News;

public interface NewsRepository extends CrudRepository<News, Integer> {

	 List<News> findByTitleContaining(String q);
	
	@Query(value="select max(n.newsID) from News n")
	int maxId();
}
