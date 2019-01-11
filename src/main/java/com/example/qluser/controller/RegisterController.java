package com.example.qluser.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.qluser.entity.Users;
import com.example.qluser.service.UserServiceIpl;



@Controller
public class RegisterController {
	@Autowired
	private UserServiceIpl userServiceIpl;
	@GetMapping("/register")
	public String createAcount(Model model) {
		model.addAttribute("userRegister2", new Users());
		return "pages/register";
	}
	
	@PostMapping("/register/save")
	public String save(@Valid Users userRegister, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "pages/register";
		}
		List<Users> listUser = (List<Users>) userServiceIpl.findAll();
		boolean checkEmail = true;
		for (Users users : listUser) {
			if(users.getEmail().equals(userRegister.getEmail())) {
				checkEmail = false;
			}
		}
		if(!checkEmail) {
			return "pages/register";
		}
		userServiceIpl.save(userRegister);
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String returnAdmin(Model model) {
		return "index";
	}

}
