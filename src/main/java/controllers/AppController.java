package controllers;

import java.util.List;

import jakarta.validation.Valid;

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

import components.UserInfoDTO;





@Controller
@Validated
@SessionAttributes({"userInfo"})
public class AppController {
	
//	@RequestMapping("/")
//	public String showHomepage(Model model) {
//		model.addAttribute("userInfo", new UserInfoDTO());
//		return "home-page";
//	}
//	
//	@PostMapping("/process-homepage")
//	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result) {
//		if(result.hasErrors()) {
//			System.out.println("I have an error");
//			List<ObjectError> allErrors = result.getAllErrors();
//			for(ObjectError temp : allErrors) {
//			}
//			return "home-page";
//		}
//		
//		System.out.println("User info: " + userInfoDTO);
//		return "result-page";
//	}
//	
}