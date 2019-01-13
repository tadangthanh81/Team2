/**
 * 
 */
package gdp5.team2.cms.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.repository.UserRepository;
import gdp5.team2.cms.service.ServiceImpl.UserServiceImpl;

/**
 * @author User
 *
 */
public class UserDetailConfig implements UserDetailsService {

	UserRepository userRepository;

	private List<? extends GrantedAuthority> getAuthorities(int idUser) {
//			Set<GrantedAuthority> listAuthen = new HashSet<>();
//			List<GrantedAuthority> s = userRepository.authen(idUser);
//			for (GrantedAuthority d : s) {
//				String[] n = d.split(",");
//				for (String j : n) {
//					listAuthen.add(j);
//				}
//			}
			return null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Users> user = userRepository.findByEmail(email);
		int iduser = (int) user.get().getUserID();

		return new org.springframework.security.core.userdetails.User("Mai Hoang Anh", "12345678",
				getAuthorities(iduser));

//				User(
//		          user.getEmail(), user.getPassword(), user.isEnabled(), true, true, 
//		          true, getAuthorities(user.getRoles()));
	}

}
