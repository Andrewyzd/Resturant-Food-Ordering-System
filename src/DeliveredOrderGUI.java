import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DeliveredOrderGUI extends JFrame {

	private JPanel contentPane,deliveredPanel;
	private JLabel deliveredHeaderLabel;
	private JScrollPane deliveredScrollPane;
	private JTable deliveredTable;
	ConcoleTableLine border = new ConcoleTableLine();
	/**
	 * Constructor to display window frame and components
	 */
	public DeliveredOrderGUI() {
		setBounds(new Rectangle(0, 0, 1282, 330));
		setTitle("Delivered Delivery Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1314, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//Designed returned panel
		deliveredPanel = new JPanel();
		deliveredPanel.setBorder(null);
		deliveredPanel.setBackground(new Color(47, 79, 79));
		deliveredPanel.setBounds(0, 665, 1282, 330);
		contentPane.add(deliveredPanel);
		deliveredPanel.setLayout(null);
		
		//Design header of returned
		deliveredHeaderLabel = new JLabel("Delivered");
		deliveredHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deliveredHeaderLabel.setForeground(Color.GREEN);
		deliveredHeaderLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		deliveredHeaderLabel.setBorder(null);
		deliveredHeaderLabel.setBackground(new Color(255, 215, 0));
		deliveredHeaderLabel.setBounds(502, 13, 295, 56);
		deliveredPanel.add(deliveredHeaderLabel);
		
		//Design returned list table
		deliveredTable = new JTable();
		deliveredTable.setBorder(new LineBorder(Color.GREEN, 1, true));
		deliveredTable.setBounds(86, 110, 1, 1);
		deliveredTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area","Order ID"}
			));	
		
		//Design scroll pane for returned table
		deliveredScrollPane = new JScrollPane(deliveredTable);
		deliveredScrollPane.setBorder(new LineBorder(Color.GREEN, 2, true));
		deliveredScrollPane.setBounds(12, 82, 1262, 404);
		deliveredPanel.add(deliveredScrollPane);
		
		try 
		{
			readAndDisplayReturnedOrderFromTextFile();//read the returned order from text file
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"Information",JOptionPane.PLAIN_MESSAGE);
		}

	}
	/*
	 * Function to read and display returned order from text file and to table
	 */
	public void readAndDisplayReturnedOrderFromTextFile()throws FileNotFoundException, IOException 
	{
		DefaultTableModel model = (DefaultTableModel)deliveredTable.getModel();
		Scanner read = new Scanner(new FileReader("DeliveredOrder.txt")); 
		DeliveryOrder deliveryOrder;
		String customerID, foodName, foodQuantityText, pricesText, totalPriceText, date, time, deliveryChargeText, overallPriceText,postcode,address,area,orderID;
		int foodQuantity;
		double prices, totalprice, deliveryCharge, overallPrice;
		Object[] returnedRow;
	
		File file = new File("DeliveredOrder.txt");//if the file is not exist
		if (!file.exists() || file.length() == 0)
		{
			throw new IllegalStateException("There is no returned order.");
		}
		//display on console
		System.out.println("Retured Delivery order List: ");
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
		//display on console header
		System.out.printf("%1s %-15s %1s %50s %1s %-8s %1s %6s %1s %-12s %1s %-15s %1s %-15s %1s %-16s %1s %14s %1s %-40s %1s %-10s %1s %-20s %1s %-8s %1s\n",
		           "|","customer ID","|","Food Name","|","Quantity","|","Prices","|","Total Price","|","Date","|","Time","|","Delivery Charge","|","Overall Price","|"
		           ,"Address","|","Postcode","|","Area","|","Order ID","|");
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
		do 
		{	
			//Read the details from text file
			customerID = read.nextLine();
			foodName = read.nextLine();
			foodQuantityText = read.nextLine();
			foodQuantity = Integer.parseInt(foodQuantityText);
			pricesText = read.nextLine();
			prices = Double.parseDouble(pricesText);
			totalPriceText = read.nextLine();
			totalprice = Double.parseDouble(totalPriceText);
			date = read.nextLine();
			time = read.nextLine();
			deliveryChargeText = read.nextLine();
			deliveryCharge = Double.parseDouble(deliveryChargeText);
			overallPriceText = read.nextLine();
			overallPrice = Double.parseDouble(overallPriceText);
			address = read.nextLine();
			postcode = read.nextLine();
			area = read.nextLine();
			orderID = read.nextLine();
			//set the details to object
			returnedRow = new Object[] {customerID, foodName, foodQuantity, prices, totalprice, date, time, deliveryCharge, overallPrice,address,postcode,area,orderID};
			model.addRow(returnedRow);//add to the delete table row
			//Display on console
			System.out.printf("%1s %-15s %1s %50s %1s %8d %1s %.3f %1s %.9f %1s %-15s %1s %-15s %1s %.13f %1s %.11f %1s %-40s %1s %-10s %1s %-20s %1s %-8s %1s\n",
					           "|",customerID,"|",foodName,"|",foodQuantity,"|",prices,"|",totalprice,"|",date,"|",time,"|",deliveryCharge,"|",overallPrice,"|",address,
					           "|",postcode,"|",area,"|",orderID,"|");
		}while(read.hasNextLine());
		border.tableBorderForDeliveryAndReturnedOrder();//display border on console
	}
}
