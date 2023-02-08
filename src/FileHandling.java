import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

public class FileHandling {
	File file;
	Scanner read;
	PrintWriter write;
	FileWriter deleteFile;
	Foods foods = new Foods();
	Riders riders = new Riders();
	Orders orders = new Orders();
	Customers customers = new Customers();
	CollectAssignOrder collectAssignedOrder = new CollectAssignOrder();
	/*
	 * Function to read the customers' details from text file
	 */
	public void readCustomersFromFile()throws FileNotFoundException, IOException
	{
		file = new File("Customers.txt");
		read = new Scanner(new FileReader("Customers.txt"));
		Customer customer;
		String name, phoneNumber, id;
        if (!file.exists())
        {
            throw new FileNotFoundException("There is not any customer record exist.");
        }
        else if(file.length() == 0) 
        {
        	throw new IllegalStateException( "No customer is added");
        }
		do 
		{
			name = read.nextLine();
			id = read.nextLine();
			phoneNumber = read.nextLine();
			customer = new Customer(name,id,phoneNumber);//create customer object 
			customers.addCustomer(customer);//add the object to the collection class
		}while(read.hasNextLine());	
	}
	/*
	 * Function to read the riders details from text file
	 */
	public void readRidersFromFile()throws FileNotFoundException, IOException
	{
        file = new File("RiderList.txt");
		read = new Scanner(new FileReader("RiderList.txt")); 
		Rider rider;
		String id, firstName, lastName,name,phoneNumber;
        if (!file.exists())
        {
            throw new IllegalStateException("There is no rider record.");
        }
		do 
		{
			firstName = read.next();
			lastName = read.next();
			id = read.next();
			phoneNumber = read.next();
			name = firstName + " " + lastName;
			//create rider object
			rider = new Rider(name, id, phoneNumber);
			riders.add(rider);//add the object to collection class
		}while(read.hasNextLine());	
	}
	/*
	 * Function to read the food details from text file
	 */
	public void ReadFromfoodListFile() throws FileNotFoundException, IOException
	{
		 Scanner read = new Scanner(new FileReader("foodList.txt"));
		 Food food;
		do
		{
			//read from text file
			String foodName = read.nextLine();
			String foodDescription = read.nextLine();
			double foodPrice = Double.parseDouble(read.nextLine());//convert the food price to double 
			//create the object of food
			food = new Food(foodName, foodDescription, foodPrice);
			foods.addFood(food);//add the object of food to collection class
			
		}while(read.hasNextLine()); 
		read.close();
	}
	/*
	 * Function to read self-collected order from text file
	 */
	public void readSelfCollectedOrderFromTextFile()throws FileNotFoundException, IOException 
	{
        file = new File("SelfCollectedOrder.txt");
		read = new Scanner(new FileReader("SelfCollectedOrder.txt"));
		SelfCollectedOrder selfcollectedOrder;
		String customerID = "", foodName, foodQuantityText, pricesText, totalPriceText, discountText, overallPriceText, date, time;
		int foodQuantity;
		double prices, totalprice, discount, overallPrice;
		
        if (!file.exists() || file.length() == 0)//if the file not exist or is empty
        {
            throw new IllegalStateException("No self collected order is made");
        }
        do 
		{	
        	//read the details from text field
			customerID = read.nextLine();
			foodName = read.nextLine();
			foodQuantityText = read.nextLine();
			foodQuantity = Integer.parseInt(foodQuantityText);//convert quantity to double
			pricesText = read.nextLine();
			prices = Double.parseDouble(pricesText);//convert price to double
			totalPriceText = read.nextLine();
			totalprice = Double.parseDouble(totalPriceText);//convert total price to double 
			date = read.nextLine();
			time = read.nextLine();
			discountText = read.nextLine();
			discount = Double.parseDouble(discountText);//convert discount to double
			overallPriceText = read.nextLine();
			overallPrice = Double.parseDouble(overallPriceText);//convert overall price to double 
			//create the self-collected object
			selfcollectedOrder = new SelfCollectedOrder(customerID, foodName, foodQuantity, prices, totalprice, date, time, discount, overallPrice);
			orders.addSelfCollectedOrder(selfcollectedOrder);//add the self-collected object to collection class
		}while(read.hasNextLine());

	}
	/*
	 * Function to read the delivery order from text file
	 */
	public void readDeliveryOrderFromTextFile()throws FileNotFoundException, IOException 
	{
        File file = new File("DeliveryOrder.txt");
		Scanner read = new Scanner(new FileReader("DeliveryOrder.txt")); 
		DeliveryOrder deliveryOrder;
		String customerID, foodName, foodQuantityText, pricesText, totalPriceText, date, time, deliveryChargeText, overallPriceText,postcode,address,area,orderID;
		int foodQuantity;
		double prices, totalprice, deliveryCharge, overallPrice;
		
        if (!file.exists())//if the file do not exists
        {
            throw new IllegalStateException("No delivery order is made");
        }
        if(file.length() == 0)//if the file is empty 
        {
        	deleteContentOfAssignedOrderFile();
        	throw new IllegalStateException("No delivery order is in progress.");
        }
		do 
		{	
			//read the details from text file
			customerID = read.nextLine();
			foodName = read.nextLine();
			foodQuantityText = read.nextLine();
			foodQuantity = Integer.parseInt(foodQuantityText);//convert quantity to double
			pricesText = read.nextLine();
			prices = Double.parseDouble(pricesText);//convert price to double 
			totalPriceText = read.nextLine();
			totalprice = Double.parseDouble(totalPriceText);//convert total price to double
			date = read.nextLine();
			time = read.nextLine();
			deliveryChargeText = read.nextLine();
			deliveryCharge = Double.parseDouble(deliveryChargeText);//convert delivery charge to double
			overallPriceText = read.nextLine();
			overallPrice = Double.parseDouble(overallPriceText);//convert overall price to double
			postcode = read.nextLine();
			address = read.nextLine();
			area = read.nextLine();
			orderID = read.nextLine();
			//create delivery order object
			deliveryOrder = new DeliveryOrder(customerID, foodName, foodQuantity, prices, totalprice, date, time, deliveryCharge, overallPrice,postcode,address,area,orderID);
			orders.addDeliveryOrder(deliveryOrder);//add the object to collection class
		}while(read.hasNextLine());
	}
	/*
	 * Function to read the assigned order to text file
	 */
	public void readFromAssingedOrderTextFile()throws FileNotFoundException, IOException 
	{
		file = new File("AssignedOrder.txt");
		read = new Scanner(new FileReader("AssignedOrder.txt"));
		AssignOrder assignorder;
        if (!file.exists() || file.length() == 0)//if the file does not exits or is empty
        {
        	throw new IllegalStateException("Not order is assigned");
        }
		do 
		{
			String orderID = read.nextLine();
			String postCode = read.nextLine();
			String rider_id = read.nextLine();
			assignorder = new AssignOrder(postCode, orderID, rider_id);
			collectAssignedOrder.addAssignOrder(assignorder);
		}while(read.hasNextLine());
	}
	/*
	 * Function to add the customers details to Customers.txt text file
	 * @param customerName This is the name of customer
	 * @param customerID This is the customer's identity number
	 * @param customerContactNumber This is the customer's contact number
	 */
	public void addCustomerToTextFile(String customerName, String customerID, String customerContactNumber) throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("Customers.txt",true));
			//write the details to file
		write.println(customerName);
		write.println(customerID);
		write.println(customerContactNumber);
		write.close();//close the text file
	}
	/*
	 * Function to write the assigned postcode and rider identity number to text file
	 * @param postcode This is the postcode of the delivery order
	 * @param orderID This is the random generated identity number of the order
	 * @param riderID This is rider's identity number 
	 */
	public void writeAssignedOrderToTextFile(String postcode, String orderID,String riderID)throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("AssignedOrder.txt",true));
		//Write the postcode and the rider'd identity number to text file
		write.println(orderID);
		write.println(postcode);
		write.println(riderID);
		write.close();
	}
	/*
	 * Function for saving delivery order to text file
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
	public void savingDeliveryOrdersToTextFile(String customersId,String foodName,int foodQuantity,double prices,double totalprice,
											   String date,String time, double deliverycharges,double overallPrice,String order_address,
											   String order_postcode,String order_area,String orderID) throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("DeliveryOrder.txt",true));

		//write the information to text file
		write.println(customersId);
		write.println(foodName);
		write.println(foodQuantity);
		write.println(prices);
		write.println(totalprice);
		write.println(date);
		write.println(time);
		write.println(deliverycharges);
		write.println(overallPrice);
		write.println(order_address);
		write.println(order_postcode);
		write.println(order_area);
		write.println(orderID);
		write.close();//close the text file
	}
	/*
	 * Function to save self-collected order to text file
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
	public void savingSelfColletedOrdersToTextFile(String customersId, String foodName,int foodQuantity,
												   double prices,double totalprice,String date,String time,
												   double discount,double overallPrice) throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("SelfCollectedOrder.txt",true));
		//write the information to text file
		write.println(customersId);
		write.println(foodName);
		write.println(foodQuantity);
		write.println(prices);
		write.println(totalprice);
		write.println(date);
		write.println(time);
		write.println(discount);
		write.println(overallPrice);
		write.close();//close the text file
	}
	/*
	 * Function to write the selected food details to file before the real order is made
	 * @param foodName The name of food
	 * @param quantity The quantity of food
	 * @param price The price of food
	 * @param totalPrice The total price of food
	 */
	public void recordTheOrderToFile(String foodName, int quantity, double price, double totalPrice)throws FileNotFoundException, IOException 
	{
		write =  new PrintWriter(new FileWriter("SelectedFoodFile.txt",true));
		//write to text file
		write.println(foodName);
		write.println(quantity);
		write.println(price);
		write.println(totalPrice);
		//close the text file
		write.close();
	}
	/*
	 * Function to save returned order to text file
	 */
	public void savingReturnedOrdersToTextFile(Object[] returnedDetails) throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("ReturnedOrder.txt",true));
		
		String customerID = returnedDetails[0].toString();
		String foodName = returnedDetails[1].toString();
		int foodQuantity = Integer.parseInt(returnedDetails[2].toString());//convert quantity to integer
		double prices = Double.parseDouble(returnedDetails[3].toString());//convert price to double
		double totalprice = Double.parseDouble(returnedDetails[4].toString());//convert total price to double
		String date = returnedDetails[5].toString();
		String time = returnedDetails[6].toString();
		double deliveryCharge = Double.parseDouble(returnedDetails[7].toString());//convert delivery charge to double
		double overallPrice = Double.parseDouble(returnedDetails[8].toString());//convert overall price to double
		String postcode = returnedDetails[9].toString();
		String area = returnedDetails[10].toString();
		String address = returnedDetails[11].toString();
		String orderID = returnedDetails[12].toString();
		//write to text file
		write.println(customerID);
		write.println(foodName);
		write.println(foodQuantity);
		write.println(prices);
		write.println(totalprice);
		write.println(date);
		write.println(time);
		write.println(deliveryCharge);		
		write.println(overallPrice);
		write.println(postcode);
		write.println(area);
		write.println(address);
		write.println(orderID);
		//close the text file
		write.close();
	}
	/*
	 * Function to save delivered order to text file
	 */
	public void savingDeliveredOrdersToTextFile(Object[] returnedDetails) throws FileNotFoundException, IOException
	{
		write = new PrintWriter(new FileWriter("DeliveredOrder.txt",true));
		
		String customerID = returnedDetails[0].toString();
		String foodName = returnedDetails[1].toString();
		int foodQuantity = Integer.parseInt(returnedDetails[2].toString());//convert quantity to integer
		double prices = Double.parseDouble(returnedDetails[3].toString());//convert price to double
		double totalprice = Double.parseDouble(returnedDetails[4].toString());//convert total price to double
		String date = returnedDetails[5].toString();
		String time = returnedDetails[6].toString();
		double deliveryCharge = Double.parseDouble(returnedDetails[7].toString());//convert delivery charge to double
		double overallPrice = Double.parseDouble(returnedDetails[8].toString());//convert overall price to double
		String postcode = returnedDetails[9].toString();
		String area = returnedDetails[10].toString();
		String address = returnedDetails[11].toString();
		String orderID = returnedDetails[12].toString();
		//write to text file
		write.println(customerID);
		write.println(foodName);
		write.println(foodQuantity);
		write.println(prices);
		write.println(totalprice);
		write.println(date);
		write.println(time);
		write.println(deliveryCharge);		
		write.println(overallPrice);
		write.println(postcode);
		write.println(area);
		write.println(address);
		write.println(orderID);
		//close the text file
		write.close();
	}
	/*
	 * Function to delete the content of the general order text file
	 */
	public void deleteGeneralOrderOrderFile() throws IOException
	{
		deleteFile = new FileWriter("SelectedFoodFile.txt", false);
		//delete the text file
		deleteFile.flush();
		deleteFile.close();
	}
	/*
	 * Function to delete the content of delivery order text file
	 */
	public void deleteContentOfDeliveryOrderFile() throws IOException
	{
		deleteFile = new FileWriter("DeliveryOrder.txt", false);
		//delete the text file
		deleteFile.flush();
		deleteFile.close();
	}
	/*
	 * Function to delete the content of customers text file 
	 */
	public void deleteContentOfCustomersFile() throws IOException
	{
		deleteFile = new FileWriter("Customers.txt", false);
		//delete the text file
		deleteFile.flush();
		deleteFile.close();
	}
	/*
	 * Function to delete the content of delivery order
	 */
	public void deleteContentOfAssignedOrderFile() throws IOException
	{
		deleteFile = new FileWriter("AssignedOrder.txt", false);
		deleteFile.flush();
		deleteFile.close();
	}
}
