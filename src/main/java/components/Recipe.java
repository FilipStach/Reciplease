package components;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Recipe {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=2, max = 30,message = "Name be between {min} and {max} characters long")
	@NotBlank(message = "Name is required")
	private String name;
	
	private String category;
	
	@NotBlank(message = "Cooking time is required")
	@Min(value = 0, message = "You can't insert less than one portion")
	@Max(value = 100, message = "Portions can't be higher than 100")
	private double time;
	
	@NotBlank(message = "Portion is required")
	@Min(value = 0, message = "You can't insert less than one portion")
	@Max(value = 100, message = "Portions can't be higher than 100")
	private double portion;
	
	@NotBlank(message = "Calories are required")
	@Min(value = 0, message = "Calories can't be lower than zero")
	@Max(value = 10000, message = "Calories can't be higher than 10 000")
	private double calories;
	
	@Min(value = 2, message = "You must insert al least 2 ingredients")
	@Max(value = 30, message = "You can't insert more than 30 ingredients")
	@NotBlank(message = "Quantity of ingredients are required")
	private int ingredientsQuantity;
}
