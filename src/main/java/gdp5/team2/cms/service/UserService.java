package gdp5.team2.cms.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Users;

@Service
public interface UserService {
	Optional<Users> findByEmail(String name);
	
	Set<Users> findAllUser();
	
	Set<String> authen(int id);
	
	Users findOne(int id);
	
	Users register(Users user);
	
	void delete(int id);
	
}
