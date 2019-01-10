/**
 * 
 */
package com.example.qluser.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author User
 * @param <T>
 * @param <T>
 * @param <T>
 *
 */
public interface BaseRepository<T> extends CrudRepository<T, Integer>{
	public Iterable<T> findAll();
	public void save();
	public int update(T object);
	public void delete(T object);
	public T getByCode();
} 
