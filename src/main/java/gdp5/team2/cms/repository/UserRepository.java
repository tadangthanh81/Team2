package gdp5.team2.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import gdp5.team2.cms.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{
	
	Optional<Users> findByEmail(String email);
	
	@Query(value="select concat(menu_name,',',roles.rolename)\n" + 
			"from role_menu\n" + 
			"inner join menu\n" + 
			"on menu.menu_id = role_menu.menu_id\n" + 
			"inner join roles\n" + 
			"on roles.role_id = role_menu.role_id\n" + 
			"where role_menu.role_id in(\n" + 
			"	select roles.role_id\n" + 
			"	from users\n" + 
			"	inner join userrole\n" + 
			"	on users.user_id = userrole.user_id\n" + 
			"	inner join roles\n" + 
			"	on userrole.role_id = roles.role_id\n" + 
			"	where users.user_id =:role_id\n" + 
			")",nativeQuery= true)
	List<String> authen(@Param("role_id") int id);
	
}
