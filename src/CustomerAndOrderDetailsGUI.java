import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class CustomerAndOrderDetailsGUI extends MouseAdapter implements ActionListener{

	public  JFrame orderdetailsWindows;
	private JPanel contentPane, doneButtonPanel, cusInfo_panel, contactDetailsHeaderpanel, addButtonPanel, orderInfo_panel;
	private JPanel edit_panel,deletePanel, changeButtonPanel, panelBorderForAddress, newRecordPanel; 
	private JLabel labelForPhoneIcon, labelForOrderingIcon, labelForClock, labelForAddressIcon, labelForUserIcon;
	private JTextField txtContactDetails, nameText, nameHeaderText, phoneNumberHeaderText, phoneNumberText, typeOfOrderingHeaderText;
	private JTextField addressHeaderText, housingNumberHeaderText, streetNumberHeaderText, HousingNumberText, StreetNumberText;
	private JTextField streetNameHeaderText, streetNameText, postcodeHeaderText, penangText, malaysiaText;
	private JTextField txtQuantity, txtPrice, txtTotalPrice;
	private JTextField timeANDdateHeaderText, hourText, minutesText;
	private JTextField idHeaderText, txtFoodName, editQuantityText, editFoodNameText, editPriceText, editTotalPriceText;
	private JTextField deliveryChargeHeaderText, discountHeaderText, discountAmountText, deliveryChargeAmountText, totalOrderPriceHeaderText;
	private JTextField overallPriceText, areaHeaderText, areaText;
	private JCheckBox chckbxDeliveryOrder, chckbxSelfcollected,chckbxDeliveryTime;
	private JButton doneButton, addButton, deleteButton, changeButton, newCustomerRecordButton;
	public JTable orderTable;
	private JScrollPane orderTablescrollPane;
	private Choice postcodeChoice, choiceCustomerID,hour_choice, minutes_choice, ampm_choice, day_choice, month_choice, year_choice;
	private int quantity = 0;
	private String[] customerIDchecker;
	ButtonGroup aGroup = new ButtonGroup();
	FileHandling file = new FileHandling();
	CustomerInformationValidation validate = new CustomerInformationValidation();
	/**
	 * Constructor to display window frame and components
	 */
	public CustomerAndOrderDetailsGUI()
	{
		//Design the windows frame
		orderdetailsWindows = new JFrame();
		orderdetailsWindows.setTitle("Customer Information");
		orderdetailsWindows.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderdetailsWindows.setBounds(100, 100, 1097, 968);
		orderdetailsWindows.setVisible(true);
		//Design the panel for window
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		orderdetailsWindows.setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design the clock image
		ImageIcon clockIcon = new ImageIcon("ImageIcon\\clockIcon.png"); // load the image to a imageIcon
		Image clockImage = clockIcon.getImage();// transform it 
		Image newimg_clock= clockImage.getScaledInstance(56, 53,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		clockIcon = new ImageIcon(newimg_clock);
		//Design the phone image
		ImageIcon phoneIcon = new ImageIcon("ImageIcon\\phoneIcon.png"); // load the image to a imageIcon
		Image phoneImage = phoneIcon.getImage();// transform it 
		Image newimg_phone= phoneImage.getScaledInstance(42, 37,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		phoneIcon = new ImageIcon(newimg_phone);
		//Design the ordering image
		ImageIcon orderingIcon = new ImageIcon("ImageIcon\\OrderingIcon.png"); // load the image to a imageIcon
		Image orderingImage = orderingIcon.getImage();// transform it 
		Image newimg_ordering = orderingImage.getScaledInstance(42, 37,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		orderingIcon = new ImageIcon(newimg_ordering);
		//Design the user image
		ImageIcon userIcon = new ImageIcon("ImageIcon\\userIcon.png"); // load the image to a imageIcon
		Image userImage = userIcon.getImage();// transform it 
		Image newimg_user= userImage.getScaledInstance(68, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		userIcon = new ImageIcon(newimg_user);
		//Design the add customer image
		ImageIcon addUserIcon = new ImageIcon("ImageIcon\\addCusIcon_2.png"); // load the image to a imageIcon
		Image addUserImage = addUserIcon.getImage();// transform it 
		Image newimg_addUser= addUserImage.getScaledInstance(38, 38,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		addUserIcon = new ImageIcon(newimg_addUser);
		//Design the address image
		ImageIcon addressIcon = new ImageIcon("ImageIcon\\addressIcon.png"); // load the image to a imageIcon
		Image addressImage = addressIcon.getImage();// transform it 
		Image newimg_address = addressImage.getScaledInstance(42, 37,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		addressIcon = new ImageIcon(newimg_address);
		//Design the return image	
		ImageIcon returnIcon = new ImageIcon("ImageIcon\\returnIcon.png"); // load the image to a imageIcon
		Image returnImage = returnIcon.getImage();// transform it 
		Image newimg_return= returnImage.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		returnIcon = new ImageIcon(newimg_return);
		//Design the customer information panel
		cusInfo_panel = new JPanel();
		cusInfo_panel.setBorder(new LineBorder(new Color(144, 238, 144), 1, true));
		cusInfo_panel.setBackground(new Color(255, 255, 255));
		cusInfo_panel.setBounds(12, 13, 485, 743);
		contentPane.add(cusInfo_panel);
		cusInfo_panel.setLayout(null);
		//Design panel for contact details header
		contactDetailsHeaderpanel = new JPanel();
		contactDetailsHeaderpanel.setBorder(new LineBorder(new Color(144, 238, 144)));
		contactDetailsHeaderpanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contactDetailsHeaderpanel.setBackground(new Color(0, 204, 102));
		contactDetailsHeaderpanel.setBounds(0, 0, 485, 53);
		cusInfo_panel.add(contactDetailsHeaderpanel);
		contactDetailsHeaderpanel.setLayout(null);
		//Design contact details text field 
		txtContactDetails = new JTextField();
		txtContactDetails.setForeground(new Color(255, 255, 255));
		txtContactDetails.setOpaque(false);
		txtContactDetails.setEditable(false);
		txtContactDetails.setFont(new Font("Times New Roman", Font.BOLD, 23));
		txtContactDetails.setText("CONTACT DETAILS");
		txtContactDetails.setBorder(null);
		txtContactDetails.setBounds(92, 13, 225, 34);
		contactDetailsHeaderpanel.add(txtContactDetails);
		txtContactDetails.setColumns(10);
		//Design label for user image
		labelForUserIcon = new JLabel("");
		labelForUserIcon.setBounds(12, 0, 80, 53);
		labelForUserIcon.setIcon(userIcon);
		contactDetailsHeaderpanel.add(labelForUserIcon);
		//Design panel for adding new customer record button
		newRecordPanel = new JPanel();
		newRecordPanel.setBorder(null);
		newRecordPanel.setOpaque(false);
		newRecordPanel.setLayout(null);
		newRecordPanel.setBackground(new Color(139, 0, 139));
		newRecordPanel.setBounds(358, 9, 115, 38);
		contactDetailsHeaderpanel.add(newRecordPanel);
		//Design add new customer record button
		newCustomerRecordButton = new JButton("New",addUserIcon);
		newCustomerRecordButton.setBorder(null);
		newCustomerRecordButton.setBounds(0, 0, 115, 38);
		newRecordPanel.add(newCustomerRecordButton);
		newCustomerRecordButton.setForeground(Color.WHITE);
		newCustomerRecordButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		newCustomerRecordButton.setContentAreaFilled(false);
		//Design name text for customer
		nameText = new JTextField();
		nameText.setBounds(24, 136, 437, 37);
		cusInfo_panel.add(nameText);
		nameText.setColumns(10);
		//Design header text for name 
		nameHeaderText = new JTextField();
		nameHeaderText.setForeground(Color.GRAY);
		nameHeaderText.setOpaque(false);
		nameHeaderText.setEditable(false);
		nameHeaderText.setBorder(null);
		nameHeaderText.setText("Name");
		nameHeaderText.setBounds(24, 101, 79, 22);
		cusInfo_panel.add(nameHeaderText);
		nameHeaderText.setColumns(10);
		//Design header text for phone number
		phoneNumberHeaderText = new JTextField();
		phoneNumberHeaderText.setText("PHONE NUMBER");
		phoneNumberHeaderText.setOpaque(false);
		phoneNumberHeaderText.setForeground(Color.GRAY);
		phoneNumberHeaderText.setEditable(false);
		phoneNumberHeaderText.setColumns(10);
		phoneNumberHeaderText.setBorder(null);
		phoneNumberHeaderText.setBounds(73, 186, 103, 22);
		cusInfo_panel.add(phoneNumberHeaderText);
		//Design label for phone image
		labelForPhoneIcon = new JLabel("");
		labelForPhoneIcon.setBounds(24, 181, 42, 37);
		labelForPhoneIcon.setIcon(phoneIcon);
		cusInfo_panel.add(labelForPhoneIcon);
		//Design text field for phone number 
		phoneNumberText = new JTextField();
		phoneNumberText.setColumns(10);
		phoneNumberText.setBounds(24, 221, 437, 37);
		cusInfo_panel.add(phoneNumberText);
		//Design label for ordering imaeg
		labelForOrderingIcon = new JLabel("");
		labelForOrderingIcon.setBounds(24, 271, 42, 37);
		labelForOrderingIcon.setIcon(orderingIcon);
		cusInfo_panel.add(labelForOrderingIcon);
		//Design header text for type of ordering 
		typeOfOrderingHeaderText = new JTextField();
		typeOfOrderingHeaderText.setText("TYPE OF ORDERING");
		typeOfOrderingHeaderText.setOpaque(false);
		typeOfOrderingHeaderText.setForeground(Color.GRAY);
		typeOfOrderingHeaderText.setEditable(false);
		typeOfOrderingHeaderText.setColumns(10);
		typeOfOrderingHeaderText.setBorder(null);
		typeOfOrderingHeaderText.setBounds(73, 271, 121, 31);
		cusInfo_panel.add(typeOfOrderingHeaderText);
		//Design check box for delivery order
		chckbxDeliveryOrder = new JCheckBox("Delivery Order", false);
		chckbxDeliveryOrder.setOpaque(false);
		chckbxDeliveryOrder.setBounds(63, 305, 113, 25);
		cusInfo_panel.add(chckbxDeliveryOrder);
		//Design check box for self-collected order
		chckbxSelfcollected = new JCheckBox("Self-Collected", false);
		chckbxSelfcollected.setOpaque(false);
		chckbxSelfcollected.setBounds(218, 305, 113, 25);
		cusInfo_panel.add(chckbxSelfcollected);
		//Group the check box 
		aGroup.add(chckbxDeliveryOrder);
		aGroup.add(chckbxSelfcollected);
		//Design the panel for address information
		panelBorderForAddress = new JPanel();
		panelBorderForAddress.setEnabled(false);
		panelBorderForAddress.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelBorderForAddress.setBackground(new Color(0, 0, 0));
		panelBorderForAddress.setOpaque(false);
		panelBorderForAddress.setBounds(24, 339, 437, 254);
		cusInfo_panel.add(panelBorderForAddress);
		panelBorderForAddress.setLayout(null);
		//Design the label for address image
		labelForAddressIcon = new JLabel("");
		labelForAddressIcon.setBounds(12, 13, 42, 37);
		labelForAddressIcon.setIcon(addressIcon);
		panelBorderForAddress.add(labelForAddressIcon);
		//Design the header for addres 
		addressHeaderText = new JTextField();
		addressHeaderText.setText("ADDRESS");
		addressHeaderText.setOpaque(false);
		addressHeaderText.setForeground(Color.GRAY);
		addressHeaderText.setEditable(false);
		addressHeaderText.setColumns(10);
		addressHeaderText.setBorder(null);
		addressHeaderText.setBounds(66, 19, 65, 31);
		panelBorderForAddress.add(addressHeaderText);
		//Design the header for housing number
		housingNumberHeaderText = new JTextField();
		housingNumberHeaderText.setText("Housing Number");
		housingNumberHeaderText.setOpaque(false);
		housingNumberHeaderText.setForeground(Color.GRAY);
		housingNumberHeaderText.setEditable(false);
		housingNumberHeaderText.setColumns(10);
		housingNumberHeaderText.setBorder(null);
		housingNumberHeaderText.setBounds(12, 70, 110, 22);
		panelBorderForAddress.add(housingNumberHeaderText);
		//Design the header for street number
		streetNumberHeaderText = new JTextField();
		streetNumberHeaderText.setText("Street Number");
		streetNumberHeaderText.setOpaque(false);
		streetNumberHeaderText.setForeground(Color.GRAY);
		streetNumberHeaderText.setEditable(false);
		streetNumberHeaderText.setColumns(10);
		streetNumberHeaderText.setBorder(null);
		streetNumberHeaderText.setBounds(163, 70, 110, 22);
		panelBorderForAddress.add(streetNumberHeaderText);
		//Design the housing number text field
		HousingNumberText = new JTextField();
		HousingNumberText.setEditable(false);
		HousingNumberText.setColumns(10);
		HousingNumberText.setBounds(12, 92, 136, 22);
		panelBorderForAddress.add(HousingNumberText);
		//Design the street number text field
		StreetNumberText = new JTextField();
		StreetNumberText.setEditable(false);
		StreetNumberText.setColumns(10);
		StreetNumberText.setBounds(163, 92, 136, 22);
		panelBorderForAddress.add(StreetNumberText);
		//Design header for street number 
		streetNameHeaderText = new JTextField();
		streetNameHeaderText.setText("Street Name");
		streetNameHeaderText.setOpaque(false);
		streetNameHeaderText.setForeground(Color.GRAY);
		streetNameHeaderText.setEditable(false);
		streetNameHeaderText.setColumns(10);
		streetNameHeaderText.setBorder(null);
		streetNameHeaderText.setBounds(12, 118, 110, 22);
		panelBorderForAddress.add(streetNameHeaderText);
		//Design the street name text field
		streetNameText = new JTextField();
		streetNameText.setEditable(false);
		streetNameText.setColumns(10);
		streetNameText.setBounds(12, 141, 413, 31);
		panelBorderForAddress.add(streetNameText);
		//Design header for postcode
		postcodeHeaderText = new JTextField();
		postcodeHeaderText.setText("Postcode");
		postcodeHeaderText.setOpaque(false);
		postcodeHeaderText.setForeground(Color.GRAY);
		postcodeHeaderText.setEditable(false);
		postcodeHeaderText.setColumns(10);
		postcodeHeaderText.setBorder(null);
		postcodeHeaderText.setBounds(315, 70, 83, 22);
		panelBorderForAddress.add(postcodeHeaderText);
		//Design header for Penang text
		penangText = new JTextField();
		penangText.setEditable(false);
		penangText.setText("State: Penang");
		penangText.setOpaque(false);
		penangText.setForeground(Color.GRAY);
		penangText.setColumns(10);
		penangText.setBorder(null);
		penangText.setBounds(12, 218, 98, 22);
		panelBorderForAddress.add(penangText);
		//Design header for Malaysia text
		malaysiaText = new JTextField();
		malaysiaText.setText("Country: Malaysia");
		malaysiaText.setOpaque(false);
		malaysiaText.setForeground(Color.GRAY);
		malaysiaText.setEditable(false);
		malaysiaText.setColumns(10);
		malaysiaText.setBorder(null);
		malaysiaText.setBounds(232, 218, 110, 22);
		panelBorderForAddress.add(malaysiaText);
		//Design postcode choice bar
		postcodeChoice = new Choice();
		postcodeChoice.setEnabled(false);
		postcodeChoice.setBounds(313, 92, 85, 22);
		panelBorderForAddress.add(postcodeChoice);
		postcodeChoice.addMouseListener(this);
		//Design header for area
		areaHeaderText = new JTextField();
		areaHeaderText.setText("Area");
		areaHeaderText.setOpaque(false);
		areaHeaderText.setForeground(Color.GRAY);
		areaHeaderText.setEditable(false);
		areaHeaderText.setColumns(10);
		areaHeaderText.setBorder(null);
		areaHeaderText.setBounds(12, 185, 35, 22);
		panelBorderForAddress.add(areaHeaderText);
		//Design area text field 
		areaText = new JTextField();
		areaText.setEditable(false);
		areaText.setColumns(10);
		areaText.setBounds(50, 185, 136, 22);
		panelBorderForAddress.add(areaText);
		//Design hour choice bar 
		hour_choice = new Choice();
		hour_choice.setBounds(98, 662, 56, 22);
		hour_choice.setEnabled(false);
		cusInfo_panel.add(hour_choice);
		//Design header for time and date
		timeANDdateHeaderText = new JTextField();
		timeANDdateHeaderText.setText("DELIVERY TIME");
		timeANDdateHeaderText.setOpaque(false);
		timeANDdateHeaderText.setForeground(Color.GRAY);
		timeANDdateHeaderText.setEditable(false);
		timeANDdateHeaderText.setColumns(10);
		timeANDdateHeaderText.setBorder(null);
		timeANDdateHeaderText.setBounds(34, 606, 79, 31);
		cusInfo_panel.add(timeANDdateHeaderText);
		//Design delivery time check box
		chckbxDeliveryTime = new JCheckBox("Set Delivery Time");
		chckbxDeliveryTime.setOpaque(false);
		chckbxDeliveryTime.setBounds(115, 609, 134, 25);
		cusInfo_panel.add(chckbxDeliveryTime);
		//Design minutes choice bar  
		minutes_choice = new Choice();
		minutes_choice.setBounds(208, 662, 59, 22);
		minutes_choice.setEnabled(false);
		cusInfo_panel.add(minutes_choice);
		//Design meridian choice bar
		ampm_choice = new Choice();
		ampm_choice.setBounds(336, 662, 65, 22);
		ampm_choice.add("AM");
		ampm_choice.add("PM");
		ampm_choice.setEnabled(false);
		cusInfo_panel.add(ampm_choice);
		//Design header for hour
		hourText = new JTextField();
		hourText.setText("HOUR");
		hourText.setOpaque(false);
		hourText.setForeground(Color.BLACK);
		hourText.setEditable(false);
		hourText.setColumns(10);
		hourText.setBorder(null);
		hourText.setBounds(160, 662, 42, 31);
		cusInfo_panel.add(hourText);
		//Design header for minutes
		minutesText = new JTextField();
		minutesText.setText("MINUTES");
		minutesText.setOpaque(false);
		minutesText.setForeground(Color.BLACK);
		minutesText.setEditable(false);
		minutesText.setColumns(10);
		minutesText.setBorder(null);
		minutesText.setBounds(277, 662, 54, 31);
		cusInfo_panel.add(minutesText);
		//Design label for clock image
		labelForClock = new JLabel("");
		labelForClock.setIcon(null);
		labelForClock.setBounds(24, 650, 56, 53);
		labelForClock.setIcon(clockIcon);
		cusInfo_panel.add(labelForClock);
		//Design header for identity number
		idHeaderText = new JTextField();
		idHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		idHeaderText.setText("ID");
		idHeaderText.setOpaque(false);
		idHeaderText.setForeground(Color.GRAY);
		idHeaderText.setEditable(false);
		idHeaderText.setColumns(10);
		idHeaderText.setBorder(null);
		idHeaderText.setBounds(24, 66, 42, 22);
		cusInfo_panel.add(idHeaderText);
		//Design customer identity number choice
		choiceCustomerID = new Choice();
		choiceCustomerID.setBounds(76, 66, 385, 22);
		cusInfo_panel.add(choiceCustomerID);
		//Design order information panel
		orderInfo_panel = new JPanel();
		orderInfo_panel.setBorder(new LineBorder(new Color(144, 238, 144), 1, true));
		orderInfo_panel.setBackground(new Color(255, 255, 255));
		orderInfo_panel.setBounds(509, 13, 558, 609);
		contentPane.add(orderInfo_panel);
		orderInfo_panel.setLayout(null);
		//Design quantity text field 
		txtQuantity = new JTextField();
		txtQuantity.setForeground(Color.WHITE);
		txtQuantity.setBackground(new Color(0, 204, 51));
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtQuantity.setBorder(null);
		txtQuantity.setEditable(false);
		txtQuantity.setText("Quantity");
		txtQuantity.setBounds(139, 0, 139, 34);
		orderInfo_panel.add(txtQuantity);
		txtQuantity.setColumns(10);
		//Design price text field
		txtPrice = new JTextField();
		txtPrice.setForeground(Color.WHITE);
		txtPrice.setBackground(new Color(0, 204, 51));
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPrice.setBorder(null);
		txtPrice.setEditable(false);
		txtPrice.setText("Price");
		txtPrice.setColumns(10);
		txtPrice.setBounds(270, 0, 150, 34);
		orderInfo_panel.add(txtPrice);
		//Design total price text field
		txtTotalPrice = new JTextField();
		txtTotalPrice.setForeground(Color.WHITE);
		txtTotalPrice.setBackground(new Color(0, 204, 51));
		txtTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTotalPrice.setBorder(new LineBorder(new Color(0, 204, 51), 1, true));
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setText("Total Price (RM)");
		txtTotalPrice.setColumns(10);
		txtTotalPrice.setBounds(417, 0, 139, 34);
		orderInfo_panel.add(txtTotalPrice);
		//Design food name text field 
		txtFoodName = new JTextField();
		txtFoodName.setBackground(new Color(0, 204, 51));
		txtFoodName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFoodName.setForeground(Color.WHITE);
		txtFoodName.setText("Item");
		txtFoodName.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtFoodName.setEditable(false);
		txtFoodName.setColumns(10);
		txtFoodName.setBorder(new LineBorder(new Color(0, 204, 51), 1, true));
		txtFoodName.setBounds(0, 0, 139, 34);
		orderInfo_panel.add(txtFoodName);
		//Design table for order list
		orderTable = new JTable();
		orderTable.setBackground(Color.WHITE);
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"", "", "", ""}
		));
		
		orderTable.setBounds(193, 300, 512, 334);
		orderInfo_panel.add(orderTable);
		//Design scroll pane for table 
		orderTablescrollPane = new JScrollPane(orderTable);
		orderTablescrollPane.setBorder(new LineBorder(new Color(144, 238, 144), 1, true));
		orderTablescrollPane.setBackground(Color.WHITE);
		orderTablescrollPane.setBounds(0, 35, 558, 225);
		orderInfo_panel.add(orderTablescrollPane);
		//Design edit panel
		edit_panel = new JPanel();
		edit_panel.setBorder(new LineBorder(Color.GREEN, 2, true));
		edit_panel.setOpaque(false);
		edit_panel.setBounds(12, 309, 534, 286);
		orderInfo_panel.add(edit_panel);
		edit_panel.setLayout(null);
		//Design text for quantity edition
		editQuantityText = new JTextField();
		editQuantityText.setHorizontalAlignment(SwingConstants.CENTER);
		editQuantityText.setFont(new Font("Tahoma", Font.BOLD, 28));
		editQuantityText.setBounds(225, 154, 79, 58);
		edit_panel.add(editQuantityText);
		editQuantityText.setText("0");
		editQuantityText.setOpaque(false);
		editQuantityText.setForeground(Color.GRAY);
		editQuantityText.setEditable(false);
		editQuantityText.setColumns(10);
		editQuantityText.setBorder(null);
		//Design text for edited food name
		editFoodNameText = new JTextField();
		editFoodNameText.setOpaque(false);
		editFoodNameText.setHorizontalAlignment(SwingConstants.CENTER);
		editFoodNameText.setForeground(Color.GRAY);
		editFoodNameText.setFont(new Font("Tahoma", Font.BOLD, 28));
		editFoodNameText.setEditable(false);
		editFoodNameText.setColumns(10);
		editFoodNameText.setBorder(null);
		editFoodNameText.setBounds(12, 13, 510, 58);
		edit_panel.add(editFoodNameText);
		//Design panel for add button
		addButtonPanel = new JPanel();
		addButtonPanel.setLayout(null);
		addButtonPanel.setBackground(new Color(0, 204, 51));
		addButtonPanel.setBounds(35, 167, 105, 38);
		edit_panel.add(addButtonPanel);
		//Design add button for edition
		addButton = new JButton("+");
		addButton.setEnabled(false);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addButton.setContentAreaFilled(false);
		addButton.setBounds(0, 0, 105, 38);
		addButtonPanel.add(addButton);
		//Design panel for delete button
		deletePanel = new JPanel();
		deletePanel.setLayout(null);
		deletePanel.setBackground(new Color(0, 204, 51));
		deletePanel.setBounds(377, 167, 105, 38);
		edit_panel.add(deletePanel);
		//Design delete button for edition
		deleteButton = new JButton("-");
		deleteButton.setEnabled(false);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteButton.setContentAreaFilled(false);
		deleteButton.setBounds(0, 0, 105, 38);
		deletePanel.add(deleteButton);
		//Design panel for change button edition
		changeButtonPanel = new JPanel();
		changeButtonPanel.setLayout(null);
		changeButtonPanel.setBackground(new Color(0, 204, 51));
		changeButtonPanel.setBounds(12, 235, 510, 38);
		edit_panel.add(changeButtonPanel);
		//Design change button for edition
		changeButton = new JButton("Change");
		changeButton.setEnabled(false);
		changeButton.setForeground(Color.WHITE);
		changeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		changeButton.setContentAreaFilled(false);
		changeButton.setBounds(0, 0, 510, 38);
		changeButtonPanel.add(changeButton);
		//Design text for price for price edition
		editPriceText = new JTextField();
		editPriceText.setOpaque(false);
		editPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		editPriceText.setForeground(Color.GRAY);
		editPriceText.setFont(new Font("Tahoma", Font.BOLD, 28));
		editPriceText.setEditable(false);
		editPriceText.setColumns(10);
		editPriceText.setBorder(null);
		editPriceText.setBounds(35, 84, 122, 71);
		edit_panel.add(editPriceText);
		//Design total price for edition
		editTotalPriceText = new JTextField();
		editTotalPriceText.setOpaque(false);
		editTotalPriceText.setHorizontalAlignment(SwingConstants.LEFT);
		editTotalPriceText.setForeground(Color.GRAY);
		editTotalPriceText.setFont(new Font("Tahoma", Font.BOLD, 28));
		editTotalPriceText.setEditable(false);
		editTotalPriceText.setColumns(10);
		editTotalPriceText.setBorder(null);
		editTotalPriceText.setBounds(360, 83, 145, 71);
		edit_panel.add(editTotalPriceText);
		//Design panel for done button
		doneButtonPanel = new JPanel();
		doneButtonPanel.setBackground(new Color(51, 204, 0));
		doneButtonPanel.setBounds(962, 870, 105, 38);
		contentPane.add(doneButtonPanel);
		doneButtonPanel.setLayout(null);
		//Design done button for edition
		doneButton = new JButton("Done");
		doneButton.setBounds(0, 0, 105, 38);
		doneButtonPanel.add(doneButton);
		doneButton.setForeground(new Color(255, 255, 255));
		doneButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		doneButton.setContentAreaFilled(false);
		//Design header for delivery charge
		deliveryChargeHeaderText = new JTextField();
		deliveryChargeHeaderText.setText("Delivery Charge");
		deliveryChargeHeaderText.setBounds(812, 640, 255, 38);
		contentPane.add(deliveryChargeHeaderText);
		deliveryChargeHeaderText.setOpaque(false);
		deliveryChargeHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryChargeHeaderText.setForeground(new Color(60, 179, 113));
		deliveryChargeHeaderText.setFont(new Font("Tahoma", Font.BOLD, 28));
		deliveryChargeHeaderText.setEditable(false);
		deliveryChargeHeaderText.setColumns(10);
		deliveryChargeHeaderText.setBorder(null);
		//Design header for discount
		discountHeaderText = new JTextField();
		discountHeaderText.setText("Discount (10%)");
		discountHeaderText.setOpaque(false);
		discountHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		discountHeaderText.setForeground(new Color(60, 179, 113));
		discountHeaderText.setFont(new Font("Tahoma", Font.BOLD, 28));
		discountHeaderText.setEditable(false);
		discountHeaderText.setColumns(10);
		discountHeaderText.setBorder(null);
		discountHeaderText.setBounds(509, 640, 255, 38);
		contentPane.add(discountHeaderText);
		//Design text for discount amount
		discountAmountText = new JTextField();
		discountAmountText.setOpaque(false);
		discountAmountText.setHorizontalAlignment(SwingConstants.CENTER);
		discountAmountText.setForeground(Color.GRAY);
		discountAmountText.setFont(new Font("Tahoma", Font.BOLD, 28));
		discountAmountText.setEditable(false);
		discountAmountText.setColumns(10);
		discountAmountText.setBorder(null);
		discountAmountText.setBounds(635, 691, 129, 58);
		contentPane.add(discountAmountText);
		//Design text for delivery charge amount
		deliveryChargeAmountText = new JTextField();
		deliveryChargeAmountText.setOpaque(false);
		deliveryChargeAmountText.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryChargeAmountText.setForeground(Color.GRAY);
		deliveryChargeAmountText.setFont(new Font("Tahoma", Font.BOLD, 28));
		deliveryChargeAmountText.setEditable(false);
		deliveryChargeAmountText.setColumns(10);
		deliveryChargeAmountText.setBorder(null);
		deliveryChargeAmountText.setBounds(938, 691, 129, 58);
		contentPane.add(deliveryChargeAmountText);
		//Design header for total order price
		totalOrderPriceHeaderText = new JTextField();
		totalOrderPriceHeaderText.setText("Total Order Price: ");
		totalOrderPriceHeaderText.setOpaque(false);
		totalOrderPriceHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		totalOrderPriceHeaderText.setForeground(new Color(60, 179, 113));
		totalOrderPriceHeaderText.setFont(new Font("Tahoma", Font.BOLD, 23));
		totalOrderPriceHeaderText.setEditable(false);
		totalOrderPriceHeaderText.setColumns(10);
		totalOrderPriceHeaderText.setBorder(null);
		totalOrderPriceHeaderText.setBounds(695, 802, 232, 38);
		contentPane.add(totalOrderPriceHeaderText);
		//Design text for overall price 
		overallPriceText = new JTextField();
		overallPriceText.setOpaque(false);
		overallPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		overallPriceText.setForeground(Color.GRAY);
		overallPriceText.setFont(new Font("Tahoma", Font.BOLD, 28));
		overallPriceText.setEditable(false);
		overallPriceText.setColumns(10);
		overallPriceText.setBorder(null);
		overallPriceText.setBounds(938, 799, 129, 58);
		contentPane.add(overallPriceText);
		
		/*Below are the code which are for performing the task*/
		try 
		{
			displaySelectedFoodtoTable();//Display the order to table
			file.readCustomersFromFile();//add the customer to collection class
			addCustomerIDToChoice();//add customer identity number to choice bar
			addNumberToTimeAndDateChoice();// add time and date to choice bar respectively
			addPostcodeToChoice();// add post code to choice bar
		}catch(Exception error) {
			JOptionPane.showMessageDialog(null,error.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
		}
		
		newCustomerRecordButton.addActionListener(new ActionListener()//if add customer button is added 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				addCustomerIDToArrayChecker();//add the customer identity number to array
				orderdetailsWindows.setVisible(false);//invisible the window
				AddCustomerGUI addCustomerWindow = new AddCustomerGUI();
				addCustomerWindow.setVisible(true);//visible the add customer window
				addCustomerWindow.SetCustomerCheckArray(customerIDchecker, customerIDchecker.length);//pass the details of the customer identity number for checking
			}
		});
	 
		choiceCustomerID.addMouseListener(this);
		orderTable.addMouseListener(this); 
		chckbxDeliveryOrder.addActionListener(this);
		chckbxSelfcollected.addActionListener(this);
		chckbxDeliveryTime.addActionListener(this);
		doneButton.addActionListener(this);
		changeButton.addActionListener(this);
		deleteButton.addActionListener(this);
		addButton.addActionListener(this);
	}
	/*
	 * Function to read and display the selected food from text file and to table
	 */
	public void displaySelectedFoodtoTable()throws FileNotFoundException, IOException
	{
		Scanner read = new Scanner(new FileReader("SelectedFoodFile.txt")); 
		DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
		Object[] foodRow;
		String foodName, quantity, price, totalPrice;
		do
		{
			foodName = read.nextLine();
			quantity = read.nextLine();
			price = read.nextLine();
			totalPrice = read.nextLine();
			foodRow = new Object[] {foodName, quantity, price, totalPrice};
			model.addRow(foodRow);
			
		}while(read.hasNextLine()); 
		read.close();
	}
	/*
	 * Function for calculating delivery order price
	 */
	public void countingTotalDeliveryOrderPrice() 
	{
		TableModel model = orderTable.getModel();//get the table model
		double deliverycharge = 0.0, overallPrice = 0.0 ,totalOrderPrice = 0.0; 
		int totalOrderQuantity = 0;
		//Sum up all the total price for each foods
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			String totalprice = model.getValueAt(i, 3).toString();
			totalOrderPrice = totalOrderPrice + Double.parseDouble(totalprice); 
		}
		//Sum up all the quantities from each foods
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			String totalQuantity = model.getValueAt(i, 1).toString();
			totalOrderQuantity = totalOrderQuantity + Integer.parseInt(totalQuantity);
		}
		
		if(totalOrderQuantity >= 1 && totalOrderQuantity < 5)// if the overall quantity is between 1 and 5 
		{
			deliveryChargeAmountText.setText("10.0");//set the delivery charge text to 10.0	
		}
		else if(totalOrderQuantity >= 5 && totalOrderQuantity < 10)// if the overall quantity is between 5 and 10
		{
			deliveryChargeAmountText.setText("5.0");//set the delivery charge text to 5.0
		}
		else if(totalOrderQuantity >=10)// if the overall quantity is more than 10
		{
			deliveryChargeAmountText.setText("Free");//delivery is free of charge
		}
		
		deliverycharge = convertDeliveryCharge(deliveryChargeAmountText.getText());//convert the delivery charge text to double
		
		overallPrice = totalOrderPrice + deliverycharge;// sum up the total price and delivery charge
		String overallPrice_Text = String.format("%.1f",overallPrice);//convert the overall price to double
		overallPriceText.setText(overallPrice_Text);//set the overall price to text field
	}
	/*
	 * Function for calculating total order price of self-collected order
	 */
	public void countingTotalSelfCollectedOrderPrice() 
	{
		TableModel model = orderTable.getModel();
		double totalOrderPrice = 0.0, discount, overallPrice;
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			String totalprice = model.getValueAt(i, 3).toString();//get the total price of the selected food from table
			totalOrderPrice = totalOrderPrice + Double.parseDouble(totalprice);//convert the total price text to double 
		}
		discount = (totalOrderPrice*0.10);//calculate the discount
		overallPrice = totalOrderPrice - discount;//minus total price will discount amount for overall price
		
		String discountText = String.format("%.1f",discount);//convert discount amount to string
		discountAmountText.setText(discountText);//set the discount text to text field 
		String overallPrice_Text = String.format("%.1f",overallPrice);//convert overall price to string
		overallPriceText.setText(overallPrice_Text);//set the overall price text to text field
	}
	/*
	 * Function for saving delivery order to text file
	 */
	public void savingDeliveryOrdersToTextFile() throws FileNotFoundException, IOException
	{
		String order_postcode = "", order_address = "", order_area = "", date, time,orderID;
		double deliverycharges = 0.0, overallPrice = 0.0;
		String customersId = choiceCustomerID.getSelectedItem();
		int randomIDGenerator = (int) + (Math.random()*9000)+1000;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//set the current date
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");//set the current time
		Date currentDateTime = new Date();
		
		TableModel model = orderTable.getModel();
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			//Read the information from table
			String foodName = model.getValueAt(i, 0).toString();
			int foodQuantity = Integer.parseInt(model.getValueAt(i, 1).toString());
			double prices = Double.parseDouble(model.getValueAt(i, 2).toString());
			double totalprice = Double.parseDouble(model.getValueAt(i, 3).toString());
			//Read the information from text field
			overallPrice = Double.parseDouble(overallPriceText.getText());
			order_postcode = postcodeChoice.getSelectedItem();
			order_address = HousingNumberText.getText() +", "+ streetNameText.getText() +", "+ StreetNumberText.getText();
			order_area = areaText.getText();
			date = dateFormat.format(currentDateTime);//read the current date
			if(chckbxDeliveryTime.isSelected()) //if user set the delivery time
			{
				time = hour_choice.getSelectedItem() +" : "+ minutes_choice.getSelectedItem() +" "+ampm_choice.getSelectedItem();
			}
			else 
			{
				time = timeFormat.format(currentDateTime);//read the current date
			}
			deliverycharges = convertDeliveryCharge(deliveryChargeAmountText.getText());//convert the delivey charge
			orderID = "DEO" + randomIDGenerator;
			if(foodQuantity != 0)//if food quantity is not equal to 0 
			{
				//write the delivery order information to text file
				file.savingDeliveryOrdersToTextFile(customersId,foodName,foodQuantity,prices,totalprice,date,time,deliverycharges,overallPrice,order_address,order_postcode,order_area,orderID);
			}
		}				
	}
	/*
	 * Function to convert the delivery charge text to double
	 * @return double This return the converted delivery charge
	 */
	public double convertDeliveryCharge(String deliveryCharge) 
	{
		double deliverycharge = 0.0;
		
		if(deliveryCharge.equals("Free"))//if the delivery charge is free 
		{
			deliverycharge = 0.0;//set the delivery charge to 0
		}
		else 
		{
			deliverycharge = Double.parseDouble(deliveryCharge);//convert the delivery charge text to double 
		}
		
		return deliverycharge;
	}
	/*
	 * Function to save self-collected order to text file
	 */
	public void savingSelfColletedOrdersToTextFile() throws FileNotFoundException, IOException
	{
		String customersId = choiceCustomerID.getSelectedItem(), time;
		double discount = 0.0, overallPrice = 0.0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//set the current date
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");//set the current time
		Date currentDateTime = new Date();
		TableModel model = orderTable.getModel();
		for(int i = 0; i < model.getRowCount() ; i++) 
		{
			String foodName = model.getValueAt(i, 0).toString();
			//Read the information from table
			int foodQuantity = Integer.parseInt(model.getValueAt(i, 1).toString());
			double prices = Double.parseDouble(model.getValueAt(i, 2).toString());
			double totalprice = Double.parseDouble(model.getValueAt(i, 3).toString());
			//Read the information from text field and choice bar respectively
			discount = Double.parseDouble(discountAmountText.getText());
			overallPrice = Double.parseDouble(overallPriceText.getText());
			String date = dateFormat.format(currentDateTime);
			if(chckbxDeliveryTime.isSelected()) //if user set the delivery time
			{
				time = hour_choice.getSelectedItem() +" : "+ minutes_choice.getSelectedItem() +" "+ampm_choice.getSelectedItem();
			}
			else 
			{
				time = timeFormat.format(currentDateTime);//read the current date
			}
	
			if(foodQuantity != 0)//if food quantity is not equal to 0 
			{
				//write the self-collected information to text file
				file.savingSelfColletedOrdersToTextFile(customersId, foodName,foodQuantity,prices,totalprice,date,time,discount,overallPrice);
			}
		}
	}
	/*
	 * Function to add postcode to choice
	 */
	public void addPostcodeToChoice() 
	{
		//declare array to store postcode
		String[] postcode = {"11500","11000","11010","11020",
							 "11100", "11960","11900","11910",
							 "11920","11950", "11700","11600",
							 "11609","11300","11800","14000",
							 "14007","14009","14020","12000",
							 "12100","12200","12300","12700",
							 "12710","12720","12990","13000",
							 "13009","13020","13050","13400",
							 "13409","13800","13200","13210",
							 "13220","14400","14300","14310",
							 "14320","13100","13110","13600",
							 "13700","13500","14100","14101",
							 "14110","14120","14200","11200",
							 "13300","13310"};
		
		sortThePostcode(postcode);//sort the post code in order
		
		for(int i = 0; i < postcode.length; i++)//add postcode to postcode choice bar 
		{
			postcodeChoice.add(postcode[i]);
		}
	}
	/*
	 * Function to sort the postcode in order
	 */
	public void sortThePostcode(String[] postcode) 
	{
		int i, j;
		String temp;
		for(j = 1; j < postcode.length; j++){
			 temp = postcode[j];
			i = j;

		 	while(i > 0 && postcode[i-1].compareTo(temp) > 0){
		 		postcode[i] = postcode[i-1];
				i--;
			}
		 	postcode[i] = temp;
		}
	}
	/*
	 * Function to add customers' identity number to choice bar using collection class
	 */
	public void addCustomerIDToChoice() 
	{
		for(Customer customer : file.customers.customer) 
		{
			choiceCustomerID.add(customer.getIdentityNumber());
		}
	}
	/*
	 * Function to add customers' identity number to array for checking whether the customer is existed or not
	 */
	public void addCustomerIDToArrayChecker() 
	{
		customerIDchecker = new String[file.customers.customer.size()];
		int i = 0;
		for(Customer customer : file.customers.customer) 
		{
			customerIDchecker[i] = customer.getIdentityNumber();
			i++;
		}
	}
	/*
	 * Function to add time and date to choice bar
	 */
	public void addNumberToTimeAndDateChoice() 
	{
		
		for(int x = 1; x < 13; x++)//add 1 to 13 to hour choice bar  
		{
			hour_choice.add(x + "");
		}
		
		for(int i = 1; i < 60; i++)//add 1 to 59 to minutes choice bar  
		{
			minutes_choice.add(i + "");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		
		if(source == chckbxDeliveryOrder)//if user select delivery order check box
		{
			discountAmountText.setText("");
			//Set all the address text field to true
			HousingNumberText.setEditable(true);
			StreetNumberText.setEditable(true);
			streetNameText.setEditable(true);
			postcodeChoice.setEnabled(true);
			panelBorderForAddress.setBorder(new LineBorder(Color.GREEN,1,true));
			countingTotalDeliveryOrderPrice();//calculating the total price for delivery order
		}
		else if(source == chckbxSelfcollected)//if user select self-collected check box
		{
			deliveryChargeAmountText.setText("");
			//set all the address text file to false
			HousingNumberText.setEditable(false);
			StreetNumberText.setEditable(false);
			streetNameText.setEditable(false);
			postcodeChoice.setEnabled(false);
			panelBorderForAddress.setBorder(new LineBorder(Color.BLACK,1,true));
			countingTotalSelfCollectedOrderPrice();//calculating the total price for self-collected order
		}
		else if(source == chckbxDeliveryTime)//if user click selected check box 
		{
			//set the hour and minutes choice bar to true
			hour_choice.setEnabled(true);
			minutes_choice.setEnabled(true);
			ampm_choice.setEnabled(true);
		}
		else if (source == doneButton)// if user press done button
		{
			try {
			if(choiceCustomerID !=null && !nameText.getText().isEmpty() && !phoneNumberText.getText().isEmpty())// if all customers' details is filled 
			{
				if(chckbxDeliveryOrder.isSelected())//if it is the delivery order 
				{
					//if all the address details is filled
					if(!HousingNumberText.getText().isEmpty() && !StreetNumberText.getText().isEmpty() && !streetNameText.getText().isEmpty() && !areaText.getText().isEmpty()) 
					{
						savingDeliveryOrdersToTextFile();//save the delivery order to text file
						orderdetailsWindows.setVisible(false);//invisible the windows frame 
					}else//display the error message if address details is not fulfilled 
					{JOptionPane.showMessageDialog(null,"Please enter all the address details!","Warning",JOptionPane.WARNING_MESSAGE);}
				}
				else if(chckbxSelfcollected.isSelected())//if it is self-collected order
				{
					savingSelfColletedOrdersToTextFile();//save the order to text file
					orderdetailsWindows.setVisible(false);//invisible the windows frame
				}
				else //display the error message if customers' details is not fulfilled
				{JOptionPane.showMessageDialog(null,"Please enter all the details!","Warning",JOptionPane.WARNING_MESSAGE);}
			}
			else//display the error message if all the details have not completed yet
			{JOptionPane.showMessageDialog(null,"Please enter all the customer's details","Warning",JOptionPane.WARNING_MESSAGE);}
			
			}catch(Exception error) {
				JOptionPane.showMessageDialog(null,error.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			}
		}		
		else if(source == changeButton)//if user press change button
		{
				double price = Double.parseDouble(editPriceText.getText());
				int quantity = Integer.parseInt(editQuantityText.getText());
				double totalPrice = (price*quantity);
				//Read the information from selected table row
				int index  = orderTable.getSelectedRow();
				TableModel model = orderTable.getModel();
				model.setValueAt(quantity, index, 1);
				model.setValueAt(price, index, 2);
				model.setValueAt(totalPrice, index, 3);
				editTotalPriceText.setText(totalPrice + "");//set the edited total price to text field 
				
				if(chckbxSelfcollected.isSelected())// if it is self-collected order
				{
					countingTotalSelfCollectedOrderPrice();//counting the self-collected price
				}
				else if(chckbxDeliveryOrder.isSelected())// it is delivery order
				{
					countingTotalDeliveryOrderPrice();//counting the delivery order price					
				}
		}
		else if(source == deleteButton)//if user press delete button
		{
	    	String quantity_text = editQuantityText.getText();
	    	quantity = Integer.parseInt(quantity_text);
	    	if(quantity > 0)// if quantity is greater than 0
	    	{
	    		quantity--;//decrement by 1
	    		editQuantityText.setText(quantity+"");//set the quantity to text field
	    	}
	    	if(quantity == 0)//if quantity is 0
	    	{
	    		quantity = 0;//set the quantity to 0
	    		editQuantityText.setText(quantity+"");//set the quantity to text field
	    	}
		}
		else if(source == addButton)//if user press add button
		{
	    	changeButton.setEnabled(true);//enabled the change button
	    	quantity++;//increment the quantity by 1
	    	editQuantityText.setText(quantity+"");//set the quantity to tet field
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		Object source = arg0.getSource();
		
		if(source == choiceCustomerID)//if user click on customer id choice bar
		{
			String customer_name, customer_phoneNumber;
			//Search for the name and phone number based on the identity number in collection class
			customer_name = file.customers.getCustomerName(choiceCustomerID.getSelectedItem());
			customer_phoneNumber = file.customers.getCustomerPhoneNumber(choiceCustomerID.getSelectedItem());
			//set the name and the text to text field 
			nameText.setText(customer_name);
			phoneNumberText.setText(customer_phoneNumber);
		}
		
		else if(source == postcodeChoice)//if user click on postcode choice bar
		{
			if(postcodeChoice.getSelectedItem().equals("11500"))//if user select 11500 
			{
				areaText.setText("Ayer Itam");//set area to Ayer Itam
			}
			//if user select 11000 OR 11010 OR 11020
			else if(postcodeChoice.getSelectedItem().equals("11000") || postcodeChoice.getSelectedItem().equals("11010") || postcodeChoice.getSelectedItem().equals("11020")) 
			{
				areaText.setText("Balik Pulau");//set area to Balik Pulau
			}
			else if(postcodeChoice.getSelectedItem().equals("11100"))//if user select 11100
			{
				areaText.setText("Batu Ferringhi");//set area to Batu Ferringhi
			}
			else if(postcodeChoice.getSelectedItem().equals("11960")) 
			{
				areaText.setText("Batu Maung");//set area to Batu Maung
			}
			//if user select 11910 OR 11920 OR 11950
			else if(postcodeChoice.getSelectedItem().equals("11910") || postcodeChoice.getSelectedItem().equals("11920") || postcodeChoice.getSelectedItem().equals("11950")) 
			{
				if(postcodeChoice.getSelectedItem().equals("11950"))//if user select 11950
				{
					deliveryChargeAmountText.setText("Free");// set the delivery charge to free
				}
				areaText.setText("Bayan Lepas");//set area to Bayan Lepas
			}
			else if(postcodeChoice.getSelectedItem().equals("11700"))//if user select 11700
			{
				deliveryChargeAmountText.setText("Free");//set the delivery charge to free
				areaText.setText("Gelugor");//set area to Gelugor
			}
			//if user select 11600 OR 11609
			else if(postcodeChoice.getSelectedItem().equals("11600") || postcodeChoice.getSelectedItem().equals("11609")) 
			{
				areaText.setText("Jelutong");//set area to Jelutong
			}
			else if(postcodeChoice.getSelectedItem().equals("11300"))//if user select 11300
			{
				areaText.setText("Penang Hill");//set area to Penang Hill
			}
			else if(postcodeChoice.getSelectedItem().equals("11800"))//if user select 11800
			{
				deliveryChargeAmountText.setText("Free");//set the delivery charge to free
				areaText.setText("USM Pulau Pinang");//set area to USM Pulau Pinang
			}
			//if user select 14000, 14007, 14009, or 14020
			else if(postcodeChoice.getSelectedItem().equals("14000") || postcodeChoice.getSelectedItem().equals("14007") || postcodeChoice.getSelectedItem().equals("14009") || postcodeChoice.getSelectedItem().equals("14020"))
			{
				areaText.setText("Bukit Mertajam");//set area to Bukit Mertajam
			}
			//if user select 13200, 13210, or 13220
			else if(postcodeChoice.getSelectedItem().equals("13200") || postcodeChoice.getSelectedItem().equals("13210") || postcodeChoice.getSelectedItem().equals("13220"))
			{
				areaText.setText("Kepala Batas");//set area to Kepala Batas
			}
			else if(postcodeChoice.getSelectedItem().equals("14400"))//if user select 14400
			{
				areaText.setText("Kubang Semang");//set area to Kubang Semang 
			}
			//if user select 14300, 14310, or 14320
			else if(postcodeChoice.getSelectedItem().equals("14300") || postcodeChoice.getSelectedItem().equals("14310") || postcodeChoice.getSelectedItem().equals("14320"))
			{
				areaText.setText("Nibong Tebal");//set area to Nibong Tebal
			}
			else if(postcodeChoice.getSelectedItem().equals("13100") || postcodeChoice.getSelectedItem().equals("13110"))//if user select 13100 or 13110
			{
				areaText.setText("Penaga");//set area to Penaga
			}
			else if(postcodeChoice.getSelectedItem().equals("13600") || postcodeChoice.getSelectedItem().equals("13700"))//if user select 13600 or 13700
			{
				areaText.setText("Perai");//set area to Perai
			}
			else if(postcodeChoice.getSelectedItem().equals("13500"))//if user select 13500
			{
				areaText.setText("Permatang Pauh");//set area to Permatang Pauh
			}
			//if user select 14100, 14101, 14110, 14120
			else if(postcodeChoice.getSelectedItem().equals("14100") || postcodeChoice.getSelectedItem().equals("14101") || postcodeChoice.getSelectedItem().equals("14110") || postcodeChoice.getSelectedItem().equals("14120"))
			{
				areaText.setText("Simpang Ampat");//set area to Simpang Ampat
			}
			else if(postcodeChoice.getSelectedItem().equals("13310"))//if user select 13310
			{
				areaText.setText("Tasek Gelugor");//set area to Tasek Gelugor
			}
			else if(postcodeChoice.getSelectedItem().equals("11900"))//if user select 11900
			{
           		//Decision making for Batu Maung or Bayan Lepas
       			Object[] decisions = {"Batu Maung", "Bayan Lepas"};
				int choice = JOptionPane.showOptionDialog(null,"Please choose an area ", "The postcode belong to both areas", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,decisions,decisions[0]);
				
				if (choice == JOptionPane.YES_OPTION)// if user select Batu Maung 
				{
					areaText.setText("Batu Maung");//set area to Ayer Itam
				}
				else 
				{
					areaText.setText("Bayan Lepas");//set area to Ayer Itam
				}
				deliveryChargeAmountText.setText("Free");//set the delivery charge to free
			}
			else if(postcodeChoice.getSelectedItem().equals("11200"))//if user select 11900
			{
           		//Decision making for Batu Maung or Bayan Lepas
       			Object[] decisions = {"Tanjong Bungah", "Tanjung Bungah"};
				int choice = JOptionPane.showOptionDialog(null,"Please choose an area ", "The postcode belong to both areas", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,decisions,decisions[0]);
				
				if (choice == JOptionPane.YES_OPTION)// if user select Batu Maung 
				{
					areaText.setText("Tanjong Bungah");//set area to Ayer Itam
				}
				else 
				{
					areaText.setText("Tanjung Bungah");//set area to Ayer Itam
				}
			}
			else if(postcodeChoice.getSelectedItem().equals("14200"))//if user select 11900
			{
           		//Decision making for Batu Maung or Bayan Lepas
       			Object[] decisions = {"Simpang Ampat", "Sungai Jawi"};
				int choice = JOptionPane.showOptionDialog(null,"Please choose an area ", "The postcode belong to both areas", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,decisions,decisions[0]);
				
				if (choice == JOptionPane.YES_OPTION)// if user select Batu Maung 
				{
					areaText.setText("Simpang Ampat");//set area to Ayer Itam
				}
				else 
				{
					areaText.setText("Sungai Jawi");//set area to Ayer Itam
				}
			}
			else if(postcodeChoice.getSelectedItem().equals("13300"))//if user select 11900
			{
           		//Decision making for Batu Maung or Bayan Lepas
       			Object[] decisions = {"Tasek Gelugor", "Tasek Gelugur"};
				int choice = JOptionPane.showOptionDialog(null,"Please choose an area ", "The postcode belong to both areas", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
				null,decisions,decisions[0]);
				
				if (choice == JOptionPane.YES_OPTION)// if user select Batu Maung 
				{
					areaText.setText("Tasek Gelugor");//set area to Ayer Itam
				}
				else 
				{
					areaText.setText("Tasek Gelugur");//set area to Ayer Itam
				}
			}
		}		
		else if(source == orderTable)//if user click on table
		{
			//Read the details from table
			int index = orderTable.getSelectedRow();
			TableModel model = orderTable.getModel();
			String foodName = model.getValueAt(index, 0).toString();
			String quantityText = model.getValueAt(index, 1).toString();
			String price = model.getValueAt(index, 2).toString();
			String totalprice = model.getValueAt(index, 3).toString();
			//Set the details to the respective text field
			editQuantityText.setText(quantityText);
			editFoodNameText.setText(foodName);
			editPriceText.setText(price);
			editTotalPriceText.setText(totalprice);
			//Enable the add, delete, and change
			addButton.setEnabled(true);
			deleteButton.setEnabled(true);
			changeButton.setEnabled(true);
		}
	}
}
