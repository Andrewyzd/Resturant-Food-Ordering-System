import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.InputMismatchException;

public class AddCustomerGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField idHeader, firstNameTextField, lastNameTextField, phoneNoTextField, firstNameHeaderText, lastNameHeader;
	private JTextField phoneNumberHeaderText, firstNameExpHeaderText, lastNameExpHeaderText, phoneNoExpText, txtcustomersIdWill;
	private JButton createButton;
	private JPanel createButtonPanel, customerHeaderPanel;
	private JLabel phoneIcon_label, createNewCustomerText;
	FileHandling file = new FileHandling();
	CustomerInformationValidation validate = new CustomerInformationValidation();
	String[] customerIDcheck;
	/**
	 *  Constructor to display the windows and the component of interface
	 */
	public AddCustomerGUI() {
		//Design for window frame
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 346);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new LineBorder(Color.GREEN, 1, true));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//Set the layout of the displayed image
		ImageIcon userIcon = new ImageIcon("ImageIcon\\addCusIcon_2.png"); // load the image to a imageIcon
		Image userImage = userIcon.getImage();// transform it 
		Image newimg_user= userImage.getScaledInstance(68, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		userIcon = new ImageIcon(newimg_user);
		
		ImageIcon phoneIcon = new ImageIcon("ImageIcon\\phoneIcon.png"); // load the image to a imageIcon
		Image phoneImage = phoneIcon.getImage();// transform it 
		Image newimg_phone= phoneImage.getScaledInstance(42, 37,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		phoneIcon = new ImageIcon(newimg_phone);
		//Design the panel
		customerHeaderPanel = new JPanel();
		customerHeaderPanel.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		customerHeaderPanel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		customerHeaderPanel.setBackground(new Color(0, 204, 51));
		customerHeaderPanel.setBounds(0, 0, 483, 63);
		contentPane.add(customerHeaderPanel);
		customerHeaderPanel.setLayout(null);
		//Design the panel
		createNewCustomerText = new JLabel("Create New Customer");
		createNewCustomerText.setFont(new Font("Tahoma", Font.BOLD, 20));
		createNewCustomerText.setForeground(Color.WHITE);
		createNewCustomerText.setBounds(12, 0, 387, 63);
		createNewCustomerText.setIcon(userIcon);
		customerHeaderPanel.add(createNewCustomerText);
		//Design the ID textfield
		idHeader = new JTextField();
		idHeader.setHorizontalAlignment(SwingConstants.CENTER);
		idHeader.setFont(new Font("Tahoma", Font.PLAIN, 19));
		idHeader.setText("ID");
		idHeader.setOpaque(false);
		idHeader.setForeground(Color.BLACK);
		idHeader.setEditable(false);
		idHeader.setColumns(10);
		idHeader.setBorder(null);
		idHeader.setBounds(26, 219, 30, 29);
		contentPane.add(idHeader);
		//Design first name textField
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(24, 100, 203, 31);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		//Design last name textField
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(258, 100, 203, 31);
		contentPane.add(lastNameTextField);
		//Design phone number textField
		phoneNoTextField = new JTextField();
		phoneNoTextField.setColumns(10);
		phoneNoTextField.setBounds(24, 180, 437, 31);
		contentPane.add(phoneNoTextField);
		//Design first name header
		firstNameHeaderText = new JTextField();
		firstNameHeaderText.setForeground(Color.BLACK);
		firstNameHeaderText.setOpaque(false);
		firstNameHeaderText.setEditable(false);
		firstNameHeaderText.setBorder(null);
		firstNameHeaderText.setText("FIRST NAME");
		firstNameHeaderText.setBounds(24, 76, 79, 22);
		contentPane.add(firstNameHeaderText);
		firstNameHeaderText.setColumns(10);
		//Design last name header
		lastNameHeader = new JTextField();
		lastNameHeader.setText("LAST NAME");
		lastNameHeader.setOpaque(false);
		lastNameHeader.setForeground(Color.BLACK);
		lastNameHeader.setEditable(false);
		lastNameHeader.setColumns(10);
		lastNameHeader.setBorder(null);
		lastNameHeader.setBounds(258, 76, 73, 22);
		contentPane.add(lastNameHeader);
		//Label the phone icon
		phoneIcon_label = new JLabel("");
		phoneIcon_label.setBounds(12, 138, 42, 37);
		phoneIcon_label.setIcon(phoneIcon);
		contentPane.add(phoneIcon_label);
		//Design phone number header
		phoneNumberHeaderText = new JTextField();
		phoneNumberHeaderText.setText("PHONE NUMBER");
		phoneNumberHeaderText.setOpaque(false);
		phoneNumberHeaderText.setForeground(Color.BLACK);
		phoneNumberHeaderText.setEditable(false);
		phoneNumberHeaderText.setColumns(10);
		phoneNumberHeaderText.setBorder(null);
		phoneNumberHeaderText.setBounds(61, 150, 103, 22);
		contentPane.add(phoneNumberHeaderText);
		//Design panel for button
		createButtonPanel = new JPanel();
		createButtonPanel.setBackground(new Color(0, 204, 51));
		createButtonPanel.setBounds(353, 259, 108, 31);
		contentPane.add(createButtonPanel);
		createButtonPanel.setLayout(null);
		//Design button create
		createButton = new JButton("Create");
		createButton.setBounds(0, 0, 108, 31);
		createButtonPanel.add(createButton);
		createButton.setForeground(new Color(255, 255, 255));
		createButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		createButton.setContentAreaFilled(false);
		//Design first name header
		firstNameExpHeaderText = new JTextField();
		firstNameExpHeaderText.setText("*Exp: Andrew");
		firstNameExpHeaderText.setOpaque(false);
		firstNameExpHeaderText.setForeground(Color.GRAY);
		firstNameExpHeaderText.setEditable(false);
		firstNameExpHeaderText.setColumns(10);
		firstNameExpHeaderText.setBorder(null);
		firstNameExpHeaderText.setBounds(100, 76, 91, 22);
		contentPane.add(firstNameExpHeaderText);
		//Design last name header
		lastNameExpHeaderText = new JTextField();
		lastNameExpHeaderText.setText("*Exp: Yong Zheng Dao");
		lastNameExpHeaderText.setOpaque(false);
		lastNameExpHeaderText.setForeground(Color.GRAY);
		lastNameExpHeaderText.setEditable(false);
		lastNameExpHeaderText.setColumns(10);
		lastNameExpHeaderText.setBorder(null);
		lastNameExpHeaderText.setBounds(332, 76, 129, 22);
		contentPane.add(lastNameExpHeaderText);
		//Design phone number text instruction
		phoneNoExpText = new JTextField();
		phoneNoExpText.setText("*Exp: 0123456789");
		phoneNoExpText.setOpaque(false);
		phoneNoExpText.setForeground(Color.GRAY);
		phoneNoExpText.setEditable(false);
		phoneNoExpText.setColumns(10);
		phoneNoExpText.setBorder(null);
		phoneNoExpText.setBounds(159, 150, 117, 22);
		contentPane.add(phoneNoExpText);
		//Design customer text instruction
		txtcustomersIdWill = new JTextField();
		txtcustomersIdWill.setText("* Phone number will be auto generated as customer's ID ");
		txtcustomersIdWill.setOpaque(false);
		txtcustomersIdWill.setForeground(Color.GRAY);
		txtcustomersIdWill.setEditable(false);
		txtcustomersIdWill.setColumns(10);
		txtcustomersIdWill.setBorder(null);
		txtcustomersIdWill.setBounds(58, 224, 332, 22);
		contentPane.add(txtcustomersIdWill);
		
		createButton.addActionListener(this);
	    
	}
	/*
	 * Function to set the content of the array to check customer identity number
	 * @param customerIDchecker[] This is the array of the that contains customer's identity number
	 * @param customerSize This is the total of the existing customer
	 */
	public void SetCustomerCheckArray(String customerIDchecker[], int customerSize) 
	{
		this.customerIDcheck = new String[customerSize];
		for(int i = 0; i < customerSize;i++) 
		{
			this.customerIDcheck[i]= customerIDchecker[i];
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		try {
			//if all the input textfield is empty
			if(firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || phoneNoTextField.getText().isEmpty()) 
			{
				//Print the error message
				JOptionPane.showMessageDialog(null,"Please enter all the details!","Warning",JOptionPane.WARNING_MESSAGE);
			}else 
			{
				String name = firstNameTextField.getText() + lastNameTextField.getText();//assign name to variable
				String phoneNumber = phoneNoTextField.getText();//assign phone number to variable
				validate.checkInputNameValidation(name);//check the name input
				validate.checkInputContactNumberValidation(phoneNumber);//check the contact number input
				boolean exist = validate.checkExistingCustomer(phoneNoTextField.getText(), this.customerIDcheck);
				
				if(exist) 
				{
					setVisible(false);//set the windows visible to false
					CustomerAndOrderDetailsGUI cusAndOrder = new  CustomerAndOrderDetailsGUI();//initialize customer and order details windows
					cusAndOrder.orderdetailsWindows.setVisible(true);//set the windows visible to true
					//display error message
					JOptionPane.showMessageDialog(null,"The customer identity number has existed already","Warning!!!!",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					String Newname = firstNameTextField.getText() + " " + lastNameTextField.getText();//set the name with space between first and last name
					file.addCustomerToTextFile(Newname,phoneNoTextField.getText(),phoneNoTextField.getText());//add the customer's information to textfile
					setVisible(false);//set the windows visible to false
					CustomerAndOrderDetailsGUI cusAndOrder = new  CustomerAndOrderDetailsGUI();//initialize customer and order details windows
					cusAndOrder.orderdetailsWindows.setVisible(true);//set the windows visible to true
					//display successful message
					JOptionPane.showMessageDialog(null,"A new customer is created successfully","Successfully",JOptionPane.PLAIN_MESSAGE);
				}
			}
			}catch(Exception error) {
				JOptionPane.showMessageDialog(null,error.getMessage(),"Warning",JOptionPane.WARNING_MESSAGE);
			}
	}
}
