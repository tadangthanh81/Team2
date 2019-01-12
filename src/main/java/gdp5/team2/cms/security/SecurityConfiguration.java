/**
 * 
 */
package gdp5.team2.cms.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author User
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled= true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests().antMatchers("/**","/login/**").permitAll();
//		.and()
//		.authorizeRequests().anyRequest().authenticated()
//		.and().formLogin();
//		.loginPage("pages/login.html").loginProcessingUrl("login").usernameParameter("email").passwordParameter("password").defaultSuccessUrl("index.html");
	}



//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("thanh@gmail.com").password("12345678").roles("ADMIN, CUSTOMER");
//	}
	
}
