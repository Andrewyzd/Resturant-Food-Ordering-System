import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AssignWorkToRiderGUI extends JFrame{

	private JPanel contentPane,  assignButtonPanel, headerPanel;
	public JTextField nameHeaderText, nameText, idHearderText, contactNumberHeaderText, idText, contactNumberText,postcodeHeaderText;
	public Choice postcodeChoice = new Choice();
	private JLabel mapIconLabel, workIconLabel;
	private JButton assignButton;
	private JScrollPane postcodeTableScrollPane;
	private JTable postcodeTable;
	FileHandling file = new FileHandling();
	/**
	 * constructure to display the windows and the component of interface
	 */
	public AssignWorkToRiderGUI() {
		//Design for window frame
		setTitle("Assign Work");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 555);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Set the layout of the displayed image
		ImageIcon userIcon = new ImageIcon("ImageIcon//workerIcon.png"); // load the image to a imageIcon
		Image userImage = userIcon.getImage();// transform it 
		Image newimg_user= userImage.getScaledInstance(68, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		userIcon = new ImageIcon(newimg_user);
		//Design map Icon
		ImageIcon useraddress = new ImageIcon("ImageIcon//mapIcon.png"); // load the image to a imageIcon
		Image Iconaddress = useraddress.getImage();// transform it 
		Image newimg_address= Iconaddress.getScaledInstance(116, 104,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		useraddress = new ImageIcon(newimg_address);
		//Design the panel
		headerPanel = new JPanel();
		headerPanel.setBorder(new LineBorder(new Color(0, 153, 51), 1, true));
		headerPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		headerPanel.setBackground(new Color(0, 153, 102));
		headerPanel.setBounds(0, 0, 478, 73);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);
		//Design assign Button Icon
		assignButtonPanel = new JPanel();
		assignButtonPanel.setBackground(new Color(0, 204, 0));
		assignButtonPanel.setBounds(354, 462, 105, 38);
		contentPane.add(assignButtonPanel);
		assignButtonPanel.setLayout(null);
		//Design the icon label
		workIconLabel = new JLabel("Assign Order");
		workIconLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		workIconLabel.setForeground(Color.WHITE);
		workIconLabel.setBounds(12, 0, 387, 73);
		workIconLabel.setIcon(userIcon);
		headerPanel.add(workIconLabel);
		//Design map Icon Label
		mapIconLabel = new JLabel(useraddress);
		mapIconLabel.setBounds(10, 86, 116, 104);
		mapIconLabel.setIcon(useraddress);
		contentPane.add(mapIconLabel);
	    //Design the header textfield
		postcodeHeaderText = new JTextField();
		postcodeHeaderText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		postcodeHeaderText.setSelectedTextColor(new Color(0, 0, 0));
		postcodeHeaderText.setText("Select the postcode below to assign the order");
		postcodeHeaderText.setOpaque(false);
		postcodeHeaderText.setForeground(Color.GRAY);
		postcodeHeaderText.setEditable(false);
		postcodeHeaderText.setColumns(10);
		postcodeHeaderText.setBorder(null);
		postcodeHeaderText.setBounds(12, 203, 366, 22);
		contentPane.add(postcodeHeaderText);
		//Design the header of name text
		nameHeaderText = new JTextField();
		nameHeaderText.setBorder(null);
		nameHeaderText.setOpaque(false);
		nameHeaderText.setEditable(false);
		nameHeaderText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		nameHeaderText.setText("Name: ");
		nameHeaderText.setBounds(149, 86, 116, 22);
		contentPane.add(nameHeaderText);
		nameHeaderText.setColumns(10);
		//Design the name text field
		nameText = new JTextField();
		nameText.setColumns(10);
		nameText.setBounds(267, 86, 192, 22);
		contentPane.add(nameText);
		//Design the header of id text 
		idHearderText = new JTextField();
		idHearderText.setOpaque(false);
		idHearderText.setBorder(null);
		idHearderText.setEditable(false);
		idHearderText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		idHearderText.setText("Identity number:");
		idHearderText.setColumns(10);
		idHearderText.setBounds(149, 121, 116, 22);
		contentPane.add(idHearderText);
		//Design the header for contact number
		contactNumberHeaderText = new JTextField();
		contactNumberHeaderText.setBorder(null);
		contactNumberHeaderText.setOpaque(false);
		contactNumberHeaderText.setEditable(false);
		contactNumberHeaderText.setText("Contact number:");
		contactNumberHeaderText.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contactNumberHeaderText.setColumns(10);
		contactNumberHeaderText.setBounds(149, 156, 116, 22);
		contentPane.add(contactNumberHeaderText);
		//Design the text for id
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(267, 121, 192, 22);
		contentPane.add(idText);
		//Design the text for contact number
		contactNumberText = new JTextField();
		contactNumberText.setColumns(10);
		contactNumberText.setBounds(267, 156, 192, 22);
		contentPane.add(contactNumberText);
		//Design the assign button 
		assignButton = new JButton("Assign");
		assignButton.setBounds(0,0, 105, 38);
		assignButtonPanel.add(assignButton);
		assignButton.setForeground(new Color(255, 255, 255));
		assignButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		assignButton.setContentAreaFilled(false);
		//Design the postcode table
		postcodeTable = new JTable();
		postcodeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order ID","Postcode"
			}
		));
		postcodeTable.setBounds(141, 294, 1, 1);
		contentPane.add(postcodeTable);
		//Design the scroll pane for table 
		postcodeTableScrollPane = new JScrollPane(postcodeTable);
		postcodeTableScrollPane.setBackground(Color.WHITE);
		postcodeTableScrollPane.setBorder(new LineBorder(Color.GREEN));
		postcodeTableScrollPane.setBounds(12, 254, 454, 195);
		contentPane.add(postcodeTableScrollPane);
		
		/*Below are the code for performing the task */
		
		try 
		{
			file.readDeliveryOrderFromTextFile();//read the assigned information from text file
			addPostcodeToTable();
		}catch(Exception error) {
			JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
		}
		
		assignButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				try 
				{
					setVisible(false);//set the visible to false
					JOptionPane.showMessageDialog(null,CheckforExistingWork(),"Information",JOptionPane.PLAIN_MESSAGE);//display message
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
				}
			}
		});	
	}
	/*
	 * Function to add the postcode of delivery order to table 
	 */
	public void addPostcodeToTable() 
	{
		DefaultTableModel model = (DefaultTableModel)postcodeTable.getModel();
		Object[] deliveryRow;
     		for(DeliveryOrder delivery : file.orders.deliveryorder) 
     		{
     			//get the details of the orders	
     			deliveryRow = new Object[]{delivery.getOrderID(),delivery.getPostcode()};
 				if(model.getRowCount() == 0)//if the table is empty
 				{
 	     			model.addRow(deliveryRow);//add the details to table row
 				}
 				else 
 				{
 					boolean match = false;
 	     			for(int i = 0; i < model.getRowCount();i++) 
 	     			{
 	     				//if the table have contain the orderID already
 	     				if(!deliveryRow[0].toString().equals(model.getValueAt(i, 0).toString())) 
 	     				{match = true;}
 	     				else 
 	     				{
 	     					match  = false;
 	     					break;//exit the loop
 	     				}
 	     			}
	     			//add the details to table row
	     			if(match) {model.addRow(deliveryRow);}
 				}
    		}
	}
	/*
	 * Function to check for available delivery order
	 * @return String This return the message to inform user that the delivery order has been assigned
	 */
	public String CheckforExistingWork()throws FileNotFoundException, IOException 
	{
		DefaultTableModel deliveryOrderModel = (DefaultTableModel)postcodeTable.getModel();
		int index = postcodeTable.getSelectedRow();//get the row number of the selected table 
		String selectedPostcode = deliveryOrderModel.getValueAt(index, 1).toString();
		String selectedOrderID = deliveryOrderModel.getValueAt(index, 0).toString();
		try 
		{
			file.writeAssignedOrderToTextFile(selectedPostcode,selectedOrderID,idText.getText());//write the postcode and rider's id to file 
		}catch(Exception error){
			JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
		}
		return "The work has been assigned successfully";//return the message
	}
}
