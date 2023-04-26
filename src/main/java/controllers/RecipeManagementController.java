package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import components.LoginData;
import components.Recipe;
import components.RecipeComparator;
import jakarta.servlet.http.HttpSession;
import services.RecipeService;
import services.UserDataService;

@Controller
@Validated
@SessionAttributes({"loginData"})
public class RecipeManagementController {
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeComparator recipeComparator;
	
	@RequestMapping("/user-recipes")
	public String showHomepage(Model model, HttpSession session) {
		model.addAttribute("userName", session.getAttribute("userName"));
		return "recipe-management";
	}
}

