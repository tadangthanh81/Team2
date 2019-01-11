package com.anhnguyen.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anhnguyen.hibernate.entity.Personal;
@Repository
public interface PersonalDAO extends JpaRepository<Personal, Integer> {
	List<Personal> findBylastNameContaining(String lastName);
	
	@Query(value="select p from Personal p where p.firstName=?1 and p.lastName=?2")
	Personal findByFullName(String firstName, String lastName);
}
