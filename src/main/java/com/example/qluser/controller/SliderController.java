package com.example.qluser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.qluser.entity.Users;
import com.example.qluser.service.ServiceImpl.UserServiceImpl;



@Controller
public class SliderController {
	@Autowired
	private UserServiceImpl userServiceIpl;
	@GetMapping("/register")
	public String createAcount(Model model) {
		model.addAttribute("userRegister", new Users());
		return "pages/register";
	}
	
	@PostMapping("/register/save")
	public String save(@Valid Users userRegister, BindingResult result, RedirectAttributes redirect) {
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
