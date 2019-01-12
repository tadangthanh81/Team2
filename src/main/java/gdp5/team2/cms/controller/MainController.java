/**
 * 
 */
package gdp5.team2.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author User
 *
 */
@Controller
public class MainController {
	@RequestMapping("/")
	public String login() {
		return "pages/login.html";
	}
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
}
