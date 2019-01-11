package com.lhlinh.app.controller;

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

import com.lhlinh.app.entities.User;
import com.lhlinh.app.services.UserServiceIpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceIpl userServiceIpl;

	@GetMapping("/user")
	public String index(Model model) {
		model.addAttribute("users", userServiceIpl.findAll());
		return "list";
	}

	@GetMapping("/user/create")
	public String create(Model model) {
		model.addAttribute("user2", new User());
		return "form";
	}

	@GetMapping("/user/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("user2", userServiceIpl.findOne(id));
		return "form";
	}

	@PostMapping("/user/save")
	public String save(@Valid User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		userServiceIpl.save(user);
		redirect.addFlashAttribute("success", "Saved employee successfully!");
		return "redirect:/user";
	}

	@GetMapping("/user/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		userServiceIpl.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/user";
	}

	@GetMapping("/user/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/user";
		}

		model.addAttribute("users", userServiceIpl.search(s));
		return "list";
	}
}
