
public class ConcoleTableLine {
	
	/*
	 * Function to display the border line for customer list
	 */
	public void tableBorderForCustomer() 
	{
		System.out.print("+");
		for(int i = 0; i < 76; i++) 
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
	/*
	 * Function to display the border line for rider list
	 */
	public void tableBorderForRider() 
	{
		System.out.print("+");
		for(int i = 0; i < 78; i++) 
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
	/*
	 * Function to display border line for self-collected list
	 */
	public void tableBorderForSelfCollectedOrder() 
	{
		System.out.print("+");
		for(int i = 0; i < 169; i++) 
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
	/*
	 * Function to display the border line for delivery and returned delivery list
	 */
	public void tableBorderForDeliveryAndReturnedOrder() 
	{
		System.out.print("+");
		for(int i = 0; i < 270; i++) 
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	/*
	 * Function to display the border line for food list
	 */
	public void tableBorderForFood() 
	{
		System.out.print("+");
		for(int i = 0; i < 175; i++) 
		{
			System.out.print("-");
		}
		System.out.println("+");
	}

}
