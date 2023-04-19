package controllers;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import components.UserData;


@Controller
//@SessionAttributes({"userInfo"})
public class LoginController {
	
	@RequestMapping("/")
	public String showLoginpage(Model model) {
		model.addAttribute("UserData", new UserData());
		return "login-page";
	}
	
	@RequestMapping("/process-login-page")
	public String showResultPage( @ModelAttribute("UserData") UserData userData,HttpServletRequest request) {
		if(userData.getUserName().equals("Filip") && userData.getPassword().equals("stach123")) {
			HttpSession session = request.getSession();
			session.setAttribute("UserData", userData);
			userData.setId(159357);
			return "home-page";
		}
		else {
			System.out.println("Wrong login or password: " + userData);
			return "login-page";
		}
	}
	@RequestMapping("/show-user-data")
	public String showUserData(HttpSession session) {
		UserData userData = (UserData)session.getAttribute("UserData");
		session.setAttribute("userName", userData.getUserName());
		session.setAttribute("password", userData.getPassword());
		session.setAttribute("id", userData.getId());
		return "home-page";
	}
}
