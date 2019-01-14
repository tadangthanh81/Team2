package com.example.qluser.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.qluser.entity.Users;
import com.example.qluser.service.EmailService;
import com.example.qluser.service.UserServiceIpl;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
@Controller
public class RegisterController {
	
	@Autowired
	private UserServiceIpl userServiceIpl;
	 @Autowired
	    public JavaMailSender emailSender;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	public RegisterController(UserServiceIpl userServiceIpl, JavaMailSender emailSender) {
		super();
		this.userServiceIpl = userServiceIpl;
		this.emailSender = emailSender;
	}



	@GetMapping("/register")
	public String createAcount(Model model) {
		model.addAttribute("userRegister", new Users());
		return "pages/register";
	}
	


	@PostMapping("/register/save")
	public String save(@Valid Users userRegister2, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "pages/register";
		}
		
		
		else {
			String emailRegister = userRegister2.getEmail();
			Iterable<Users> listUser = userServiceIpl.findAll();
			for (Users u : listUser) {
				if(emailRegister.contains(u.getEmail())) {
					redirect.addFlashAttribute("fail", "Email had exists!");
					return "redirect:/register";
				}
			}
			
			String random = (new Random().nextInt(899999) + 10000) + "";
			userRegister2.setPassword(passwordEncoder().encode(random));
			userServiceIpl.save(userRegister2);
			redirect.addFlashAttribute("success", "Register successtion");
//			SimpleMailMessage registrationEmail = new SimpleMailMessage();
//			registrationEmail.setTo(userRegister2.getEmail());
//			registrationEmail.setSubject("Registration Confirmation");
//			registrationEmail.setText("Your password:"
//					+ userRegister2.getPassword());
//			registrationEmail.setFrom("noreply@domain.com");
//			emailService.sendEmail(registrationEmail);
			// Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	         
	        message.setTo(userRegister2.getEmail());
	        message.setSubject("Send Password");
	        message.setText("Your password:"
					+ userRegister2.getPassword());
	 
	        // Send Message!
	        this.emailSender.send(message);
			return "redirect:/register";
		}
		
	}
	
	@GetMapping("/index")
	public String returnAdmin(Model model) {
		return "index";
	}
	
	@GetMapping("/login")
	public String returnLogin(Model model) {
		return "pages/login";
	}

//	@Autowired
//	private UserServiceIpl userServiceIpl;
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	private EmailService emailService;
//	
//	// Return registration form template
//		@RequestMapping(value="/register", method = RequestMethod.GET)
//		public ModelAndView showRegistrationPage(ModelAndView modelAndView, Users user){
//			modelAndView.addObject("user", user);
//			modelAndView.setViewName("pages/register");
//			return modelAndView;
//		}
//		// Process form input data
//		@RequestMapping(value = "/register", method = RequestMethod.POST)
//		public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Users user, BindingResult bindingResult, HttpServletRequest request) {
//					
//			// Lookup user in database by e-mail
//			List<Users> userExists = userServiceIpl.search(user.getEmail());
//			
//			System.out.println(userExists);
//			
//			if (userExists != null) {
//				modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
//				modelAndView.setViewName("pages/register");
//				bindingResult.reject("email");
//			}
//				
//			if (bindingResult.hasErrors()) { 
//				modelAndView.setViewName("pages/register");		
//			} else { // new user so we create user and send confirmation e-mail
//						
//				// Disable user until they click on confirmation link in email
//			      
//			    // Generate random 36-character string token for confirmation link
//			    user.setConfirmationToken(UUID.randomUUID().toString());
//			        
//			    userServiceIpl.save(user);
//					
//				String appUrl = request.getScheme() + "://" + request.getServerName();
//				
//				SimpleMailMessage registrationEmail = new SimpleMailMessage();
//				registrationEmail.setTo(user.getEmail());
//				registrationEmail.setSubject("Registration Confirmation");
//				registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
//						+ appUrl + "/confirm?token=" + user.getConfirmationToken());
//				registrationEmail.setFrom("noreply@domain.com");
//				
//				emailService.sendEmail(registrationEmail);
//				
//				modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
//				modelAndView.setViewName("pages/register");
//			}
//				
//			return modelAndView;
//		}
//		
//		// Process confirmation link
//		@RequestMapping(value="/confirm", method = RequestMethod.GET)
//		public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
//				
//			Users user = userServiceIpl.findByConfirmationToken(token);
//				
//			if (user == null) { // No token found in DB
//				modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
//			} else { // Token found
//				modelAndView.addObject("confirmationToken", user.getConfirmationToken());
//			}
//				
//			modelAndView.setViewName("confirm");
//			return modelAndView;		
//		}
//		
//		// Process confirmation link
//		@RequestMapping(value="/confirm", method = RequestMethod.POST)
//		public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {
//					
//			modelAndView.setViewName("confirm");
//			
//			Zxcvbn passwordCheck = new Zxcvbn();
//			
//			Strength strength = passwordCheck.measure((String) requestParams.get("password"));
//			
//			if (strength.getScore() < 3) {
//				bindingResult.reject("password");
//				
//				redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");
//
//				modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
//				System.out.println(requestParams.get("token"));
//				return modelAndView;
//			}
//		
//			// Find the user associated with the reset token
//			Users user = userServiceIpl.findByConfirmationToken((String) requestParams.get("token"));
//
//			// Set new password
//			user.setPassword(bCryptPasswordEncoder.encode((CharSequence) requestParams.get("password")));
//			
//			// Save user
//			userServiceIpl.save(user);
//			
//			modelAndView.addObject("successMessage", "Your password has been set!");
//			return modelAndView;		
//		}
//	@GetMapping("/register")
//	public String createAcount(Model model) {
//		model.addAttribute("userRegister2", new Users());
//		return "pages/register";
//	}
//	
//	@PostMapping("/register/save")
//	public String save(@Valid Users userRegister, BindingResult result, RedirectAttributes redirect) {
//		if (result.hasErrors()) {
//			return "pages/register";
//		}
////		List<Users> listUser = (List<Users>) userServiceIpl.findAll();
////		boolean checkEmail = true;
////		for (Users users : listUser) {
////			if(users.getEmail().equals(userRegister.getEmail())) {
////				checkEmail = false;
////			}
////		}
//		List<Users> userExists = userServiceIpl.search(userRegister.getEmail());
//		if(userExists != null) {
//			return "pages/register";
//		} else {
//		userServiceIpl.save(userRegister);
//		return "redirect:/index";
//		}
//	}
//	
//	@GetMapping("/index")
//	public String returnAdmin(Model model) {
//		return "index";
//	}

}
