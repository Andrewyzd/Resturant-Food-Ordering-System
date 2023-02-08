public class Order {
	private String customerId;
	private String foodName;
	private String date;
	private String time;
	private int quantity;
	private double price;
	private double totalPrice;
	/**
	 *default constructor to initialize value
	 */
	public Order ()
	{
		customerId = "";
		foodName = "";
		quantity = 0;
		totalPrice = 0.0;
		date = "";
		time = "";
	}
	/**
	 *overloaded constructor to initialize the data
	 *@param customerId The identity number of customers
	 *@param foodName The name of ordered food
	 *@param quantity The quantity of the ordered food
	 *@param price The price of the ordered food
	 *@param totalPrice The total price of the ordered food
	 *@param date The order date
	 *@param time The order time  
	 */
	public Order(String customerId, String foodName, int quantity, double price, double totalPrice, String date, String time) 
	{
		this.customerId = customerId;
		this.foodName = foodName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.date = date;
		this.time = time;

	}
	/**
	 *getCustomerId()  - accessor method to get the identity number of customer 
	 *@return String This return identity number of customer
	 */
	public String getCustomerId() 
	{
		return customerId;
	}
	/**
	 *getFoodName() - accessor method to get the name of food
	 *@return String This return the name of food 
	 */
	public String getFoodName() 
	{
		return foodName;
	}
	/**
	 *getPrice() - accessor method to get the price of ordered food
	 *@return double This return the price of order food
	 */
	public double getPrice() 
	{
		return price;
	}
	/**
	 *getQuantity() - accessor method to get the quantity of ordered food
	 *@return int This return the quantity of ordered food
	 */
	public int getQuantity() 
	{
		return quantity;
	}
	/**
	 *getTotalPrice() - accessor method to get the total price of ordered food
	 *@return double This return the total price of ordered food
	 */	
	public double getTotalPrice()
	{
		return totalPrice;
	}
	/**
	 *getDate() - accessor method to get the date of order
	 *@return String This return the date of order
	 */
	public String getDate() 
	{
		return date;
	}
	/**
	 *getTime() - accessor method to get the time of order
	 *@return String This return the time of order
	 */
	public String getTime() 
	{
		return time;
	}
    /**
     * The string representation is customer ID = getCustomerId() , Food name = getFoodName(), Quantity = getQuantity()
     * Total Price = getTotalPrice(), Date = getDate(), Time = getTime()
     * Where getCustomerId() is the id of student, getFoodName() is the name of food, getQuantity() is the quantity of food ordered
     *  getTotalPrice() is the total price of the selected food, getDate() is the date of order, getTime() is the time of order
     */
	@Override
	public String toString()
	{
			return String.format("%1s %-15s %1s %50s %1s %8d %1s %.3f %1s %.9f %1s %-15s %1s %-15s %1s ", "|" ,this.getCustomerId() ,"|" ,this.getFoodName(), "|" ,this.getQuantity(),"|",this.getPrice(),"|", this.getTotalPrice() ,"|" ,this.getDate(),"|", getTime(),"|");
	}
}
