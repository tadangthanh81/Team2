/**
 * 
 */
package gdp5.team2.cms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import gdp5.team2.cms.entity.Roles;

public interface RolesRepository  extends CrudRepository<Roles, Integer>{
	List<Roles> findByRoleName(String rolename);
	
	@Query(value="select max(r.roleID) from Roles r")
	int maxId();
}
