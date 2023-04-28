package services;

import java.util.List;

import components.Category;
import components.Recipe;

public interface RecipeService {
	
	public void addRecipe(Recipe recipe);
	
	public List < Recipe > getAllRecipes();
	
	public List < Recipe > getbyCategory(Category category);
	
	public void deleteRecipe(long id);
	
	public Recipe getById(long id);
	
	public Recipe getByName(String name);
	
	public void updateRecipe(Recipe recipe);
}
