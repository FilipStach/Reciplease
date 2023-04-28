package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import components.Category;
import components.Recipe;
import components.UserData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.RecipeService;


@Controller
@Validated
public class AddRecipeController {

	@Autowired
	RecipeService recipeService;
	
	@RequestMapping("/add-recipe") 
	public String showAddingPage(Model model, HttpSession session) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("category","");
		return "add-recipe";
	}
	
	@PostMapping("/process-add-recipe")
	public String showResultPage(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "add-recipe";
		}
		UserData user = (UserData)session.getAttribute("userData");
		recipe.setUserId(user.getId());
		recipeService.addRecipe(recipe);
		return "redirect:/home";
	}
}
