package controllers;

import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import components.Category;
import components.LoginData;
import components.Recipe;
import components.RecipeComparator;
import components.UserData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.RecipeService;
import services.UserDataService;

@Controller
@Validated
public class LoginController {
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeComparator recipeComparator;


	
	@RequestMapping("/")
	public String showHomepage(Model model) {
		model.addAttribute("loginData", new LoginData());
		model.addAttribute("sort", "");
//		recipeService.addRecipe( new Recipe("Toasts",Category.LUNCH,0.1,1,350,3,1));
//		recipeService.addRecipe( new Recipe("Pizza",Category.DINNER,2.5,2,800,9,1));
//		recipeService.addRecipe( new Recipe("Pancakes",Category.DESSERT,0.8,3,600,7,1));
//		recipeService.addRecipe( new Recipe("Sandwiches",Category.SUPPER,0.7,4,600,6,1));
//		recipeService.addRecipe( new Recipe("Hot dog",Category.DINNER,0.3,4,400,4,2));
		return "login-page";
	}

	@RequestMapping(value = "/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result,
			Model model, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "login-page";
		}
		UserData user = userDataService.getByEmail(loginData.getEmail());
		if(user != null && user.getPassword().equals(loginData.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("userData", user);
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("loginData", loginData);
			return "redirect:/home";
		}
		else {	
			model.addAttribute("wrongData", "Wrong email or password");
			return "login-page";
		}
		
	
	}
	@RequestMapping(value = "/home")
	public String showResultPage(Model model, HttpSession session, @ModelAttribute("sort") String sort) {

		if(session.getAttribute("loginData")!=null) {
		List<Recipe> recipes = recipeService.getAllRecipes();
		if(!sort.equals("")) {
			recipeComparator.setType(sort);
			Collections.sort(recipes, recipeComparator);
		}
		session.setAttribute("recipes", recipes);
		return "home-page1";
		}
		else {
			return "redirect:/";
		}
	
	}
}
