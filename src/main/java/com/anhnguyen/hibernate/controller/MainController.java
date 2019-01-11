package com.anhnguyen.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.anhnguyen.hibernate.entity.Personal;
import com.anhnguyen.hibernate.service.PersonalService;

@Controller
public class MainController {

	@Autowired
	PersonalService personalService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		List<Personal> personals = personalService.findAll();
		model.addAttribute("personals", personals);
		return "trangchu";
	}
	
	@RequestMapping(value="/personal/delete", method=RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam int personalID) {
		boolean check;
		check = personalService.delete(personalID);
		return ""+check;
	}
	
	 @PostMapping("/personal/insert")
     @ResponseBody
     public String insertPersonal(@RequestParam String firstName, @RequestParam String lastName,
                     @RequestParam String telephone, @RequestParam String email, @RequestParam String hobbies,
                     @RequestParam String description) {
             Personal personal = new Personal();
             personal.setFirstName(firstName);
             personal.setLastName(lastName);
             personal.setMobile(telephone);
             personal.setEmail(email);
             personal.setHobbies(hobbies);
             personal.setDescription(description);
             boolean check = personalService.insert(personal);
             return "" + check;
     }
	 
	 @PostMapping("/personal/update")
     @ResponseBody
     public String updatePersonal(@RequestParam int personalID, @RequestParam String firstName,
                     @RequestParam String lastName, @RequestParam String telephone, @RequestParam String email,
                     @RequestParam String hobbies, @RequestParam String description) {
             Personal personal = new Personal();
             personal.setPersonalID(personalID);
             personal.setFirstName(firstName);
             personal.setLastName(lastName);
             personal.setMobile(telephone);
             personal.setEmail(email);
             personal.setHobbies(hobbies);
             personal.setDescription(description);
             boolean check = personalService.update(personal);
             return "" + check;
     }
	 
	 @PostMapping("/login")
	 public String login(@RequestParam String firstName, @RequestParam String lastName, Model model) {
		 boolean check = personalService.login(firstName, lastName);
		 if(check) {
			 model.addAttribute("user", firstName);
			 return "index";
		 }else {
			 return "trangchu";
		 }	 
	 }
}
