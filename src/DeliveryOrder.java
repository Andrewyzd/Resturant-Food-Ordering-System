public class DeliveryOrder extends Order{
	private double delivery_charge;
	private String postcode;
	private double overallPrice;
	private String address;
	private String area;
	private String orderID;
	/**
	 *overloaded constructor to initialize the data
	 *@param customerID The customer's identity number
	 *@param foodName The name of the food
	 *@param quantity The quantity of the food
	 *@param price The price of the food
	 *@param totalPrice The total price of the food
	 *@param date The date of delivery order
	 *@param time The time of delivery order
	 *@param delivery_charge The amount of delivery charge
	 *@param overallPrice The overall price of the order
	 *@param address The address for the delivery order destination
	 *@param postcode The postcode for the delivery order destination
	 *@param area The area of the postcode
	 *@param orderID The order identity number
	 */
	public DeliveryOrder(String customerId, String foodName, int quantity, double price, double totalPrice, String date, String time,  
						double delivery_charge, double overallPrice, String address,String postcode,String area, String orderID) 
	{
		super(customerId, foodName, quantity, price, totalPrice, date, time);
		this.delivery_charge = delivery_charge;
		this.overallPrice = overallPrice;
		this.address = address;
		this.postcode = postcode;
		this.area = area;
		this.orderID = orderID;
	}
	/**
	 *getDelivery_charge() - accessor method to get the delivery charge of delivery order
	 *@return double This return the delivery charge of the order
	 */
	public double getDelivery_charge() 
	{
		return this.delivery_charge;
	}
	/**
	 *getOverallPrice() - accessor method to get the overall price of delivery order
	 *@return double This return the overall price of the order
	 */
	public double getOverallPrice() 
	{
		return this.overallPrice;
	}
	/**
	 *getAddress() - accessor method to get the address of delivery order
	 *@return String This return the address of the delivery order
	 */
	public String getAddress() 
	{
		return this.address;
	}
	/**
	 *getPostcode() - accessor method to get the postcode of delivery order
	 *@return String This return the postcode of the delivery order
	 */
	public String getPostcode() 
	{
		return this.postcode;
	}
	/**
	 *getArea() - accessor method to get the area of delivery order
	 *@return String This return the area of the delivery order
	 */
	public String getArea() 
	{
		return this.area;
	}
	/**
	 *getOrderID() - accessor method to get the order identity number of delivery order
	 *@return String This return the order identity number of the delivery order
	 */
	public String getOrderID() 
	{
		return this.orderID;
	}
    /**
     * The string representation is delivery charge = getDelivery_charge() , overall price = getOverallPrice()
     * address = getAddress() , postcode = getPostcode, area = getArea()
     * Where getDelivery_charge() is the amount of delivey charge, getOverallPrice() is the overall total price of the particular order
     * getAddress() is the address of delivery, getPostcode is the postcode of delivery, getArea() is the area of delivery
     */
	@Override
	public String toString()
	{
			return super.toString() + String.format("%.13f %1s %.11f %1s %-40s %1s %-10s %1s %-20s %1s %-8s %1s\n",this.getDelivery_charge(),"|",this.getOverallPrice() ,"|", this.getAddress(),"|",this.getPostcode(),"|",this.getArea(),"|", this.getOrderID(),"|");
	}
}
