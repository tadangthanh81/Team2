package com.example.qluser.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.qluser.entity.News;

public interface NewsRepository extends CrudRepository<News, Integer> {

}
