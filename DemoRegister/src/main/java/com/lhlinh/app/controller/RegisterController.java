package com.lhlinh.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lhlinh.app.entities.User;
import com.lhlinh.app.services.UserServiceIpl;

@Controller
public class RegisterController {

	@Autowired
	private UserServiceIpl userServiceIpl;
	@GetMapping("/register")
	public String createAcount(Model model) {
		model.addAttribute("userRegister", new User());
		return "pages/register";
	}
	
	@PostMapping("/register/save")
	public String save(@Valid User userRegister, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "pages/register";
		}
		userServiceIpl.save(userRegister);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin")
	public String returnAdmin(Model model) {
		return "pages/login";
	}

}
