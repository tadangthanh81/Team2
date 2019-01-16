package gdp5.team2.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import gdp5.team2.cms.service.MenuService;
import gdp5.team2.cms.service.RolesService;
@Controller
public class MenuController {
	@Autowired
	RolesService rolesService;
	@Autowired
	MenuService menuService;

	@GetMapping("/index/menu")
	public String listMenu(Model model) {
		model.addAttribute("listMenu", menuService.findAll());
		model.addAttribute("listRoles", rolesService.findAll());
		return "/index";
	}
	
}







