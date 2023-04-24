package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeDaoImpl implements RecipeDao{
	@Autowired
	private SessionFactory sessionFactory;
}
