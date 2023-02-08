import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

public class UpdateOrdersGUI extends MouseAdapter implements ActionListener {

	private JPanel contentPane, inProgressPanel, deliveredPanel, returnedPanel,deliveredButtonPanel, returnedButtonPanel, saveButtonPanel;
	private JLabel inProgressHeaderLabel,deliveredHeaderLabel,returnedHeaderLabel;
	private JButton deliveredButton,returnedButton,saveButton;
	private JScrollPane deliveredScrollPane,returnedScrollPane,deliveryOrderScrollPane;
	private JTable deliveryOrderListTable, deliveredTable,returnedTable;
	public JFrame updateOrderFrame;
	Orders orders = new Orders();
	FileHandling file = new FileHandling();
	ConcoleTableLine border = new ConcoleTableLine();
	/**
	 * Constructor to display window frame and components
	 */
	public UpdateOrdersGUI() 
	{
		//Design the windows frame 
		updateOrderFrame = new JFrame();
		updateOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateOrderFrame.setBounds(100, 100, 1300, 1042);
		updateOrderFrame.setTitle("Update the delivery order");
		updateOrderFrame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		updateOrderFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design progress panel
		inProgressPanel = new JPanel();
		inProgressPanel.setBorder(null);
		inProgressPanel.setBackground(new Color(47, 79, 79));
		inProgressPanel.setBounds(0, 0, 1282, 330);
		contentPane.add(inProgressPanel);
		inProgressPanel.setLayout(null);
		//Design header of progress
		inProgressHeaderLabel = new JLabel("In Progress...");
		inProgressHeaderLabel.setBorder(null);
		inProgressHeaderLabel.setBackground(new Color(255, 215, 0));
		inProgressHeaderLabel.setForeground(new Color(255, 215, 0));
		inProgressHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		inProgressHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inProgressHeaderLabel.setBounds(493, 13, 295, 54);
		inProgressPanel.add(inProgressHeaderLabel);
		//Design delivered panel
		deliveredPanel = new JPanel();
		deliveredPanel.setBorder(null);
		deliveredPanel.setBackground(new Color(47, 79, 79));
		deliveredPanel.setBounds(0, 333, 1282, 330);
		contentPane.add(deliveredPanel);
		deliveredPanel.setLayout(null);
		//design header of delivered
		deliveredHeaderLabel = new JLabel("Delivered");
		deliveredHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deliveredHeaderLabel.setForeground(new Color(124, 252, 0));
		deliveredHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		deliveredHeaderLabel.setBorder(null);
		deliveredHeaderLabel.setBackground(new Color(255, 215, 0));
		deliveredHeaderLabel.setBounds(481, 13, 295, 55);
		deliveredPanel.add(deliveredHeaderLabel);
		//Designed returned panel
		returnedPanel = new JPanel();
		returnedPanel.setBorder(null);
		returnedPanel.setBackground(new Color(47, 79, 79));
		returnedPanel.setBounds(0, 665, 1282, 330);
		contentPane.add(returnedPanel);
		returnedPanel.setLayout(null);
		//Design header of returned
		returnedHeaderLabel = new JLabel("Returned");
		returnedHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		returnedHeaderLabel.setForeground(new Color(255, 0, 0));
		returnedHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		returnedHeaderLabel.setBorder(null);
		returnedHeaderLabel.setBackground(new Color(255, 215, 0));
		returnedHeaderLabel.setBounds(487, 13, 295, 56);
		returnedPanel.add(returnedHeaderLabel);
		//Design the delivery order list table
		deliveryOrderListTable = new JTable();
		deliveryOrderListTable.setBorder(new LineBorder(new Color(255, 204, 0), 1, true));
		deliveryOrderListTable.setBounds(86, 110, 1, 1);
		deliveryOrderListTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area","Order ID"}
			));
		//Design delivered list table
		deliveredTable = new JTable();
		deliveredTable.setBorder(new LineBorder(Color.GREEN, 1, true));
		deliveredTable.setBounds(86, 110, 1, 1);
		deliveredTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area","Order ID"}
			));	
		//Design returned list table
		returnedTable = new JTable();
		returnedTable.setBorder(new LineBorder(Color.RED, 1, true));
		returnedTable.setBounds(86, 110, 1, 1);
		returnedTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area", "Order ID"}
			));	
		//Design scroll pane for delivery order table
		deliveryOrderScrollPane = new JScrollPane(deliveryOrderListTable);
		deliveryOrderScrollPane.setBorder(new LineBorder(new Color(255, 204, 0), 2, true));
		deliveryOrderScrollPane.setBounds(12, 80, 1258, 228);
		inProgressPanel.add(deliveryOrderScrollPane);
		//Design panel for delivered button
		deliveredButtonPanel = new JPanel();
		deliveredButtonPanel.setBackground(new Color(204, 204, 255));
		deliveredButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		deliveredButtonPanel.setBounds(962, 31, 148, 36);
		inProgressPanel.add(deliveredButtonPanel);
		deliveredButtonPanel.setLayout(null);
		//Design delivered button
		deliveredButton = new JButton("Delivered Order");
		deliveredButton.setEnabled(false);
		deliveredButton.setContentAreaFilled(false);
		deliveredButton.setBackground(new Color(240, 240, 240));
		deliveredButton.setOpaque(false);
		deliveredButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		deliveredButton.setForeground(new Color(255, 255, 255));
		deliveredButton.setBounds(0, 0, 148, 36);
		deliveredButtonPanel.add(deliveredButton);
		//Design panel for returned button
		returnedButtonPanel = new JPanel();
		returnedButtonPanel.setBackground(new Color(204, 204, 255));
		returnedButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		returnedButtonPanel.setBounds(1122, 31, 148, 36);
		inProgressPanel.add(returnedButtonPanel);
		returnedButtonPanel.setLayout(null);
		//Design returned button
		returnedButton = new JButton("Returned Order");
		returnedButton.setEnabled(false);
		returnedButton.setContentAreaFilled(false);
		returnedButton.setBackground(new Color(240, 240, 240));
		returnedButton.setOpaque(false);
		returnedButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		returnedButton.setForeground(new Color(255, 255, 255));
		returnedButton.setBounds(0, 0, 148, 36);
		returnedButtonPanel.add(returnedButton);
		//Design panel for back menu button
		saveButtonPanel = new JPanel();
		saveButtonPanel.setLayout(null);
		saveButtonPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		saveButtonPanel.setBackground(new Color(255, 153, 51));
		saveButtonPanel.setBounds(12, 31, 175, 36);
		inProgressPanel.add(saveButtonPanel);
		//Design back menu button
		saveButton = new JButton("Save and Return");
		saveButton.setOpaque(false);
		saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		saveButton.setContentAreaFilled(false);
		saveButton.setBackground(new Color(255, 250, 250));
		saveButton.setBounds(0, 0, 175, 36);
		saveButtonPanel.add(saveButton);
		//Design scroll pane for delivered table
		deliveredScrollPane = new JScrollPane(deliveredTable);
		deliveredScrollPane.setBorder(new LineBorder(new Color(0, 255, 102), 2, true));
		deliveredScrollPane.setBounds(12, 76, 1258, 228);
		deliveredPanel.add(deliveredScrollPane);
		//Design scroll pane for returned table
		returnedScrollPane = new JScrollPane(returnedTable);
		returnedScrollPane.setBorder(new LineBorder(new Color(255, 0, 51), 2, true));
		returnedScrollPane.setBounds(12, 82, 1258, 228);
		returnedPanel.add(returnedScrollPane);
		
		/*Below are the code which are for performing the task*/
		
		deliveryOrderListTable.addMouseListener(this);
		deliveredButton.addActionListener(this);
		returnedButton.addActionListener(this);
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try 
				{
					updateOrderFrame.setVisible(false);//invisible the update window frame
					file.deleteContentOfDeliveryOrderFile();//delete the content of delivery order
					savingUpdatedDeliveryOrdersToTextFile();//record the updated record to delivery order
					MainMenuPage mainMenuWindow = new MainMenuPage();
					mainMenuWindow.setVisible(true);//visible the main menu window
				}catch(Exception error) 
				{
					JOptionPane.showMessageDialog(null,error.getMessage(),"Information",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		try 
		{
			file.readDeliveryOrderFromTextFile();//read the delivery order from text file
			orders.sortDeliveyOrderByArea();//sort the delivery order based on area
			displayAllOrderToTable();//display all the delivery record to table
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Information",JOptionPane.PLAIN_MESSAGE);
		}

	}
	/*
	 * Function to display all delivery order to table
	 */
	public void displayAllOrderToTable() 
	{
		DefaultTableModel model = (DefaultTableModel)deliveryOrderListTable.getModel();
		Object[] deliveryRow;
		//display on console
		System.out.println("Delivery record");
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
		//display on console header
		System.out.printf("%1s %-15s %1s %50s %1s %-8s %1s %6s %1s %-12s %1s %-15s %1s %-15s %1s %-16s %1s %14s %1s %-40s %1s %-10s %1s %-20s %1s %-8s %1s\n",
		           "|","customer ID","|","Food Name","|","Quantity","|","Prices","|","Total Price","|","Date","|","Time","|","Delivery Charge","|","Overall Price","|"
		           ,"Address","|","Postcode","|","Area","|","Order ID","|");
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
     		for(DeliveryOrder delivery : file.orders.deliveryorder) 
     		{
     			//get the details of the orders	
     			deliveryRow = new Object[]{delivery.getCustomerId(), delivery.getFoodName(),delivery.getQuantity(),
     										   delivery.getPrice(), delivery.getTotalPrice(),delivery.getDate(),
     										   delivery.getTime(),delivery.getDelivery_charge(),delivery.getOverallPrice(), 
     										   delivery.getAddress(),delivery.getPostcode(),delivery.getArea(),delivery.getOrderID()};
     				model.addRow(deliveryRow);//add the details to table row
    				//Display on console
    				System.out.println(delivery.toString());
    		}
     	border.tableBorderForDeliveryAndReturnedOrder();//display border on console
	}
	/*
	 * Function to update the delivery order list in the text file
	 */
	public void savingUpdatedDeliveryOrdersToTextFile()throws FileNotFoundException, IOException
	{
		TableModel model = deliveryOrderListTable.getModel();
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			//read the information from table 
			String customerID = model.getValueAt(i, 0).toString();
			String foodName = model.getValueAt(i, 1).toString();
			int foodQuantity = Integer.parseInt(model.getValueAt(i, 2).toString());//convert quantity to integer
			double prices = Double.parseDouble(model.getValueAt(i, 3).toString());//convert price to double
			double totalprice = Double.parseDouble(model.getValueAt(i, 4).toString());//convert total price to double
			String date = model.getValueAt(i, 5).toString();
			String time = model.getValueAt(i, 6).toString();
			double deliveryCharge = Double.parseDouble(model.getValueAt(i, 7).toString());//convert delivery charge to double
			double overallPrice = Double.parseDouble(model.getValueAt(i, 8).toString());//convert overall chare to double
			String address = model.getValueAt(i, 9).toString();
			String postcode = model.getValueAt(i, 10).toString();
			String area = model.getValueAt(i, 11).toString();
			String orderID = model.getValueAt(i, 12).toString();
			//write to text file
			file.savingDeliveryOrdersToTextFile(customerID,foodName,foodQuantity,prices,totalprice,date,time,deliveryCharge,overallPrice,address,postcode,area,orderID);
		}			
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		deliveredButtonPanel.setBackground(new Color(0, 204, 51));
		deliveredButtonPanel.setBorder(new LineBorder(new Color(0, 255, 51), 1, true));
		
		returnedButtonPanel.setBackground(new Color(204, 0, 51));
		returnedButtonPanel.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		
		deliveredButton.setEnabled(true);
		returnedButton.setEnabled(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		 Object source = event.getSource();
		 DefaultTableModel deliveryOrderModel = (DefaultTableModel)deliveryOrderListTable.getModel();
		 DefaultTableModel deliveredModel = (DefaultTableModel)deliveredTable.getModel();
		 DefaultTableModel returnedModel = (DefaultTableModel)returnedTable.getModel();
		 Object[] deliveredRow, returnedRow;
		 int selectedTableRow  = deliveryOrderListTable.getSelectedRow();
		 //get the details of the selected row
		 deliveredRow = new Object[]{deliveryOrderModel.getValueAt(selectedTableRow, 0).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 1).toString(),
					 deliveryOrderModel.getValueAt(selectedTableRow, 2).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 3).toString(), 
					 deliveryOrderModel.getValueAt(selectedTableRow, 4).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 5).toString(),
					 deliveryOrderModel.getValueAt(selectedTableRow, 6).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 7).toString(),
					 deliveryOrderModel.getValueAt(selectedTableRow, 8).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 9).toString(),
					 deliveryOrderModel.getValueAt(selectedTableRow, 10).toString(), deliveryOrderModel.getValueAt(selectedTableRow, 11).toString(),
					 deliveryOrderModel.getValueAt(selectedTableRow, 12).toString()};
		 
		 if(source == deliveredButton)// if user press delivered button 
		 {
			 try 
			 {
				 deliveryOrderModel.removeRow(selectedTableRow);//remove the row on the delivered table 
				 deliveredModel.addRow(deliveredRow);//add the row to delivered table
				 file.savingDeliveredOrdersToTextFile(deliveredRow);//save the details to files
			 }catch(Exception error) 
			 {
				 JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
			 }
		 }
			 
		 else if(source == returnedButton)//if user press returned button 
		 {
			 try 
			 {
				 deliveryOrderModel.removeRow(selectedTableRow);//remove the row on the delivered table 
				 returnedModel.addRow(deliveredRow);//add the row to returned table
				 file.savingReturnedOrdersToTextFile(deliveredRow);//save the details to files 
			 }catch(Exception error) 
			 {
				 JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
			 }
		 }
	}
}
