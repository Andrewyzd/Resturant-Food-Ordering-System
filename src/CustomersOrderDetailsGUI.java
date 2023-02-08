import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomersOrderDetailsGUI extends JFrame {

	private JPanel contentPane;
	private JLabel Label_BackgroundImage;
	private JTextField customersDetailsHeader,customerNameHeader, customerIDHeader,customerContactNumberHeader,tableHeaderSelfCollected,tableHeaderDelivery;
	private JScrollPane selfCollectedScrollPane, deliveryScrollPane;
	public  JTextField customerNameTextField, customerIDTextField,customerContactNumberTextField;
	public  JTable selfCollectedTable,deliveryTable;
	/**
	 * Constructor to display window frame and components
	 */
	public CustomersOrderDetailsGUI() 
	{
		//Design the customer background image 
		ImageIcon backgroundIcon = new ImageIcon("ImageIcon\\customerBackground.jpg"); // load the image to a imageIcon
		Image backgroundImage = backgroundIcon.getImage();// transform it 
		Image newimg_background= backgroundImage.getScaledInstance(1360, 645,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backgroundIcon = new ImageIcon(newimg_background);
		//Design the windows frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1360, 645);
		setTitle("Customer Order Details");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design the label for background image
		Label_BackgroundImage = new JLabel(backgroundIcon);
		Label_BackgroundImage.setBounds(0, 0, 1360, 645);
		contentPane.add(Label_BackgroundImage);
		//Design the header for name 
		customerNameHeader = new JTextField();
		customerNameHeader.setForeground(new Color(255, 255, 255));
		customerNameHeader.setOpaque(false);
		customerNameHeader.setBorder(null);
		customerNameHeader.setEditable(false);
		customerNameHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
		customerNameHeader.setText("Customer Name:");
		customerNameHeader.setColumns(10);
		customerNameHeader.setBounds(33, 63, 140, 50);
		Label_BackgroundImage.add(customerNameHeader);
		//Design the header for customer identity number
		customerIDHeader = new JTextField();
		customerIDHeader.setForeground(new Color(255, 255, 255));
		customerIDHeader.setOpaque(false);
		customerIDHeader.setBorder(null);
		customerIDHeader.setEditable(false);
		customerIDHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
		customerIDHeader.setText("Customer ID:");
		customerIDHeader.setColumns(10);
		customerIDHeader.setBounds(33, 126, 126, 50);
		Label_BackgroundImage.add(customerIDHeader);
		//Design the header for customer contact number
		customerContactNumberHeader = new JTextField();
		customerContactNumberHeader.setForeground(new Color(255, 255, 255));
		customerContactNumberHeader.setOpaque(false);
		customerContactNumberHeader.setBorder(null);
		customerContactNumberHeader.setEditable(false);
		customerContactNumberHeader.setFont(new Font("Times New Roman", Font.BOLD, 18));
		customerContactNumberHeader.setText("Contact number:");
		customerContactNumberHeader.setColumns(10);
		customerContactNumberHeader.setBounds(33, 189, 140, 50);
		Label_BackgroundImage.add(customerContactNumberHeader);
		//Design the name text field
		customerNameTextField = new JTextField();
		customerNameTextField.setBackground(Color.WHITE);
		customerNameTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		customerNameTextField.setForeground(new Color(0, 0, 0));
		customerNameTextField.setEditable(false);
		customerNameTextField.setColumns(10);
		customerNameTextField.setBounds(185, 64, 321, 50);
		Label_BackgroundImage.add(customerNameTextField);
		//Design the identity number text field
		customerIDTextField = new JTextField();
		customerIDTextField.setBackground(Color.WHITE);
		customerIDTextField.setForeground(new Color(0, 0, 0));
		customerIDTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		customerIDTextField.setEditable(false);
		customerIDTextField.setColumns(10);
		customerIDTextField.setBounds(185, 127, 321, 50);
		Label_BackgroundImage.add(customerIDTextField);
		//Design the contact number text field
		customerContactNumberTextField = new JTextField();
		customerContactNumberTextField.setBackground(Color.WHITE);
		customerContactNumberTextField.setForeground(new Color(0, 0, 0));
		customerContactNumberTextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		customerContactNumberTextField.setEditable(false);
		customerContactNumberTextField.setColumns(10);
		customerContactNumberTextField.setBounds(185, 190, 321, 50);
		Label_BackgroundImage.add(customerContactNumberTextField);
		//Design the self-collected table
		selfCollectedTable = new JTable();
		selfCollectedTable.setBackground(Color.WHITE);
		selfCollectedTable.setBounds(0, 291, 470, 308);
		//Design the delivery table
		deliveryTable = new JTable();
		deliveryTable.setBackground(Color.WHITE);
		deliveryTable.setBounds(0, 291, 470, 308);
		//Design the self-collected scroll pane
		selfCollectedScrollPane = new JScrollPane(selfCollectedTable);
		selfCollectedScrollPane.setBounds(0, 291, 487, 308);
		Label_BackgroundImage.add(selfCollectedScrollPane);
		//Design the delivery scroll pane
		deliveryScrollPane = new JScrollPane(deliveryTable);
		deliveryScrollPane.setBounds(491, 291, 851, 308);
		Label_BackgroundImage.add(deliveryScrollPane);
		//Set the header of each column of self-collected order table
		selfCollectedTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Food Name", "Quantity", "Price(MYR)", "Total Price(MYR)", "Discount"}
		));
		//Set the header of each column of delivery order table
		deliveryTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area"
			}
		));
		
		selfCollectedTable.getTableHeader().setOpaque(false);
		selfCollectedTable.getTableHeader().setBackground(new Color(102, 153, 102));
		selfCollectedTable.getTableHeader().setForeground(new Color(255,255,255)); 
		
		deliveryTable.getTableHeader().setOpaque(false);
		deliveryTable.getTableHeader().setBackground(new Color(102, 153, 102));
		deliveryTable.getTableHeader().setForeground(new Color(255,255,255)); 
		//Design header for customer details
		customersDetailsHeader = new JTextField();
		customersDetailsHeader.setForeground(new Color(255, 255, 255));
		Label_BackgroundImage.add(customersDetailsHeader);
		customersDetailsHeader.setEditable(false);
		customersDetailsHeader.setBorder(null);
		customersDetailsHeader.setOpaque(false);
		customersDetailsHeader.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		customersDetailsHeader.setHorizontalAlignment(SwingConstants.CENTER);
		customersDetailsHeader.setText("Customers Details");
		customersDetailsHeader.setBounds(12, 0, 208, 62);
		customersDetailsHeader.setColumns(10);
		//Design header for self-collected table
		tableHeaderSelfCollected = new JTextField();
		tableHeaderSelfCollected.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeaderSelfCollected.setText("Self-Collected");
		tableHeaderSelfCollected.setOpaque(false);
		tableHeaderSelfCollected.setForeground(Color.WHITE);
		tableHeaderSelfCollected.setFont(new Font("Times New Roman", Font.BOLD, 23));
		tableHeaderSelfCollected.setEditable(false);
		tableHeaderSelfCollected.setColumns(10);
		tableHeaderSelfCollected.setBorder(null);
		tableHeaderSelfCollected.setBounds(166, 251, 140, 40);
		Label_BackgroundImage.add(tableHeaderSelfCollected);
		//Design header for delivery table
		tableHeaderDelivery = new JTextField();
		Label_BackgroundImage .add(tableHeaderDelivery);
		tableHeaderDelivery.setText("Delivery Order");
		tableHeaderDelivery.setOpaque(false);
		tableHeaderDelivery.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeaderDelivery.setForeground(Color.WHITE);
		tableHeaderDelivery.setFont(new Font("Times New Roman", Font.BOLD, 23));
		tableHeaderDelivery.setEditable(false);
		tableHeaderDelivery.setColumns(10);
		tableHeaderDelivery.setBorder(null);
		tableHeaderDelivery.setBounds(878, 251, 154, 40);
	}
}