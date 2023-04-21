package controllers;

import java.util.List;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.UserDataService;

import org.springframework.beans.factory.annotation.Autowired;
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
import components.UserInfo;


@Controller
@Validated
@SessionAttributes({"UserInfo"})
public class LoginController {
	
	@Autowired
	UserDataService userDataService;

//	@RequestMapping("/")
//	public String showLoginpage(Model model) {
//		model.addAttribute("UserInfo", new UserInfo());
//		return "login-page";
//	}
//	
//	@RequestMapping("/process-login-page")
//	public String showResultPage(@Valid @ModelAttribute("UserInfo") UserInfo userInfo,HttpServletRequest request, BindingResult result) {
//			if(result.hasErrors()) {
//				List<ObjectError> allErrors = result.getAllErrors();
//				for(ObjectError temp : allErrors) {
//					System.out.println(temp);
//					System.out.println("I have an error");
//				}
//			return 	"login-page";
//			}
//			HttpSession session = request.getSession();
//			session.setAttribute("UserData", userData);
//			UserData user = userDataService.getByEmail(userData.getEmail());
//			if(user!=null) {
//				if(user.getPassword().equals(userData.getPassword())) {
//					
//					return "home-page";
//				}
//				else {
//					session.removeAttribute("UserData");
//					session.setAttribute("errors", "Wrong email or password");
//					return "login-page";
//				}
//			}
//			return "home-page";
//	}
//	@RequestMapping("/show-user-data")
//	public String showUserData(HttpSession session) {
//		UserData userData = (UserData)session.getAttribute("UserData");
//		session.setAttribute("userName", userData.getUserName());
//		session.setAttribute("password", userData.getPassword());
//		session.setAttribute("id", userData.getId());
//		return "home-page";
//	}
}
