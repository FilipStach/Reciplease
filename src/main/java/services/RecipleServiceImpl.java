package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import components.Category;
import components.Recipe;
import dao.RecipeDao;

@Service
public class RecipleServiceImpl implements RecipeService {
	
	@Autowired
	RecipeDao recipeDao;
	
	public void addRecipe(Recipe recipe) {
		recipeDao.addRecipe(recipe);
	}
	public void updateRecipe(Recipe recipe) {
		recipeDao.updateRecipe(recipe);
	}
	
	public List < Recipe > getAllRecipes(){
		return recipeDao.getAllRecipes();
	}
	
	public List < Recipe > getbyCategory(Category category){
		return recipeDao.getbyCategory(category);
	}
	
	public void deleteRecipe(long id) {
		recipeDao.deleteRecipe(id);
	}
	
	public Recipe getById(long id) {
		return recipeDao.getById(id);
	}
	
	public Recipe getByName(String name) {
		return recipeDao.getByName(name);
	}
}
