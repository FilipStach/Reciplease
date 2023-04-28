package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import components.LoginData;
import components.Recipe;
import components.RecipeComparator;
import components.UserData;
import jakarta.servlet.http.HttpSession;
import services.RecipeService;
import services.UserDataService;

@Controller
@Validated
public class RecipeManagementController {
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeComparator recipeComparator;
	
	@RequestMapping("/user-recipes")
	public String showHomepage(Model model, HttpSession session,@ModelAttribute("sort") String sort) {
		model.addAttribute("userName", session.getAttribute("userName"));
		session.setAttribute("recipe", new Recipe());
		model.addAttribute(session.getAttribute("recipe"));
		List<Recipe> recipes = (List<Recipe>)session.getAttribute("recipes");
		List<Recipe> myRecipes = new ArrayList<>();
		UserData user = (UserData)session.getAttribute("userData");
		for(Recipe recipe : recipes) {
			if(recipe.getUserId() == user.getId()) {
				
				myRecipes.add(recipe);
			}
		}
		if(!sort.equals("")) {
			recipeComparator.setType(sort);
			Collections.sort(myRecipes, recipeComparator);
		}
		session.setAttribute("myRecipes", myRecipes);
		return "recipe-management";
	}
	@RequestMapping("/process-user-recipes")
	public String processShowHomepage(@ModelAttribute("recipe") Recipe recipe, Model model, HttpSession session) {
		System.out.println(recipe.getId());
		session.setAttribute("recipe", recipe);
		System.out.println("First recipe id"+ recipe.getId());
		return "redirect:/edit-recipes";
	}
}

