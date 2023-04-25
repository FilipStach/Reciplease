package components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name="trailTable2")
@Component
public class Recipe implements Comparable<Recipe> {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Cooking time is required")
	private Category category;
	
	@Size(min=2, max = 30,message = "Name be between {min} and {max} characters long")
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Cooking time is required")
	@Min(value = 0, message = "You can't insert less than one portion")
	@Max(value = 100, message = "Portions can't be higher than 100")
	private double time;
	
	@NotBlank(message = "Portion is required")
	@Min(value = 0, message = "You can't insert less than one portion")
	@Max(value = 100, message = "Portions can't be higher than 100")
	private int portion;
	
	@NotBlank(message = "Calories are required")
	@Min(value = 0, message = "Calories can't be lower than zero")
	@Max(value = 10000, message = "Calories can't be higher than 10 000")
	private double calories;
	
	@Min(value = 2, message = "You must insert al least 2 ingredients")
	@Max(value = 30, message = "You can't insert more than 30 ingredients")
	@NotBlank(message = "Quantity of ingredients are required")
	private int ingredientsQuantity;
	
	public Recipe(String name, Category category,double time,int portion,double calories,int ingredientsQuantity)
	{
		this.name = name;
		this.category = category;
		this.time = time;
		this.portion = portion;
		this.calories = calories;
		this.ingredientsQuantity = ingredientsQuantity;
	}
	@Override
	public int compareTo(Recipe e) {
		return this.getName().compareTo(e.getName());
	}
}
