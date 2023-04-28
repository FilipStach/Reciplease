package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import components.Category;
import components.Recipe;
import components.UserData;

@Repository
public class RecipeDaoImpl implements RecipeDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addRecipe(Recipe recipe) {
		Session currentSession = sessionFactory.getCurrentSession();
		org.hibernate.Transaction transaction = currentSession.beginTransaction();
		currentSession.save(recipe);
		transaction.commit();
	}
	
	public void updateRecipe(Recipe recipe) {
		Session currentSession = sessionFactory.getCurrentSession();
		org.hibernate.Transaction transaction = currentSession.beginTransaction();
		currentSession.update(recipe);
		transaction.commit();
	}
	
	public List < Recipe > getAllRecipes(){
		 try (Session session = this.sessionFactory.openSession()) {
	        	List <Recipe> output = session.createQuery("from Recipe", Recipe.class).list();
	            return output;
	        }
	}
	
	public List < Recipe > getbyCategory(Category category){
		org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List <Recipe> output = session.createQuery("from Recipe", Recipe.class).list();
        	for(Recipe recipe : output) {
    			if(!recipe.getCategory().equals(category) ) {
    				output.remove(recipe);
    			}
    		}
        	session.close();
        	return output;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	return null;
	}
	
	public void deleteRecipe(long id) {
		org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Recipe recipeToDelete = session.get(Recipe.class, id);
            if (recipeToDelete != null) {
            	session.delete(recipeToDelete);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	public Recipe getById(long id) {
		org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List <Recipe> output = session.createQuery("from Recipe", Recipe.class).list();
        	for(Recipe recipe : output) {
    			if(recipe.getId() == id ) {
    				session.close();
    				return recipe;
    			}
    		}
        	session.close();
        	return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	return null;
	}
	
	public Recipe getByName(String name) {
		org.hibernate.Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List <Recipe> output = session.createQuery("from Recipe", Recipe.class).list();
        	for(Recipe recipe : output) {
    			if(recipe.getName().equals(name)) {
    				session.close();
    				return recipe;
    			}
    		}
        	session.close();
        	return null;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    	return null;
	}
}