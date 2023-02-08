import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

public class CustomersGUI extends MouseAdapter {

	public  JFrame customersFrame;
	private JLabel Label_BackgroundImage;
	private JPanel contentPane;
	private JScrollPane customerTableScrollPane;
	private JTable customerTableList;
	private JTextField instructionHeader,customerListHeader;
	Orders orders = new Orders();
	FileHandling file = new FileHandling();
	ConcoleTableLine border = new ConcoleTableLine();

	/**
	 * Constructor to display window frame and components
	 */
	public CustomersGUI() {
		//Design the customer background image to be displayed
		ImageIcon backgroundIcon = new ImageIcon("ImageIcon\\customerBackground.jpg"); // load the image to a imageIcon
		Image backgroundImage = backgroundIcon.getImage();// transform it 
		Image newimg_background= backgroundImage.getScaledInstance(696, 573,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backgroundIcon = new ImageIcon(newimg_background);
		//Design the windows frame
		customersFrame = new JFrame("Customers List");
		customersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customersFrame.setBounds(100, 100, 696, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(51, 255, 0), 1, true));
		customersFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design the label of the background image
		Label_BackgroundImage = new JLabel(backgroundIcon);
		Label_BackgroundImage.setBounds(0, 0, 696, 573);
		contentPane.add(Label_BackgroundImage);
		//Design the table for customer list
		customerTableList = new JTable();
		customerTableList.setBackground(Color.WHITE);
		customerTableList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Identity Number", "Contact Number"
			}
		));	
		customerTableList.getTableHeader().setOpaque(false);
		customerTableList.getTableHeader().setBackground(new Color(102, 153, 102));
		customerTableList.getTableHeader().setForeground(new Color(255,255,255)); 
		//Design the scrollpane for customer table
		customerTableScrollPane = new JScrollPane(customerTableList);
		Label_BackgroundImage.add(customerTableScrollPane);
		customerTableScrollPane.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		customerTableScrollPane.setBounds(25, 136, 624, 354);
		customerTableScrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//Design header for customer list text
		customerListHeader = new JTextField();
		Label_BackgroundImage.add(customerListHeader);
		customerListHeader.setText("Customer List");
		customerListHeader.setOpaque(false);
		customerListHeader.setHorizontalAlignment(SwingConstants.CENTER);
		customerListHeader.setForeground(Color.WHITE);
		customerListHeader.setFont(new Font("Lucida Handwriting", Font.BOLD, 48));
		customerListHeader.setEditable(false);
		customerListHeader.setColumns(10);
		customerListHeader.setBorder(null);
		customerListHeader.setBounds(98, 13, 478, 79);
		//Design header for instruction 
		instructionHeader = new JTextField();
		instructionHeader.setText("*Click on the table row for order details description");
		instructionHeader.setOpaque(false);
		instructionHeader.setHorizontalAlignment(SwingConstants.CENTER);
		instructionHeader.setForeground(Color.WHITE);
		instructionHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		instructionHeader.setEditable(false);
		instructionHeader.setColumns(10);
		instructionHeader.setBorder(null);
		instructionHeader.setBounds(141, 93, 394, 42);
		Label_BackgroundImage.add(instructionHeader);
		
		/*Below are the code which are for performing the task*/
		
		customerTableList.addMouseListener(this); 
		try 
	    {
			file.readCustomersFromFile();//read customer record from text file
			file.customers.sortCustomerByName();//sort the customer by name
			displayCustomerOnTable();//display the customer record to table
	   	}catch(Exception e) 
	    {
    		JOptionPane.showMessageDialog(null,e.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
    	}
		
		try 
	    {
    		file.readSelfCollectedOrderFromTextFile();//read self-collected order from file 
    	}catch(Exception e) 
	    {
    		JOptionPane.showMessageDialog(null,e.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
    	}
	    
	    try 
	    {
    		file.readDeliveryOrderFromTextFile();//read delivery order from file
    	}catch(Exception e) 
	    {
    		JOptionPane.showMessageDialog(null,e.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
    	}
	}
	/*
	 * Function to display customer details on table using collection
	 */
	public void displayCustomerOnTable() 
	{
		DefaultTableModel model = (DefaultTableModel)customerTableList.getModel();
		Object[] customersRow ;
		//Console Header
		System.out.println("Customers list: ");
		border.tableBorderForCustomer();//display border on console
		//display the header on console
		System.out.printf("%1s %-30s %1s %-19s %1s %-19s %1s\n", "|","Name","|","Identity Number","|","Contact Number","|");
		border.tableBorderForCustomer();//display border on console
		for(Customer customer:file.customers.customer) 
		{
			//get the details of customer
			customersRow = new Object[] {customer.getName(),customer.getIdentityNumber(), customer.getContactNumber()};
			model.addRow(customersRow);//add row to the customer
			System.out.println(customer.toString());
		}
		border.tableBorderForCustomer();//display border on console
	}
	/*
	 * Function to display the delivery order on table using collection class
	 */
	public void displayDeliveryOrderRecordOnTable(CustomersOrderDetailsGUI cusOrderdetails, String customersID)
	{
		DefaultTableModel model = (DefaultTableModel)cusOrderdetails.deliveryTable.getModel();
		Object[] deliveryRow ;
		//display on console
		System.out.println("Delivery record");
		//display on console header
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
		System.out.printf("%1s %-15s %1s %50s %1s %-8s %1s %6s %1s %-12s %1s %-15s %1s %-15s %1s %-16s %1s %14s %1s %-40s %1s %-10s %1s %-20s %1s\n",
		           "|","customer ID","|","Food Name","|","Quantity","|","Prices","|","Total Price","|","Date","|","Time","|","Delivery Charge","|","Overall Price","|"
		           ,"Address","|","Postcode","|","Area","|");
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
		for(DeliveryOrder delivery:file.orders.deliveryorder) 
		{
			if(delivery.getCustomerId().contentEquals(customersID))//if the customer's identity number is matched  
			{
 				//get the details of the delivery order
				deliveryRow = new Object[]{delivery.getCustomerId(), delivery.getFoodName(),delivery.getQuantity(),
						   				   delivery.getPrice(), delivery.getTotalPrice(),delivery.getDate(),
						   				   delivery.getTime(),delivery.getDelivery_charge(),delivery.getOverallPrice(), 
						                   delivery.getAddress(),delivery.getPostcode(),delivery.getArea()};
				model.addRow(deliveryRow);//add the row to table
				//Display on console
				System.out.println(delivery.toString());
			}
		}
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
	}
	/*
	 * Function to display the self-collected order on table using collection class
	 */
	public void displaySelfCollectedOrderRecordOnTable(CustomersOrderDetailsGUI cusOrderdetails, String customersID)
	{
		DefaultTableModel model = (DefaultTableModel)cusOrderdetails.selfCollectedTable.getModel();
		Object[] selfCollectedRow ;
		//display on console
		System.out.println("Self-collected record");
		border.tableBorderForSelfCollectedOrder();//display border on console
		//display on console header
		System.out.printf("%1s %-15s %1s %50s %1s %-8s %1s %6s %1s %-12s %1s %-15s %1s %-15s %1s %-8s %1s %14s %1s\n",
		           "|","customer ID","|","Food Name","|","Quantity","|","Prices","|","Total Price","|","Date","|","Time","|","Discount","|","Overall Price","|");
		border.tableBorderForSelfCollectedOrder();//display border on console
		for(SelfCollectedOrder order:file.orders.selfcollectedorder) 
		{
			if(order.getCustomerId().contentEquals(customersID))//if the customer's identity number is matched 
			{
				//get the details of self-collected order
				selfCollectedRow = new Object[] {order.getFoodName(),order.getQuantity(),order.getPrice(),
											order.getTotalPrice(),order.getDiscount()};
				model.addRow(selfCollectedRow);//add the row to table
				//Display on console
				System.out.println(order.toString());
			}
		}
		border.tableBorderForSelfCollectedOrder();//display border on console
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
			
    	int index = customerTableList.getSelectedRow();
    	TableModel model = customerTableList.getModel();
    	//get the details from selected table row
    	String customerName = model.getValueAt(index, 0).toString();
    	String customerID = model.getValueAt(index, 1).toString();
    	String customerPhoneNumber = model.getValueAt(index, 2).toString();
		
    	CustomersOrderDetailsGUI cusOrderdetails = new CustomersOrderDetailsGUI();
    	cusOrderdetails.setVisible(true);
    	//set the details to the text field
    	cusOrderdetails.customerNameTextField.setText(customerName);
    	cusOrderdetails.customerIDTextField.setText(customerID);
    	cusOrderdetails.customerContactNumberTextField.setText(customerPhoneNumber);
    	orders.sortDeliveyOrderByArea();//sort the delivery order record by area
    	displayDeliveryOrderRecordOnTable(cusOrderdetails,model.getValueAt(index, 1).toString());//display the related delivery order to table
    	displaySelfCollectedOrderRecordOnTable(cusOrderdetails,model.getValueAt(index, 1).toString());//display the related self-collected order to table
	}
}
