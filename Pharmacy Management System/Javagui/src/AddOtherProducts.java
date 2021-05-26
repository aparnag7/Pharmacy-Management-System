import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import java.awt.TextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButtonMenuItem;

public class AddOtherProducts extends JFrame {

    private static final long serialVersionUID = 1L;
 
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField CostPrice_text;
    JPasswordField password_text;
    JButton submit, cancel;
    private JPanel contentPane;
    private JTextField Drugname;
    private JTextField CompanyName;
    private JTextField CostPrice;
    private JTextField SellingPrice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    } 

    public AddOtherProducts() throws IOException {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\products.jpg"));
    	//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        

        JLabel lblAddOtherProducts = new JLabel("Add new Products");
        lblAddOtherProducts.setForeground(new Color(240, 255, 240));
        lblAddOtherProducts.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
        lblAddOtherProducts.setBounds(362, 52, 355, 50);
        contentPane.add(lblAddOtherProducts);

        JLabel lblDName = new JLabel("Product name");
        lblDName.setForeground(new Color(240, 255, 240));
        lblDName.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblDName.setBounds(58, 152, 146, 43);
        contentPane.add(lblDName);

        JLabel lblCompany = new JLabel("Company name");
        lblCompany.setForeground(new Color(240, 255, 240));
        lblCompany.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblCompany.setBounds(521, 159, 150, 29);
        contentPane.add(lblCompany);

        JLabel lblweight = new JLabel("Weight");
        lblweight.setForeground(new Color(240, 255, 240));
        lblweight.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblweight.setBounds(58, 324, 124, 36);
        contentPane.add(lblweight);

        Drugname = new JTextField();
        Drugname.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
        Drugname.setBounds(214, 151, 228, 50);
        contentPane.add(Drugname);
        Drugname.setColumns(10);

        CompanyName = new JTextField();
        CompanyName.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
        CompanyName.setBounds(707, 151, 246, 50);
        contentPane.add(CompanyName);
        CompanyName.setColumns(10);

        CostPrice = new JTextField();
        CostPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
        CostPrice.setBounds(214, 235, 228, 50);
        contentPane.add(CostPrice);
        CostPrice.setColumns(10);

        JLabel lblCostPrice = new JLabel("CostPrice");
        lblCostPrice.setForeground(new Color(240, 255, 240));
        lblCostPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblCostPrice.setBounds(58, 250, 99, 29);
        contentPane.add(lblCostPrice);

        JLabel lblSellPrice = new JLabel("Selling Price");
        lblSellPrice.setForeground(new Color(240, 255, 240));
        lblSellPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblSellPrice.setBounds(542, 245, 129, 24);
        contentPane.add(lblSellPrice);
        
        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(0)));
        spinner.setBounds(214, 336, 228, 20);
        contentPane.add(spinner);
        
        JDateChooser manDate = new JDateChooser();
        manDate.setBounds(214, 421, 217, 20);
        contentPane.add(manDate);
        
        JLabel lblNewLabel_1 = new JLabel("Manufacturing Date");
        lblNewLabel_1.setForeground(new Color(240, 255, 240));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 410, 198, 43);
        contentPane.add(lblNewLabel_1);
        
        JDateChooser Exp_date = new JDateChooser();
        Exp_date.setBounds(707, 421, 246, 20);
        contentPane.add(Exp_date);
        
        JLabel lblNewLabel_2 = new JLabel("Expiry Date");
        lblNewLabel_2.setForeground(new Color(240, 255, 240));
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(541, 421, 132, 32);
        contentPane.add(lblNewLabel_2);
                
        SellingPrice = new JTextField();
        SellingPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
        SellingPrice.setBounds(704, 235, 249, 50);
        contentPane.add(SellingPrice);
        SellingPrice.setColumns(10);
        ButtonGroup G = new ButtonGroup();
        JSpinner quantity = new JSpinner();
        quantity.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
        quantity.setBounds(214, 371, 228, 20);
        contentPane.add(quantity);
        
        JLabel Quantity = new JLabel("Quantity");
        Quantity.setForeground(new Color(240, 255, 240));
        Quantity.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        Quantity.setBounds(58, 371, 100, 25);
        contentPane.add(Quantity);
        JButton btnNewButton_1 = new JButton("Add Product");
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\products.jpg"));
        btnNewButton_1.setForeground(new Color(112, 128, 144));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Drug Form in action");
        		String product_name = Drugname.getText();
        		String company_name = CompanyName.getText();
        		double weight = (double) spinner.getValue();
        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        		String man_date = sdf1.format(manDate.getDate());
        		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        		String exp_date = sdf1.format(Exp_date.getDate());
        		String cp = CostPrice.getText();
        		double cost_price = Double.parseDouble(cp);
        		String sp = SellingPrice.getText();
        		double selling_price = Double.parseDouble(sp);
           		int quant = (int) quantity.getValue();       	   
        		try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					System.out.println("Connection made\n" + product_name +" " +company_name+" "+ man_date+" "+exp_date+" "+weight);
						//insert new Drugs to DB
	                    String query = "insert into products (idproducts,productname,productscompany,costprice,sellingprice,weight,quantity,manufacturingdate,expirydate)" + " values (?, ?, ?,?,?,?,?,?,?)";
	                    PreparedStatement preparedStmt = connection.prepareStatement(query);
	                    preparedStmt.setInt(1, 124);
	                    preparedStmt.setString(2,product_name );
	                    preparedStmt.setDouble(6,weight);
	                    preparedStmt.setString(3,company_name);
	                    preparedStmt.setDouble(4,cost_price);
	                    preparedStmt.setDouble(5,selling_price);
	                    preparedStmt.setString(8,man_date);
	                    preparedStmt.setString(9,exp_date);	              
	                    preparedStmt.setInt(7,quant);
	                    preparedStmt.execute();
	                    System.out.print("Entered");
	                    JOptionPane.showMessageDialog(null, "Added new Product " + product_name);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}  
        	}
        });
        btnNewButton_1.setBackground(new Color(255, 160, 122));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        btnNewButton_1.setBounds(193, 485, 259, 50);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Reset");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\reset.jpg"));
        btnNewButton.setForeground(new Color(119, 136, 153));
        btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//set all text box to ""
                    Drugname.setText("");
                    CompanyName.setText("");
                    SellingPrice.setText("");
                    CostPrice.setText("");
                    quantity.setValue(1);
                    spinner.setValue(0);
                    manDate.setDate(null);
                    Exp_date.setDate(null);
                    G.clearSelection();
                    }
        });
        btnNewButton.setBounds(744, 485, 183, 48);
        contentPane.add(btnNewButton);
}
}