package gdp5.team2.cms.service.ServiceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gdp5.team2.cms.entity.Menu;
import gdp5.team2.cms.repository.MenuRepository;
import gdp5.team2.cms.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuRepository menuRepository;

	@Override
	public Iterable<Menu> findAll() {
		// TODO Auto-generated method stub
	
		return menuRepository.findAll();
	}

	@Override
	public List<Menu> search(String menuName) {
		// TODO Auto-generated method stub
		return menuRepository.findByMenuName(menuName);
	}

	@Override
	public Optional<Menu> findOne(int id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id);
	}

	@Override
	public void save(Menu contact) {
		// TODO Auto-generated method stub
		menuRepository.save(contact);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(id);
	}

	@Override
	public int maxId() {
		// TODO Auto-generated method stub
		return menuRepository.maxId();
	}

	

	
}
