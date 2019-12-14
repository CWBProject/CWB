package www.spring.com.party.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		
		System.out.println(auth);
		model.addAttribute("msg", "access Denied");
		//log.info();
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		System.out.println("error: " + error);
		System.out.println("logout: " + logout);
		
		if (error != null) {
			model.addAttribute("error", "Login error");
		}
		if (logout != null) {
			model.addAttribute("logout", "logged out");
		}
		//log.info();
	}
	@GetMapping("/customLogout")
	public void logoutGET() {
		
		System.out.println("Log out");
		//log.info();
	}
	
}
