package gdp5.team2.cms.service.ServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.repository.UserRepository;
import gdp5.team2.cms.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Optional<Users> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Set<Users> findAllUser() {
		return (Set<Users>) userRepository.findAll();
	}

	@Override
	public Set<String> authen(int id) {
		Set<String> listAuthen = new HashSet<>();
		List<String> s = userRepository.authen(id);
		for (String d : s) {
			String[] n = d.split(",");
			for (String j : n) {
				listAuthen.add(j);
			}
		}
		return listAuthen;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;

	}

	@Override
	public Users findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users register(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
