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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import comperators.ComperatorByName;
import components.Category;
import components.LoginData;
import components.Recipe;
import components.UserData;
import components.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.RecipeService;
import services.UserDataService;

@Controller
@Validated
@SessionAttributes({"loginData"})
public class LoginController {
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	ComperatorByName comperatorByName;
	
	@RequestMapping("/")
	public String showHomepage(Model model) {
		model.addAttribute("loginData", new LoginData());
//		Recipe recipe = new Recipe("Pizza",Category.DINNER,2, 2, 800, 8);
//		recipeService.addRecipe(recipe);
//		recipe = new Recipe("Pancakes",Category.DESSERT,1, 4, 500, 5);
//		recipeService.addRecipe(recipe);
//		recipe = new Recipe("Pasta",Category.DINNER,0.8, 2, 600, 4);
//		recipeService.addRecipe(recipe);
//		recipe = new Recipe("Toasts",Category.SUPPER,0.2, 1, 300, 3);
//		recipeService.addRecipe(recipe);
//		recipe = new Recipe("Smashed eggs",Category.BREAKFAST,0.2, 4, 350, 6);
//		recipeService.addRecipe(recipe);
		List<Recipe> recipes = recipeService.getAllRecipes();
		System.out.println(recipes.get(0).getCategory()); 
		return "login-page";
	}
	
	@PostMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result, Model model, HttpServletRequest request,@RequestParam(name = "sort", defaultValue = "") String sort) {
		if(result.hasErrors()) {
			return "login-page";
		}
		UserData user = userDataService.getByEmail(loginData.getEmail());
		if(user != null && user.getPassword().equals(loginData.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("userData", user);
			session.setAttribute("userName", user.getUserName());
			List<Recipe> recipes = recipeService.getAllRecipes();
//			sort = "name";
			if(sort.equals("name")) {
				Collections.sort(recipes, comperatorByName);
			}
//			else if(sort.equals("calories")) {
//				
//			}
			
			model.addAttribute("recipes", recipes);
			return "home-page1";
		}
		else {	
			model.addAttribute("wrongData", "Wrong email or password");
			return "login-page";
		}
		
	
	}
}
