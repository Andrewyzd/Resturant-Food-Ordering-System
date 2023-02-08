import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class CheckAssignedOrderGUI extends JFrame {

	private JPanel contentPane;
	private JTextField nameHeaderText,idHearderText, contactNumberHeaderText;
	private JLabel Label_BackgroundImage;
	private JScrollPane deliveryOrderScrollPane;
	public  JTable deliveryOrderListTable;
	public  JTextField nameText,idText,contactNumberText;
	/**
	 * Constructor to display the windows and components
	 */
	public CheckAssignedOrderGUI() {
		//Design the image to be displayed
		ImageIcon backgroundIcon = new ImageIcon("ImageIcon\\riderBackground.jpg"); // load the image to a imageIcon
		Image backgroundImage = backgroundIcon.getImage();// transform it 
		Image newimg_background= backgroundImage.getScaledInstance(1320, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		backgroundIcon = new ImageIcon(newimg_background);
		//Design the window frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1320, 600);
		setTitle("Assigned Order");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Add the image to label
		Label_BackgroundImage = new JLabel(backgroundIcon);
		Label_BackgroundImage.setBorder(null);
		Label_BackgroundImage.setFont(new Font("Tahoma", Font.BOLD, 20));
		Label_BackgroundImage.setBounds(0, 0, 1320, 600);
		contentPane.add(Label_BackgroundImage);
		//Design the table for delivery OrderList
		deliveryOrderListTable = new JTable();
		deliveryOrderListTable.setBounds(86, 110, 1, 1);
		deliveryOrderListTable.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"Customer ID","Food Name","Quantity","Prices","Total Price","Date","Time","Delivery Charge","Overall Price","Address","Postcode","Area","Order ID"}
			));	
		deliveryOrderListTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		deliveryOrderListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		deliveryOrderListTable.getColumnModel().getColumn(2).setPreferredWidth(8);
		deliveryOrderListTable.getColumnModel().getColumn(3).setPreferredWidth(6);
		deliveryOrderListTable.getColumnModel().getColumn(4).setPreferredWidth(11);
		deliveryOrderListTable.getColumnModel().getColumn(5).setPreferredWidth(10);
		deliveryOrderListTable.getColumnModel().getColumn(6).setPreferredWidth(10);
		deliveryOrderListTable.getColumnModel().getColumn(7).setPreferredWidth(20);
		deliveryOrderListTable.getColumnModel().getColumn(8).setPreferredWidth(20);
		deliveryOrderListTable.getColumnModel().getColumn(9).setPreferredWidth(100);
		deliveryOrderListTable.getColumnModel().getColumn(10).setPreferredWidth(8);
		deliveryOrderListTable.getColumnModel().getColumn(11).setPreferredWidth(50);
		deliveryOrderListTable.getColumnModel().getColumn(12).setPreferredWidth(8);
		deliveryOrderListTable.getTableHeader().setOpaque(false);
		deliveryOrderListTable.getTableHeader().setBackground(new Color(102, 153, 102));
		deliveryOrderListTable.getTableHeader().setForeground(new Color(255,255,255)); 
		//Design the scroll pane on table
		deliveryOrderScrollPane = new JScrollPane(deliveryOrderListTable);
		deliveryOrderScrollPane.setBounds(0, 210, 1300, 292);
		Label_BackgroundImage.add(deliveryOrderScrollPane);
		//Design the text field
		nameHeaderText = new JTextField();
		Label_BackgroundImage.add(nameHeaderText);
		nameHeaderText.setForeground(Color.WHITE);
		nameHeaderText.setText("Name: ");
		nameHeaderText.setOpaque(false);
		nameHeaderText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nameHeaderText.setEditable(false);
		nameHeaderText.setColumns(10);
		nameHeaderText.setBorder(null);
		nameHeaderText.setBounds(26, 36, 157, 44);
		//Design the header text field
		idHearderText = new JTextField();
		Label_BackgroundImage.add(idHearderText);
		idHearderText.setForeground(Color.WHITE);
		idHearderText.setText("Identity number:");
		idHearderText.setOpaque(false);
		idHearderText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		idHearderText.setEditable(false);
		idHearderText.setColumns(10);
		idHearderText.setBorder(null);
		idHearderText.setBounds(26, 92, 157, 44);
		//Design the header text field
		contactNumberHeaderText = new JTextField();
		Label_BackgroundImage.add(contactNumberHeaderText);
		contactNumberHeaderText.setForeground(Color.WHITE);
		contactNumberHeaderText.setText("Contact number:");
		contactNumberHeaderText.setOpaque(false);
		contactNumberHeaderText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contactNumberHeaderText.setEditable(false);
		contactNumberHeaderText.setColumns(10);
		contactNumberHeaderText.setBorder(null);
		contactNumberHeaderText.setBounds(26, 149, 157, 43);
		//Design the text field
		nameText = new JTextField();
		nameText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_BackgroundImage.add(nameText);
		nameText.setBorder(new LineBorder(new Color(171, 173, 179)));
		nameText.setColumns(10);
		nameText.setBounds(223, 36, 192, 44);
		//Design the text field
		idText = new JTextField();
		idText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_BackgroundImage.add(idText);
		idText.setBorder(new LineBorder(new Color(171, 173, 179)));
		idText.setColumns(10);
		idText.setBounds(223, 93, 192, 43);
		//Design the text field
		contactNumberText = new JTextField();
		contactNumberText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Label_BackgroundImage.add(contactNumberText);
		contactNumberText.setBorder(new LineBorder(new Color(171, 173, 179)));
		contactNumberText.setColumns(10);
		contactNumberText.setBounds(223, 148, 192, 44);
	}
}