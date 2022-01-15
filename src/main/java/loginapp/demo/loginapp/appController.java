package loginapp.demo.loginapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class appController {
	@Autowired
	private userrepo repo;
		
	@GetMapping("")
	public String viewHomepage() {
		return "login";
	}
	
	@GetMapping("login")
	public String viewLoginpage() {
		return "login";
	}
	
	@GetMapping("/forgot_password")
	public String viewForgotPassword() {
		return "forgot_password";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new user());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(user user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "login";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<user> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
}
