package gdp5.team2.cms.service;

import java.util.List;
import java.util.Optional;

import gdp5.team2.cms.entity.Roles;

public interface RolesService {

	Iterable<Roles> findAll();

	List<Roles> search(String q);

	Optional<Roles> findOne(int id);

	void save(Roles contact);

	void delete(int id);
	
	int maxId();
}
