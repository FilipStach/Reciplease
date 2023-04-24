package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import components.LoginData;
import components.UserData;
import components.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.UserDataService;

@Controller
@Validated
@SessionAttributes({"loginData"})
public class LoginController {
	@Autowired
	UserDataService userDataService;
	@RequestMapping("/")
	public String showHomepage(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "login-page";
	}
	
	@PostMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result, Model model, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "login-page";
		}
		UserData user = userDataService.getByEmail(loginData.getEmail());
		if(user != null && user.getPassword().equals(loginData.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("userData", user);
			session.setAttribute("userName", user.getUserName());
			return "home-page1";
		}
		else {	
			model.addAttribute("wrongData", "Wrong email or password");
			return "login-page";
		}
		
	}
}
