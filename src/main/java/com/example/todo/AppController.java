package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;

	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
		
	@GetMapping("/register")
	public String RegisterPage(Model model) {
		model.addAttribute("user",new User());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String processingRegistration(User user) {
		try {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
		}
		catch(Exception e) {
		return "register_failure";
		}
	}
	
	
	

}
