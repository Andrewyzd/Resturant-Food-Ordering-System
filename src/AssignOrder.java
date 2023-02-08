import java.util.*;

public class AssignOrder {
	private String postcode;
	private String orderID;
	private String riderID;
	/**
	 *default constructor to initialize value
	 */
	public AssignOrder()
	{
		postcode = "";
		riderID = "";
	}
	
	/**
	 *overloaded constructor to initialize the data
	 *@param postcode The postcode of customers' address
	 *@param riderID The identity number of rider
	 */
	public AssignOrder(String postcode, String orderID ,String riderID) 
	{
		this.postcode = postcode;
		this.orderID = orderID;
		this.riderID = riderID;
	}
	/**
	 *getPostcode() - accessor method to get the postcode of customer address
	 *@return String This return postcode of the address
	 */
	public String getPostcode() 
	{
		return this.postcode;
	}
	/**
	 *getOrderID() - accessor method to get the identity number of delivery order
	 *@return String This return identity number of the delivery order
	 */
	public String getOrderID() 
	{
		return this.orderID;
	}
	/**
	 *getRiderID() - accessor method to get the identity number of rider
	 *@return String This return identity number of rider
	 */
	public String getRiderID()
	{
		return this.riderID;
	}
}
