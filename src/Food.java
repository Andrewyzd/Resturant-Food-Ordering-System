import java.util.*;
import java.io.*;

public class Food {
	private String foodName;
	private String foodDescription;
	private double foodPrice;
	/**
	 *default constructor to initialize value
	 */
	public Food() 
	{
		foodName = "";
		foodDescription = "";
		foodPrice = 0.0;
	}
	/**
	 *overloaded constructor to initialize the data
	 *@param foodName The name of the food
	 *@param foodDescription The description of the food
	 *@param foodPrice The price of the food
	 */
	public Food(String foodName, String foodDescription, double foodPrice) 
	{
		this.foodName = foodName;
		this.foodDescription = foodDescription;
		this.foodPrice = foodPrice;
	}
	/**
	 *getFoodName() - accessor method to get the name of the food
	 *@return String This return the name of the food
	 */
	public String getFoodName() 
	{
		return foodName;
	}
	/**
	 *getFoodDescription() - accessor method to get the description of the food
	 *@return String This return the description of the food
	 */
	public String getFoodDescription() 
	{
		return foodDescription;
	}
	/**
	 *getFoodPrice() - accessor method to get the price of the food
	 *@return double This return the price of the food
	 */
	public double getFoodPrice() 
	{
		return foodPrice;
	}
	
    /**
     * The string representation is "Name = getFoodName(), Customer ID = getFoodDescription(), Contact number = getFoodPrice()"
     * Where getFoodName() is the name of food, getFoodDescription() is the description of the food
     * getFoodPrice() is the price of food
     */
	public String toString() 
	{
		return String.format("%1s %-60s %1s  %-100s %1s  %.2f %1s ", "|",getFoodName(),"|",getFoodDescription(),"|",getFoodPrice(),"|");
	}
}
