package components;

import java.util.Collections;
import java.util.Comparator;

import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Component
public class RecipeComparator implements Comparator<Recipe>{
	private String Type;
	@Override
	public int compare(Recipe o1, Recipe o2) {
		switch (Type) {
		case "time":
			return Double.compare(o1.getTime(), o2.getTime());
		case "name":
			return o1.getName().compareTo(o2.getName());
		case "ingredients":
			return Integer.compare(o1.getIngredientsQuantity(), o2.getIngredientsQuantity());
		case "calories":
			return Double.compare(o1.getCalories(), o2.getCalories());
		case "portions":
			return Integer.compare(o1.getPortion(), o2.getPortion());
		case "category":
			return o1.getCategory().compareTo(o2.getCategory());
		default:
			return 0;
		}
	}
}