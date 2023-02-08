import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;

public class RidersGUI extends MouseAdapter implements ActionListener {

	private JPanel contentPane;
	private JLabel Label_BackgroundImage;
	private JTable ridersTable;
	private JScrollPane ridersTablescrollPane;
	public  JFrame ridersFrame;
	private JPanel assignOrderButtonPanel,checkOrderButtonPanel;
	private JButton assignOrderButton,checkOrderButton;
	private JTextField riderListHeader;
	FileHandling file = new FileHandling();
	ConcoleTableLine border = new ConcoleTableLine();
	/**
	 * Constructor to display window frame and components
	 */
	public RidersGUI() {
		//Design the background of rider
		ImageIcon backgroundIcon = new ImageIcon("ImageIcon\\riderBackground.jpg"); // load the image to a imageIcon
		Image backgroundImage = backgroundIcon.getImage();// transform it 
		Image newimg_background= backgroundImage.getScaledInstance(786, 530,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backgroundIcon = new ImageIcon(newimg_background);
		//design the windows frame
		ridersFrame = new JFrame();
		ridersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ridersFrame.setTitle("Riders List");
		ridersFrame.setBounds(100, 100, 786, 530);
		ridersFrame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ridersFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		//Design the label for background image
		Label_BackgroundImage = new JLabel(backgroundIcon);
		Label_BackgroundImage.setBounds(0, 0, 786, 530);
		contentPane.add(Label_BackgroundImage);
		//Design the table
		ridersTable = new JTable();
		ridersTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ridersTable.setBounds(162, 64, 1, 1);
		Label_BackgroundImage.add(ridersTable);
		
		ridersTable.setBackground(Color.WHITE);
		ridersTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Identity NUmber", "Contact Number"
			}
		));	
		
		ridersTable.getTableHeader().setOpaque(false);
		ridersTable.getTableHeader().setBackground(new Color(102, 153, 102));
		ridersTable.getTableHeader().setForeground(new Color(255,255,255));  
		//Design the scroll pane for table
		ridersTablescrollPane = new JScrollPane(ridersTable);
		ridersTablescrollPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ridersTablescrollPane.setBounds(0, 312, 768, 171);
		Label_BackgroundImage.add(ridersTablescrollPane);
		//Design the panel for assign order button 
		assignOrderButtonPanel = new JPanel();
		assignOrderButtonPanel.setBackground(new Color(204, 204, 255));
		assignOrderButtonPanel.setBorder(new LineBorder(Color.WHITE, 1, true));
		assignOrderButtonPanel.setBounds(629, 243, 126, 42);
		Label_BackgroundImage.add(assignOrderButtonPanel);
		assignOrderButtonPanel.setLayout(null);
		//Design the button for assign order
		assignOrderButton = new JButton("Assign Order");
		assignOrderButton.setOpaque(false);
		assignOrderButton.setForeground(Color.WHITE);
		assignOrderButton.setEnabled(false);
		assignOrderButton.setContentAreaFilled(false);
		assignOrderButton.setBorderPainted(false);
		assignOrderButton.setBorder(null);
		assignOrderButton.setBounds(0, 0, 126, 42);
		assignOrderButton.addActionListener(this);
		assignOrderButtonPanel.add(assignOrderButton);
		//Design the panel for check order button
		checkOrderButtonPanel = new JPanel();
		checkOrderButtonPanel.setBorder(new LineBorder(Color.WHITE, 1, true));
		checkOrderButtonPanel.setBackground(new Color(204, 204, 255));
		checkOrderButtonPanel.setBounds(478, 243, 139, 42);
		Label_BackgroundImage.add(checkOrderButtonPanel);
		checkOrderButtonPanel.setLayout(null);
		//Design the check order button
		checkOrderButton = new JButton("Check Assigned Order");
		checkOrderButton.setForeground(Color.WHITE);
		checkOrderButton.setContentAreaFilled(false);
		checkOrderButton.setOpaque(false);
		checkOrderButton.setEnabled(false);
		checkOrderButton.setBorderPainted(false);
		checkOrderButton.setBorder(null);
		checkOrderButton.setBounds(0, 0, 139, 42);
		checkOrderButton.addActionListener(this);
		checkOrderButtonPanel.add(checkOrderButton);
		//Design the header text for rider list
		riderListHeader = new JTextField();
		Label_BackgroundImage.add(riderListHeader);
		riderListHeader.setText("Rider List");
		riderListHeader.setOpaque(false);
		riderListHeader.setHorizontalAlignment(SwingConstants.CENTER);
		riderListHeader.setForeground(Color.WHITE);
		riderListHeader.setFont(new Font("Lucida Handwriting", Font.BOLD, 48));
		riderListHeader.setEditable(false);
		riderListHeader.setColumns(10);
		riderListHeader.setBorder(null);
		riderListHeader.setBounds(409, 46, 357, 127);
		
		/*Below are the code which are for performing the task*/
		
		ridersTable.addMouseListener(this);
		try 
		{
			file.readRidersFromFile();//read the rider record from file 
			displayRiderToTable();//display the rider record to table
	    	file.readDeliveryOrderFromTextFile();//read the delivery record from text file
	       	file.readFromAssingedOrderTextFile();//read from assigned order file
		}catch(Exception e) 
		{
			JOptionPane.showMessageDialog(null,e.getMessage(),"Warning!!!",JOptionPane.WARNING_MESSAGE);
		}
	}
	/*
	 * Function to display the rider details on table
	 */
	public void displayRiderToTable() 
	{
		DefaultTableModel model = (DefaultTableModel)ridersTable.getModel();
		Object[] ridersRow ;
		//Display on console
		System.out.println("Riders List");
		border.tableBorderForRider();//display border on console
		//display the header on console
		System.out.printf("%1s %-30s %1s %-20s %1s %-20s %1s\n", "|","Name","|","Identity Number","|","Contact Number","|");
		border.tableBorderForRider();//display border on console
		for(Rider rider:file.riders.riders) 
		{
			//get the details of rider
			ridersRow = new Object[] {rider.getName(),rider.getIdentityNumber(), rider.getContactNumber()};
			model.addRow(ridersRow);//add row to the rider table
			System.out.println(rider.toString());//display on console
		}
		border.tableBorderForRider();//display border on console
	}
	/*
	 * Function to display the assigned order details to table
	 */
	public void displayAssignedOrder(CheckAssignedOrderGUI checkAssign, String riderID)
	{
		DefaultTableModel model = (DefaultTableModel)checkAssign.deliveryOrderListTable.getModel();
		Object[] deliveryRow;
     	for (AssignOrder works : file.collectAssignedOrder.assignOrder)
    	{
     		for(DeliveryOrder delivery : file.orders.deliveryorder) 
     		{
     			if(works.getPostcode().equals(delivery.getPostcode()) && works.getOrderID().equals(delivery.getOrderID()) && works.getRiderID().equals(riderID))//if the postcode,orderID, and identity number is match 
     			{
     				//retrieved the details of the delivery order 
     				deliveryRow = new Object[]{delivery.getCustomerId(), delivery.getFoodName(),delivery.getQuantity(),
							   				   delivery.getPrice(), delivery.getTotalPrice(),delivery.getDate(),
							   				   delivery.getTime(),delivery.getDelivery_charge(),delivery.getOverallPrice(), 
							   				   delivery.getAddress(),delivery.getPostcode(),delivery.getArea(),delivery.getOrderID()};
     				model.addRow(deliveryRow);//add the details to the table row
     			}

    		}
    	}
     	
	}
	
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source == checkOrderButton)//if user click on check order button
        {
    		//retrieved the details from table
        	int index = ridersTable.getSelectedRow();
    		TableModel model = ridersTable.getModel();
    		String riderName = model.getValueAt(index, 0).toString();
    		String riderID = model.getValueAt(index, 1).toString();
    		String riderPhoneNumber = model.getValueAt(index, 2).toString();
    		
    		CheckAssignedOrderGUI assignWork = new CheckAssignedOrderGUI();
    		assignWork.setVisible(true);//visible the windows frame
    		//set the riders details on the text field respectively
    		assignWork.nameText.setText(riderName);
    		assignWork.idText.setText(riderID);
    		assignWork.contactNumberText.setText(riderPhoneNumber);
    	    displayAssignedOrder(assignWork, riderID);//display the assigned order to the table
        }
        	
        if(source == assignOrderButton)//if user click assigned order button 
        {
    		//retrieve the details from table
        	int index = ridersTable.getSelectedRow();
    		TableModel model = ridersTable.getModel();
    		String riderName = model.getValueAt(index, 0).toString();
    		String riderID = model.getValueAt(index, 1).toString();
    		String riderPhoneNumber = model.getValueAt(index, 2).toString();
    		
    		ridersFrame.setVisible(false);//invisible the rider windows frame 
    		
    		AssignWorkToRiderGUI assignWork = new AssignWorkToRiderGUI();
    		assignWork.setVisible(true);//set the visible to true
    		//set the riders details on the text field respectively
    		assignWork.nameText.setText(riderName);
    		assignWork.idText.setText(riderID);
    		assignWork.contactNumberText.setText(riderPhoneNumber);
        }
    }
	
	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		checkOrderButton.setEnabled(true);
		checkOrderButtonPanel.setBackground(new Color(51, 204, 51));
		assignOrderButton.setEnabled(true);
		assignOrderButtonPanel.setBackground(new Color(51, 204, 51));
	}
}
