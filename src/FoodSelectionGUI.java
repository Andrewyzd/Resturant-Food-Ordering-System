import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.CompoundBorder;

public class FoodSelectionGUI extends MouseAdapter implements ActionListener{

	public  JFrame foodMenuFrame;
	private JLabel Label_BackgroundImage;
	private JTable tableFoodList;
	private JScrollPane scrollPaneFoodTable;
	private JTextField selectedFoodNameTEXT, selectedFoodPriceTEXT,foodMenuListHeaderText, instructionclickOnTable,quantityText;
	private JPanel deleteButtonPanel, addButtonpanel, foodListPanel, addANDdropPanel, addToOrderButtonPanel,contentPane;
	private JButton addButton , deleteButton, addToOrderButton, viewDetailsButton;
	private int quantity = 0;
	private int placeOrderQuantity = 0;
	FileHandling file = new FileHandling();
	ConcoleTableLine border = new ConcoleTableLine();
	/**
	 * Constructor to display window frame and components
	 */
	public FoodSelectionGUI() {
		//Design the food menu background image to be displayed
		ImageIcon backgroundIcon = new ImageIcon("ImageIcon\\foodMenuBackground.jpg"); // load the image to a imageIcon
		Image backgroundImage = backgroundIcon.getImage();// transform it 
		Image newimg_background= backgroundImage.getScaledInstance(1021, 967,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backgroundIcon = new ImageIcon(newimg_background);
		//Design the window frame
		foodMenuFrame = new JFrame("Food Menu Selection");
		foodMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		foodMenuFrame.setBounds(100, 100, 1021, 967);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		foodMenuFrame.setContentPane(contentPane);
		foodMenuFrame.setVisible(true);
		contentPane.setLayout(null);
		contentPane.setSize(1021, 781);
		//Design the label for background image
		Label_BackgroundImage = new JLabel(backgroundIcon);
		Label_BackgroundImage.setBounds(0, 0, 1003, 920);
		contentPane.add(Label_BackgroundImage );
	    //Design the add and drop panel
	    addANDdropPanel = new JPanel();
	    addANDdropPanel.setOpaque(false);
	    Label_BackgroundImage.add(addANDdropPanel);
	    addANDdropPanel.setBorder(null);
	    addANDdropPanel.setBackground(new Color(255, 255, 255));
	    addANDdropPanel.setBounds(276, 597, 491, 291);
	    addANDdropPanel.setLayout(null);
	    //Design the food name text field
	    selectedFoodNameTEXT = new JTextField();
	    selectedFoodNameTEXT.setOpaque(false);
	    selectedFoodNameTEXT.setForeground(new Color(240, 255, 255));
	    selectedFoodNameTEXT.setBorder(null);
	    selectedFoodNameTEXT.setBackground(new Color(255, 255, 255));
	    selectedFoodNameTEXT.setDisabledTextColor(new Color(0, 0, 0));
	    selectedFoodNameTEXT.setEditable(false);
	    selectedFoodNameTEXT.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 25));
	    selectedFoodNameTEXT.setBounds(12, 13, 467, 72);
	    addANDdropPanel.add(selectedFoodNameTEXT);
	    selectedFoodNameTEXT.setColumns(10);
	    //Design the food price text field
	    selectedFoodPriceTEXT = new JTextField();
	    selectedFoodPriceTEXT.setForeground(new Color(240, 255, 255));
	    selectedFoodPriceTEXT.setOpaque(false);
	    selectedFoodPriceTEXT.setHorizontalAlignment(SwingConstants.CENTER);
	    selectedFoodPriceTEXT.setBorder(null);
	    selectedFoodPriceTEXT.setBackground(new Color(255, 255, 255));
	    selectedFoodPriceTEXT.setEditable(false);
	    selectedFoodPriceTEXT.setDisabledTextColor(new Color(0, 0, 0));
	    selectedFoodPriceTEXT.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 24));
	    selectedFoodPriceTEXT.setColumns(10);
	    selectedFoodPriceTEXT.setBounds(363, 98, 116, 51);
	    addANDdropPanel.add(selectedFoodPriceTEXT);
	    //Design the add button
	    addButton = new JButton("ADD");
	    addButton.setEnabled(false);
	    addButton.setBorder(new CompoundBorder());
	    addButton.setForeground(new Color(255, 255, 255));
	    addButton.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 15));
	    addButton.setContentAreaFilled(false);
	    addButton.setBackground(new Color(0, 255, 0));
	    addButton.setBounds(0, 0, 65, 51);
	    //Design the delete button
	    deleteButton = new JButton("DELETE");
	    deleteButton.setEnabled(false);
	    deleteButton.setBorder(new CompoundBorder());
	    deleteButton.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 14));
	    deleteButton.setForeground(new Color(255, 255, 255));
	    deleteButton.setContentAreaFilled(false);
	    deleteButton.setBounds(0, 0, 86, 52);
	    //Design the quantity text field
	    quantityText = new JTextField();
	    quantityText.setHorizontalAlignment(SwingConstants.CENTER);
	    quantityText.setText("0");
	    quantityText.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 20));
	    quantityText.setColumns(10);
	    quantityText.setBounds(234, 162, 57, 51);
	    addANDdropPanel.add(quantityText);
	    //Design the add button panel
	    addButtonpanel = new JPanel();
	    addButtonpanel.setBackground(new Color(50, 205, 50));
	    addButtonpanel.setBounds(134, 162, 65, 51);
	    addButtonpanel.setLayout(null);
	    addButtonpanel.add(addButton);
	    addANDdropPanel.add(addButtonpanel);
	    //Design the delete button panel
	    deleteButtonPanel = new JPanel();
	    deleteButtonPanel.setBackground(new Color(50, 205, 50));
	    deleteButtonPanel.setBounds(326, 161, 86, 52);
	    deleteButtonPanel.setLayout(null);
	    deleteButtonPanel.add(deleteButton);
	    addANDdropPanel.add(deleteButtonPanel);
	    //Design the add to order button
	    addToOrderButton = new JButton("Add to Order");
	    addToOrderButton.setEnabled(false);
	    addToOrderButton.setBorder(new CompoundBorder());
	    addToOrderButton.setForeground(new Color(255, 255, 255));
	    addToOrderButton.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 25));
	    addToOrderButton.setContentAreaFilled(false);
	    addToOrderButton.setBounds(0, 0, 467, 43);
	    //Design the add to order button panel
	    addToOrderButtonPanel = new JPanel();
	    addToOrderButtonPanel.setBackground(new Color(60, 179, 113));
	    addToOrderButtonPanel.setBounds(12, 235, 467, 43);
	    addANDdropPanel.add(addToOrderButtonPanel);
	    addToOrderButtonPanel.setLayout(null);
	    addToOrderButtonPanel.add(addToOrderButton);
	    //Design the visible button
	    viewDetailsButton = new JButton("Click to view details");
	    Label_BackgroundImage.add(viewDetailsButton);
	    viewDetailsButton.setForeground(new Color(50, 205, 50));
	    viewDetailsButton.setContentAreaFilled(false);
	    viewDetailsButton.setVisible(false);
	    viewDetailsButton.setBackground(new Color(50, 205, 50));
	    viewDetailsButton.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
	    viewDetailsButton.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
	    viewDetailsButton.setBounds(791, 844, 200, 44);
		//Design the header for food menu list 
		foodMenuListHeaderText = new JTextField();
		Label_BackgroundImage.add(foodMenuListHeaderText);
		foodMenuListHeaderText.setEditable(false);
		foodMenuListHeaderText.setBorder(null);
		foodMenuListHeaderText.setForeground(new Color(60, 179, 113));
		foodMenuListHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		foodMenuListHeaderText.setFont(new java.awt.Font("Lucida Handwriting", java.awt.Font.BOLD, 48));
		foodMenuListHeaderText.setOpaque(false);
		foodMenuListHeaderText.setText("Food Menu List");
		foodMenuListHeaderText.setBounds(236, 34, 478, 127);
		foodMenuListHeaderText.setColumns(10);
		//Design the header for instruction
		instructionclickOnTable = new JTextField();
		instructionclickOnTable.setText("*Click on table row to place the order");
		instructionclickOnTable.setOpaque(false);
		instructionclickOnTable.setHorizontalAlignment(SwingConstants.CENTER);
		instructionclickOnTable.setForeground(Color.WHITE);
		instructionclickOnTable.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 17));
		instructionclickOnTable.setEditable(false);
		instructionclickOnTable.setColumns(10);
		instructionclickOnTable.setBorder(null);
		instructionclickOnTable.setBounds(270, 139, 427, 43);
		Label_BackgroundImage.add(instructionclickOnTable);
		//Design the table for food list
		tableFoodList = new JTable();
		tableFoodList.setSelectionBackground(new Color(192, 192, 192));
		//Design the header for each column
		tableFoodList.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Food Name", "Food Description", "Food Price (MYR)"}) 
		{
			Class[] columnTypes = new Class[] {String.class, Object.class, Object.class};
			public Class getColumnClass(int columnIndex) 
			{
				return columnTypes[columnIndex];
			}
		});
		
		tableFoodList.getColumnModel().getColumn(0).setPreferredWidth(15);
		tableFoodList.getColumnModel().getColumn(1).setPreferredWidth(300);
		tableFoodList.setBounds(59, 76, 512, 334);
		
		tableFoodList.getTableHeader().setOpaque(false);
		tableFoodList.getTableHeader().setBackground(new Color(102, 153, 102));
		tableFoodList.getTableHeader().setForeground(new Color(255,255,255)); 
		//Design the scroll pane for food table
		scrollPaneFoodTable = new JScrollPane(tableFoodList);
		Label_BackgroundImage.add(scrollPaneFoodTable);
		scrollPaneFoodTable.setBackground(new Color(102, 153, 102));
		scrollPaneFoodTable.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrollPaneFoodTable.setBounds(12, 180, 979, 291);
		scrollPaneFoodTable.setBorder(new LineBorder(new Color(0, 128, 0), 1, true));
		
		/*Below are the code which are for performing the task*/
		
		tableFoodList.addMouseListener(this);
	    viewDetailsButton.addActionListener(this);
	    addToOrderButton.addActionListener(this);
	    addButton.addActionListener(this);
	    deleteButton.addActionListener(this);
	    
	    try 
	    {
	    	file.ReadFromfoodListFile();//read the food from text file
	    	DisplayFoodListToTable();//display the food on food list table
	    	file.deleteGeneralOrderOrderFile();//delete the content of general order
	    }catch(Exception error) {
	    	JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
	    }
	}
	/*
	 * Function to display the food list to table
	 */
	public void DisplayFoodListToTable() 
	{
		 DefaultTableModel model = (DefaultTableModel)tableFoodList.getModel();
		 Object[] foodRow;
		 //display on console
		 System.out.println("Food List");
		 border.tableBorderForFood();//display border on console
		 //display header on console
		 System.out.printf("%1s %-60s %1s  %-100s %1s  %5s %1s\n", "|","Food Name","|","Food Description","|","Price","|");
		 border.tableBorderForFood();//display border on console
		 for(Food food : file.foods.food) 
		 {
			 //get the details of food 
			 foodRow = new Object[] {food.getFoodName(), food.getFoodDescription(), food.getFoodPrice()};
			 model.addRow(foodRow);//add the food details to table row 
			 System.out.println(food.toString());//display on console
		 }
		 border.tableBorderForFood();//display border on console
	}
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		 Object source = event.getSource();
		 
		 if(source == viewDetailsButton)//if user press the view detail button 
		 {
				CustomerAndOrderDetailsGUI windows = new CustomerAndOrderDetailsGUI();//open customer and order details GUI window frame
				windows.orderdetailsWindows.setVisible(true);//set the window become visible
				foodMenuFrame.setVisible(false);//invisible the food menu frame
		 }
		 else if(source == addToOrderButton)//if user press add to order button 
		 {
	    		try 
	    		{
	    			//get the name from text field 
	   		 		String foodName = selectedFoodNameTEXT.getText();
	   		 		String quantity_text = quantityText.getText();
	   		 		String price_text = selectedFoodPriceTEXT.getText();
	   		 		quantity = Integer.parseInt(quantity_text);//convert quantity to integer
	   		 		double price = Double.parseDouble(price_text);//convert price to double
	   		 		double totalPrice = (quantity*price);//calculate total price	    		
	   		 		file.recordTheOrderToFile(foodName, quantity, price, totalPrice);//record the order to file
	   		 	    //Set the view details button
	   		 		placeOrderQuantity++;//increment the place order quantity by 1
	   		 	    viewDetailsButton.setVisible(true);//visible the button
	   		 	    viewDetailsButton.setText("Click to view " + placeOrderQuantity + " details");//display the message to button
	   		 		
	    		}catch(Exception error) 
	    		{
	    			JOptionPane.showMessageDialog(null,error.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
	    		}
		 }
		 else if(source == deleteButton)//if user press delete button 
		 {

			 	String quantity_text = quantityText.getText();
			    quantity = Integer.parseInt(quantity_text);
			    if(quantity > 0)//if quantity is greater than 0  
			    {
			    	quantity--;//decrement the quantity by 1
			    	quantityText.setText(quantity+"");//set the quantity to text field
			    }
			    if(quantity == 0)//if the quantity is equals to 0
			    {
			    	addToOrderButton.setEnabled(false);//disable the add to order button
			    	quantity = 0;//set the quantity to 0
			    	quantityText.setText(quantity+"");//set the quantity to text field 
			    }
		 }
		 else if(source == addButton)//if user press add button 
		 {
			    addToOrderButton.setEnabled(true);//enable the add to order button
			    quantity++;//increment the quantity by 1 
			    quantityText.setText(quantity+"");//set the quantity to text field	
		 }
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
			int index = tableFoodList.getSelectedRow();
			TableModel model = tableFoodList.getModel();
			//get the details from table
			String foodName = model.getValueAt(index, 0).toString();
			String foodprice = model.getValueAt(index, 2).toString();
			String quantity_text = quantityText.getText();
			
			quantity = Integer.parseInt(quantity_text);//convert quantity to integer
			quantity = 0;//set quantity to zero
			quantityText.setText(quantity+"");//set the quantity to text
			
			selectedFoodNameTEXT.setText(foodName);//set the food name to text file
			selectedFoodPriceTEXT.setText(foodprice);//set the food price to text file
			
			addButton.setEnabled(true);//enable the add button
			deleteButton.setEnabled(true);//enable the delete button
			addToOrderButton.setEnabled(false);//disable the add to order button
	}
}
