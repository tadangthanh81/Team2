package com.example.qluser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qluser.entity.News;
import com.example.qluser.repository.NewsRepository;
@Service
public class NewsServiceImpl implements NewsService{

	@Autowired
	NewsRepository newsRepository;
	
	@Override
	public Iterable<News> findAll() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();
	}

	@Override
	public List<News> search(String title) {
		// TODO Auto-generated method stub
		return newsRepository.findByTitleContaining(title);
	}

	@Override
	public Optional<News> findOne(int id) {
		// TODO Auto-generated method stub
		return newsRepository.findById(id);
	}

	@Override
	public void save(News news) {
		// TODO Auto-generated method stub
		newsRepository.save(news);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
	}

	@Override
	public int maxId() {
		// TODO Auto-generated method stub
		return newsRepository.maxId();
	}

}
