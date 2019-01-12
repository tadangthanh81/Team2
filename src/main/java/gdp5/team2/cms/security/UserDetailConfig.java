/**
 * 
 */
package gdp5.team2.cms.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author User
 *
 */
public class UserDetailConfig implements UserDetails{

	private String iduser;
	private String username;
	private List<GrantedAuthority> role;
	
	public UserDetailConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailConfig(String iduser, String username,List<GrantedAuthority> role) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.role = role;
	}

	public String getIduser() {
		return iduser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.role;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
