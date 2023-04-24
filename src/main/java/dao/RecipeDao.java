package dao;

import java.util.List;

import components.Recipe;
import components.UserData;

public interface RecipeDao {
	
	public void addRecipe(Recipe recipe);
	
	public List < Recipe > getAllRecipes();
	
	public void deleteRecipe(long id);
	
	public UserData getById(long id);
	
	public UserData getByName(String name);
}
