package gdp5.team2.cms.service;

import java.util.List;
import java.util.Optional;

import gdp5.team2.cms.entity.Menu;

public interface MenuService {
	
	Iterable<Menu> findAll();
	List<Menu> search(String q);

	Optional<Menu> findOne(int id);

	void save(Menu contact);

	void delete(int id);
	
	int maxId();

	
}
