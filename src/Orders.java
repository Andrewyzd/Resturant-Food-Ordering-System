import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Orders {
	LinkedList<Order> order = new LinkedList<Order>();
	LinkedList<DeliveryOrder> deliveryorder = new LinkedList<DeliveryOrder>();
	LinkedList<SelfCollectedOrder> selfcollectedorder = new LinkedList<SelfCollectedOrder>();
	/*
	 * Function to add the order object
	 * @param order The object of the Order Class
	 */
	public void addOrder(Order order) 
	{
		this.order.addLast(order);
	}
	/*
	 * Function to add the delivery order object
	 * @param order The object of DeliveryOrder Class
	 */
	public void addDeliveryOrder(DeliveryOrder order) 
	{
		this.deliveryorder.addLast(order);
	}
	/*
	 * Function to add the self-collected order object
	 * @param order The object of SelfCollectedOrder Class
	 */
	public void addSelfCollectedOrder(SelfCollectedOrder order) 
	{
		this.selfcollectedorder.addLast(order);
	}
	/*
	 * Function to sort the delivery order based on the area
	 */
	public void sortDeliveyOrderByArea()
	{
		Collections.sort(deliveryorder, new Comparator<DeliveryOrder>() 
		{
			@Override
			public int compare(DeliveryOrder delivery1, DeliveryOrder delivery2) 
			{
				return Collator.getInstance().compare(delivery1.getArea(), delivery2.getArea());
			}	
		});
	}
}
