/**
 * 
 */
package gdp5.team2.cms.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.service.UserService;

/**
 * @author User
 *
 */
@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String pass, HttpServletResponse httpServletResponse) {
		Optional<Users> lsuser = userService.findByEmail(email);
		if (lsuser.isPresent()) {
			Users us = lsuser.get();
			if (pass.equals(us.getPassword())) {
				return "redirect:index.html";
			}
		}
		return "login.html";
	}
}
