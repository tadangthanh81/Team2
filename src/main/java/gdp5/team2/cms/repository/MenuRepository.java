/**
 * 
 */
package gdp5.team2.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import gdp5.team2.cms.entity.Menu;

/**
 * @author User
 *
 */
public interface MenuRepository extends CrudRepository<Menu, Integer> {
	List<Menu> findByMenuName(String menuName);
	
	@Query(value = "select max(m.menuID) from Menu m")
	int maxId();
}
