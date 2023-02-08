
public class SelfCollectedOrder extends Order{
	private double discount;
	private double overallPrice;
	/**
	 *overloaded constructor to initialize the data
	 *@param customerID The customer's identity number
	 *@param foodName The name of the food
	 *@param quantity The quantity of the food
	 *@param price The price of the food
	 *@param totalPrice The total price of the food
	 *@param date The date of delivery order
	 *@param time The time of delivery order
	 *@param discount The amount of discount
	 *@param overallPrice The overall price of the order
	 */
	public SelfCollectedOrder(String customerId, String foodName, int quantity, double price, double totalPrice, String date, String time ,
							  double discount, double overallPrice)  
	{
		super(customerId, foodName, quantity, price, totalPrice, date, time);
		this.discount = discount;
		this.overallPrice = overallPrice;
	}
	/**
	 *getDiscount() - accessor method to get discount of order
	 *@return String This return the discount of order
	 */
	public double getDiscount() 
	{
		return discount;
	}
	/**
	 *getOverallPrice() - accessor method to get the overall price of delivery order
	 *@return double This return the overall price of the order
	 */
	public double getOverallPrice() 
	{
		return overallPrice;
	}
    /**
     * The string representation is Discount = getDiscount() , overall price = getOverallPrice()
     * Where getDiscount() is the 10% discount of the self-collected order 
     * getOverallPrice() is the overall total price of the particular order
     */
	@Override
	public String toString()
	{
			return super.toString() + String.format(" %.5f %1s %.11f %1s ", this.getDiscount() ,"|", this.getOverallPrice() ,"|");
	}
}
