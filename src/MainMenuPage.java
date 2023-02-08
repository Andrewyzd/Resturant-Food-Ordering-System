import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class MainMenuPage extends JFrame {

	private JPanel contentPane;
	private JTextField welcomeText;
	private JButton foodMenuButton, ridersButton, customersButton, updateButton,viewReturnedOrderButton,viewDeliveredOrderButton;
	private JLabel Label_MainMenuImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainMenuPage mainMenuWindow = new MainMenuPage();
					mainMenuWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Constructor to display window frame and components
	 */
	public MainMenuPage() {
		//Design the windows frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 542);
		setTitle("Main Menu");
		//Design the panel for windows frame
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design the image for background
		ImageIcon mainMenuIcon = new ImageIcon("ImageIcon\\MainMenu.jpg"); // load the image to a imageIcon
		Image mainMenuImage = mainMenuIcon.getImage();// transform it 
		Image newimg_mainMenu = mainMenuImage.getScaledInstance(784, 542,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		mainMenuIcon = new ImageIcon(newimg_mainMenu);  // transform it back
		//Design the label for background image
		Label_MainMenuImage = new JLabel(mainMenuIcon);
		Label_MainMenuImage.setBounds(0, 0, 784, 542);
		contentPane.add(Label_MainMenuImage);
		//Design the header for welcome text
		welcomeText = new JTextField();
		welcomeText.setOpaque(false);
		welcomeText.setBackground(SystemColor.windowBorder);
		welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		Label_MainMenuImage.add(welcomeText);
		welcomeText.setForeground(Color.WHITE);
		welcomeText.setSelectionColor(Color.WHITE);
		welcomeText.setSelectedTextColor(Color.WHITE);
		welcomeText.setBorder(null);
		welcomeText.setFont(new Font("Lucida Handwriting", Font.BOLD, 40));
		welcomeText.setEditable(false);
		welcomeText.setText("Welcome to the Resturant");
		welcomeText.setBounds(0, 39, 766, 84);
		welcomeText.setColumns(10);
		//Design the button for customer 
		customersButton = new JButton("Customers");
		Label_MainMenuImage.add(customersButton);
		customersButton.setContentAreaFilled(false);
		customersButton.setBackground(SystemColor.windowBorder);
		customersButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		customersButton.setHorizontalTextPosition(SwingConstants.CENTER);
		customersButton.setForeground(Color.WHITE);
		customersButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		customersButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		customersButton.setBounds(0, 153, 151, 56);
		//design the riders button
		ridersButton = new JButton("Riders");
		Label_MainMenuImage.add(ridersButton);
		ridersButton.setForeground(Color.WHITE);
		ridersButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		ridersButton.setContentAreaFilled(false);
		ridersButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		ridersButton.setBounds(0, 222, 151, 56);
		//Design the button for food menu
		foodMenuButton = new JButton("Food Menu");
		Label_MainMenuImage.add(foodMenuButton);
		foodMenuButton.setForeground(Color.WHITE);
		foodMenuButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		foodMenuButton.setContentAreaFilled(false);
		foodMenuButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		foodMenuButton.setBounds(0, 291, 151, 56);
		//Design the update order button
		updateButton = new JButton("Update the Delivery Order");
		Label_MainMenuImage.add(updateButton);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		updateButton.setContentAreaFilled(false);
		updateButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		updateButton.setBounds(0, 360, 273, 56);
		//Design the view Returned Order button
		viewReturnedOrderButton = new JButton("View Returned Order");
		viewReturnedOrderButton.setForeground(Color.WHITE);
		viewReturnedOrderButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		viewReturnedOrderButton.setContentAreaFilled(false);
		viewReturnedOrderButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		viewReturnedOrderButton.setBounds(0, 426, 273, 56);
		Label_MainMenuImage.add(viewReturnedOrderButton);
		
		viewDeliveredOrderButton = new JButton("View Delivered Order");
		viewDeliveredOrderButton.setForeground(Color.WHITE);
		viewDeliveredOrderButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		viewDeliveredOrderButton.setContentAreaFilled(false);
		viewDeliveredOrderButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(240, 240, 240)));
		viewDeliveredOrderButton.setBounds(295, 426, 273, 56);
		Label_MainMenuImage.add(viewDeliveredOrderButton);
		
		//open the window frame for delivered order interface if view returned order button is pressed
		viewDeliveredOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DeliveredOrderGUI deliveredOrder = new DeliveredOrderGUI();
				deliveredOrder.setVisible(true);
			}
		});
		
		//open the window frame for update order interface if update button is pressed
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateOrdersGUI windows = new UpdateOrdersGUI();
				windows.updateOrderFrame.setVisible(true);
			}
		});
		//open the window frame for returned order interface if view returned order button is pressed
		viewReturnedOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ReturnedOrderGUI returnedOrder = new ReturnedOrderGUI();
				returnedOrder.setVisible(true);
			}
		});
		//open the window frame for food menu interface if food menu button is pressed
		foodMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FoodSelectionGUI windows= new FoodSelectionGUI();
				windows.foodMenuFrame.setVisible(true);
			}
		});
		
		//open the window frame for riders interface if riders button is pressed
		ridersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RidersGUI windows = new RidersGUI();
				windows.ridersFrame.setVisible(true);
			}
		});
		//open the window frame for customer interface if customer button is pressed		
		customersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomersGUI windows = new CustomersGUI();
				windows.customersFrame.setVisible(true);
			}
		});
	}
}
