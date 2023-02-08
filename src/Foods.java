import java.util.LinkedList;

public class Foods {
	LinkedList<Food> food = new LinkedList<Food>();
	/*
	 * Function to add the food object to the collection class
	 * @param food This is the object of the Food Class
	 */
	public void addFood(Food food) 
	{
		this.food.add(food);
	}
}
