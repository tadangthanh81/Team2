package gdp5.team2.cms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gdp5.team2.cms.entity.Users;


public interface UserRepository extends CrudRepository<Users, Integer>{
	List<Users> findByEmail(String email);
}
