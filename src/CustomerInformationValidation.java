import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

public class CustomerInformationValidation {
	FileHandling file = new FileHandling();
	/*
	 * Function to check the valid input of from user
	 * @param contactNumber This is the contact number of the customer
	 */
	public void checkInputContactNumberValidation(String contactNumber) 
	{
		boolean invalid = false;
		for(int i = 0; i < contactNumber.length();i++) 
		{
			char character = contactNumber.charAt(i);
			if(contactNumber.charAt(0) !='0' || contactNumber.charAt(1) !='1')//if input not start with 0 and followed by 1 
			{
				throw new InputMismatchException("Invalid input for phone number! Please start with 0 and followed by 1.");
			}
			else if(contactNumber.length() < 10 || contactNumber.length() > 11)//if input length is not valid
			{
				throw new InputMismatchException("Invalid length for phone number! Make sure the phone number contain 10 or 11 digit!");
			}
			else if((character >='0' && character <='9'))//if the input is valid 
			{
				invalid = false;//set to false
			}
			else 
			{
				invalid = true;//set to true if the input is not numerical number
			}
		}
		if(invalid)// if it is true
		{
			throw new InputMismatchException("Invalid input for phone number! Please enter only numerical character.");
		}
	}
	/*
	 * Function to check the valid input of name from user
	 * @param name This is the name of the customer 
	 */
	public void checkInputNameValidation(String name) 
	{
		boolean invalid = false;
		for(int i = 0; i < name.length();i++) 
		{
			char character = name.charAt(i);
			if((character >='a' && character <= 'z') || (character ==' ') || (character >='A' && character <= 'Z') || (character ==' '))//if the input is valid 
			{
				invalid = false;//set to false
			}
			else 
			{
				invalid = true;//set to true
			}
		}
		if(invalid)//if it is true
		{
			throw new InputMismatchException("Invalid input for customer name! Please enter only alphabet.");
		}
	}
	/*
	 * Function to check whether the customer exists or not to avoid duplication
	 * @return boolean This will return either true or false 
	 */
	public boolean checkExistingCustomer(String customerID, String customerIDcheck[]) 
	{
		boolean exist = false;
		for(int i = 0; i < customerIDcheck.length; i++) 
		{
			if(customerID.equals(customerIDcheck[i]))//if the same identity number is found 
			{
				exist = true;//set exist to true
				break;//exit the loop
			}
			else 
			{
				exist = false;//set exist to false
			}
		}
		return exist;
	}
}
