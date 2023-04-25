package comperators;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import components.Recipe;

@Component
public class ComperatorByName implements Comparator<Recipe>{
	@Override
	public int compare(Recipe o1, Recipe o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
