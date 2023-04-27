package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import components.Category;
import components.Recipe;
import components.UserData;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import services.RecipeService;

@Controller
@Validated
public class EditRecipeController {

	@Autowired
	RecipeService recipeService;
	
	@RequestMapping("/edit-recipes") 
	public String showAddingPage(Model model, HttpSession session) {
		if(model.getAttribute("id") == null) {
			model.addAttribute("recipe", new Recipe());
			model.addAttribute("id",0);
			model.addAttribute("category","");
		}
		else if((int)model.getAttribute("id")!=0) {
			System.out.println("id" + (int)model.getAttribute("id"));
			Recipe recipe = recipeService.getById((int)model.getAttribute("id"));
			model.addAttribute("recipe",recipe);
		}
		return "edit-recipe";
	}
	
	@PostMapping("/process-edit-recipes")
	public String showResultPage(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "add-recipe";
		}
		UserData user = (UserData)session.getAttribute("userData");
		recipe.setUserId(user.getId());
		recipe.setCategory(Category.BREAKFAST);
		recipeService.addRecipe(recipe);
		return "home-page1";
	}
}