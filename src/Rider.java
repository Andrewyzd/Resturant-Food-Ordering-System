public class Rider {
	private String name;
	private String identityNumber;
	private String contactNumber;
	
	/**
	 *default constructor to initialize value
	 */
	public Rider()
	{
		name = "";
		identityNumber = "";
		contactNumber = "";
	}
	/**
	 *overloaded constructor to initialize the data
	 *@param name The rider's name
	 *@param identityNumber The identity number of rider
	 *@param contactNumber The contact number of rider
	 */
	public Rider(String name,String identityNumber,String contactNumber) 
	{
		this.name = name;
		this.identityNumber = identityNumber;
		this.contactNumber = contactNumber;
	}
	/**
	 *getName() - accessor method to get customer's name
	 *@return String This return the name of customer
	 */
	public String getName() 
	{
		return name;
	}
	/**
	 *getIdentityNumber- accessor method to get the customer's identity number
	 *@return String This return the identity number of customer's
	 */
	public String getIdentityNumber() 
	{
		return identityNumber;
	}
	/**
	 *getContactNumber() - accessor method to get the customer's contact number
	 *@return String This return the contact number of customer
	 */	
	public String getContactNumber() 
	{
		return contactNumber;
	}
	 /**
     * The string representation is "Name = getName(), rider ID = getIdentityNumber(), Contact number = getContactNumber()"
     * Where getName() is the name of rider, getIdentityNumber() is the identity number of rider
     * getContactNumber() is the contact number of rider
     */
	public String toString() 
	{
		return String.format("%1s %-30s %1s  %-19s %1s  %-19s %1s ", "|",getName(),"|",getIdentityNumber(),"|",getContactNumber(),"|");
	}

}
