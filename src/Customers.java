import java.text.Collator;
import java.util.*;

import javax.swing.JOptionPane;

public class Customers {
	private String matchedCustomerName;
	private String matchedCustomerPhoneNumber;
	LinkedList<Customer> customer = new LinkedList<Customer>();
	
	/**
	 *Function to add the customer object to collection
	 *@param customer This is the object of Customer class
	 */
	public void addCustomer(Customer customer) 
	{
		this.customer.addLast(customer);
	}
	/**
	 *getCustomerName - Function to get the name of the customer
	 *@param customerID This is the identity number of customer
	 *@return String This return the name of customer
	 */
	public String getCustomerName(String customerID) 
	{
		for(Customer customers : customer) 
		{
			if (customers.getIdentityNumber() == customerID)
			{
				this.matchedCustomerName = customers.getName();
			}
		}
		return this.matchedCustomerName;
	}
	/**
	 *getCustomerPhoneNumber - Function to get the contact number of the customer
	 *@param customerID This is the identity number of customer
	 *@return String This return the contact number of customer
	 */
	public String getCustomerPhoneNumber(String customerID) 
	{
		for(Customer customers : customer) 
		{
			if (customers.getIdentityNumber() == customerID)
			{
				this.matchedCustomerPhoneNumber = customers.getContactNumber();
			}
		}
		return this.matchedCustomerPhoneNumber;
	}
	
	/*
	 * Function to sort the customer based on the name
	 */
	public void sortCustomerByName()
	{
		Collections.sort(customer, new Comparator<Customer>() 
		{
			@Override
			public int compare(Customer customer1, Customer customer2) 
			{
				return Collator.getInstance().compare(customer1.getName(), customer2.getName());
			}	
		});
	}
}
