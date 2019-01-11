/**
 * 
 */
package gdp5.team2.cms.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author User
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@PathVariable Map<String, String> infoLogin) {
		String username = infoLogin.get("username");
		return "index.html";
	}
}
