package components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class Recipe {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private long userId;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Size(min=2, max = 30,message = "Name be between {min} and {max} characters long")
	@NotBlank(message = "Name is required")
	private String name;
	
//	@Size(min = 1, message= "Time is required")
	@DecimalMin(value = "0.1", message = "Time must be higher than 0.0")
	@DecimalMax(value = "10.0", message = "Time must be higher or equal than 10.0")
	private double time;
	
//	@Size(min = 1,message = "Portion is required")
	@Min(value = 0, message = "You can't insert less than one portion")
	@Max(value = 100, message = "Portions can't be higher than 100")
	private int portion;
	
//	@Size(min = 1,message = "Calories are required")
	@DecimalMin(value = "0.1", message = "Calories must be higher than 0.0")
	@DecimalMax(value = "10000.0", message = "Calories must be higher or equal than 10000.0")
	private double calories;
	
	@Min(value = 2, message = "You must insert al least 2 ingredients")
	@Max(value = 30, message = "You can't insert more than 30 ingredients")
//	@Size(min = 1,message = "Quantity of ingredients are required")
	private int ingredientsQuantity;
	
	public Recipe(String name, Category category,double time,int portion,double calories,int ingredientsQuantity, long userId)
	{
		this.name = name;
		this.category = category;
		this.time = time;
		this.portion = portion;
		this.calories = calories;
		this.ingredientsQuantity = ingredientsQuantity;
		this.userId = userId;
	}
}
