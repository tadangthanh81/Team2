package gdp5.team2.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import gdp5.team2.cms.entity.Roles;
import gdp5.team2.cms.service.MenuService;
import gdp5.team2.cms.service.RolesService;

@Controller
public class RoleController {
	@Autowired
	RolesService rolesService;
	@Autowired
	MenuService menuService;
	@GetMapping("/index/roles")
	public String listRoles(Model model) {
		model.addAttribute("listRoles", rolesService.findAll());
		model.addAttribute("listMenu", menuService.findAll());
		return "/index";
	}
	
	/*
	 * @GetMapping("/roles/create") public String CreateRoles(Model model) { int max
	 * = rolesService.maxId() + 1; model.addAttribute("roles", new Roles(max));
	 * return "pages/addRoles"; }
	 * 
	 * @GetMapping("/roles/view/{id}") public String viewRoles(@PathVariable int
	 * id,Model model) { model.addAttribute("roles", rolesService.findOne(id));
	 * return "pages/infoRoles"; }
	 * 
	 * @PostMapping("/roles/save") public String saveRoles(@Valid Roles roles,
	 * BindingResult bindingResult, RedirectAttributes redirect) {
	 * if(bindingResult.hasErrors()) { return "pages/addNews"; }
	 * rolesService.save(roles); redirect.addFlashAttribute("success",
	 * "Add roles success!"); return "redirect:/index/roles"; }
	 * 
	 * @GetMapping("/roles/edit/{id}") public String editRoles(@PathVariable int
	 * id,Model model) { model.addAttribute("news", rolesService.findOne(id));
	 * return "pages/addRoles"; }
	 * 
	 * @GetMapping("/roles/delete/{id}") public String deleteRoles(@PathVariable int
	 * id, RedirectAttributes redirect) { rolesService.delete(id);
	 * redirect.addFlashAttribute("success", "Delete roles success!"); return
	 * "redirect:/index/roles"; }
	 * 
	 * @GetMapping("/roles/search") public String searchRoles(@RequestParam String
	 * rolename,Model model) { if (rolename.equals("")) { return
	 * "redirect:/index/roles"; } model.addAttribute("listRoles",
	 * rolesService.search(rolename)); return "pages/listRoles"; }
	 */
}
