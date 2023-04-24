package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
public class RegistrationController {
	@Autowired
	UserDataService userDataService;
	@RequestMapping("/registration")
	public String showHomepage(Model model) {
		model.addAttribute("userData", new UserData());
		return "registration-page";
	}
	
	@PostMapping("/process-registration")
	public String showResultPage(@Valid @ModelAttribute("userData") UserData userData, BindingResult result, Model model, HttpServletRequest request) {
		if(userDataService.getByEmail(userData.getEmail()) != null) {
			result.addError(new FieldError("userData", "email", "Email already used"));
		}
		if(userDataService.getByUserName(userData.getUserName()) != null) {
			result.addError(new FieldError("userData", "userName", "UserName already used"));
		}
		if(result.hasErrors()) {
			return "registration-page";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userData", userData);
			session.setAttribute("userName", userData.getUserName());
			userDataService.addUser(userData);
			return "login-page";
		}
		
	}
}