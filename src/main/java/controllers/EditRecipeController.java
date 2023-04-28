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
//		if(model.getAttribute("id") == null) {
		Recipe recipe = (Recipe)session.getAttribute("recipe");
		Recipe recipe1 = recipeService.getById(recipe.getId());
		System.out.println("Second recipe id"+ recipe.getId());
		System.out.println("Third recipe id"+ recipe1.getId());
			model.addAttribute("recipe", recipe1);
			model.addAttribute("category","");
//		}
//		else if((int)model.getAttribute("id")!=0) {
//			System.out.println("id" + (int)model.getAttribute("id"));
//			Recipe recipe = recipeService.getById((int)model.getAttribute("id"));
//			model.addAttribute("recipe",recipe);
//		}
		return "edit-recipe";
	}
	
	@PostMapping("/process-edit-recipes")
	public String showResultPage(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			return "add-recipe";
		}
		UserData user = (UserData)session.getAttribute("userData");
		recipe.setUserId(user.getId());
		Recipe recipeToUpdate = recipeService.getById(recipe.getId());
		recipeToUpdate.setName(recipe.getName());
		recipeToUpdate.setTime(recipe.getTime());
		recipeToUpdate.setPortion(recipe.getPortion());
		recipeToUpdate.setCalories(recipe.getCalories());
		recipeToUpdate.setIngredientsQuantity(recipe.getIngredientsQuantity());
		System.out.println("Recipe to update id" +recipeToUpdate.getId());
		System.out.println("Recipe id" +recipe.getId());
		recipeService.updateRecipe(recipeToUpdate);
		return "home-page1";
	}
	
}