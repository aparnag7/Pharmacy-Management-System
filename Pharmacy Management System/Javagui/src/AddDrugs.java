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

public class AddDrugs extends JFrame {

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
    int drug_id_ = 0;
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

    public AddDrugs() throws IOException {
    	//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images"));
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 664);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(47, 79, 79));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        

        JLabel lblAddDrugs = new JLabel("Add new Drugs");
        lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\set-drugs-cartoon-vector-illustration-260nw-226067881 (3).jpg"));
        lblAddDrugs.setForeground(new Color(240, 255, 240));
        lblAddDrugs.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
        lblAddDrugs.setBounds(362, 52, 369, 50);
        contentPane.add(lblAddDrugs);

        JLabel lblDName = new JLabel("Drug name");
        lblDName.setForeground(new Color(240, 255, 240));
        lblDName.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblDName.setBounds(58, 152, 99, 43);
        contentPane.add(lblDName);

        JLabel lblCompany = new JLabel("Company name");
        lblCompany.setForeground(new Color(240, 255, 240));
        lblCompany.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblCompany.setBounds(521, 159, 150, 29);
        contentPane.add(lblCompany);

        JLabel lbldosage = new JLabel("Dosage");
        lbldosage.setForeground(new Color(240, 255, 240));
        lbldosage.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lbldosage.setBounds(58, 324, 124, 36);
        contentPane.add(lbldosage);

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
        
        JLabel lblNewLabel = new JLabel("Drug Type");
        lblNewLabel.setForeground(new Color(240, 255, 240));
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNewLabel.setBounds(542, 330, 117, 25);
        contentPane.add(lblNewLabel);
        
        JSpinner spinner = new JSpinner();
        spinner.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
        spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(0)));
        spinner.setBounds(214, 336, 228, 20);
        contentPane.add(spinner);
        
        JDateChooser manDate = new JDateChooser();
        manDate.setBounds(214, 465, 217, 20);
        contentPane.add(manDate);
        
        JLabel lblNewLabel_1 = new JLabel("Manufacturing Date");
        lblNewLabel_1.setForeground(new Color(240, 255, 240));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(10, 453, 198, 43);
        contentPane.add(lblNewLabel_1);
        
        JDateChooser Exp_date = new JDateChooser();
        Exp_date.setBounds(707, 465, 246, 20);
        contentPane.add(Exp_date);
        
        JLabel lblNewLabel_2 = new JLabel("Expiry Date");
        lblNewLabel_2.setForeground(new Color(240, 255, 240));
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(555, 458, 132, 32);
        contentPane.add(lblNewLabel_2);
                
        SellingPrice = new JTextField();
        SellingPrice.setEditable(false);
        SellingPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
        SellingPrice.setBounds(704, 235, 249, 50);
        contentPane.add(SellingPrice);
        SellingPrice.setColumns(10);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Tablet");
        rdbtnNewRadioButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(707, 335, 111, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Injection Fluid");
        rdbtnNewRadioButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton_1.setBounds(852, 333, 117, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Syrup");
        rdbtnNewRadioButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton_2.setBounds(707, 369, 111, 23);
        contentPane.add(rdbtnNewRadioButton_2);
        
        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Cream");
        rdbtnNewRadioButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton_3.setBounds(852, 369, 117, 23);
        contentPane.add(rdbtnNewRadioButton_3);
        
        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Masks");
        rdbtnNewRadioButton_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton_4.setBounds(707, 406, 111, 23);
        contentPane.add(rdbtnNewRadioButton_4);
        
        JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Other Products");
        rdbtnNewRadioButton_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
        rdbtnNewRadioButton_5.setBounds(852, 406, 117, 23);
        contentPane.add(rdbtnNewRadioButton_5);
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_1);
        G.add(rdbtnNewRadioButton_2);
        G.add(rdbtnNewRadioButton_3);
        G.add(rdbtnNewRadioButton_4);
        G.add(rdbtnNewRadioButton_5);
        JSpinner quantity = new JSpinner();
        quantity.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
        quantity.setBounds(214, 371, 228, 20);
        contentPane.add(quantity);
        
        JLabel Quantity = new JLabel("Quantity");
        Quantity.setForeground(new Color(240, 255, 240));
        Quantity.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        Quantity.setBounds(58, 371, 100, 25);
        contentPane.add(Quantity);
        JButton btnNewButton_1 = new JButton("Add Drug");
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\adddrugs.jpg"));
        btnNewButton_1.setForeground(new Color(112, 128, 144));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Drug Form in action");
        		String drug_name = Drugname.getText();
        		String company_name = CompanyName.getText();
        		double dosage = (double) spinner.getValue();
        		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        		String man_date = sdf1.format(manDate.getDate());
        		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        		String exp_date =null;
        		if(Exp_date.getDate()!=null)
        			exp_date = sdf1.format(Exp_date.getDate());
        		String cp = CostPrice.getText();
        		double cost_price = Double.parseDouble(cp);
        		double x = 0.0;
        		
        		String drug_type = "";
        		if(rdbtnNewRadioButton.isSelected()) { 
        			drug_type = "Tablet";
        			x = 1.20;
        		}
        		else if(rdbtnNewRadioButton_1.isSelected()) {
        			drug_type ="Injection Fluid";
        			x = 1.3;
        		}
        		else if(rdbtnNewRadioButton_2.isSelected()) {
        			drug_type ="Syrup";
        			x = 1.50;
        		}
        		else if(rdbtnNewRadioButton_3.isSelected()) {
        			drug_type = "Cream";
        			x = 1.20;
        		}
        		else if (rdbtnNewRadioButton_4.isSelected()) {
        			drug_type = "Masks";
        			exp_date = null;
        			x = 1.25;
        			}
        		else {
        			drug_type = "Others";
        			x = 1.10;
        		}
        		int quant = (int) quantity.getValue();
        		double selling_price = cost_price * x; 
        		SellingPrice.setText(selling_price+"");
        		try {
        			Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					Statement statement = connection.createStatement();
					String query = "select * from numberkeys where slno = 1";
					ResultSet resultSet = statement.executeQuery(query);
					while(resultSet.next()) {
		      			drug_id_ = resultSet.getInt("drugid");
		      		}
					System.out.println(drug_id_);					
        		}
        		catch(Exception e1) {
        			
        		}
        	//update in db        		
        	   
        		try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					System.out.println("Connection made\n" + drug_name +" " +company_name+" "+ man_date+" "+exp_date+" "+dosage);
	                
						//insert new Drugs to DB
	                    String query = "insert into drugs (iddrugs,drugname,dose,company,cprice,sprice,dateofmanufacture,expirydate,drugtype,quantity)" + " values (?, ?, ?,?,?,?,?,?,?,?)";
	                    PreparedStatement preparedStmt = connection.prepareStatement(query);
	                    preparedStmt.setInt(1, drug_id_);
	                    preparedStmt.setString(2,drug_name );
	                    preparedStmt.setDouble(3,dosage);
	                    preparedStmt.setString(4,company_name);
	                    preparedStmt.setDouble(5,cost_price);
	                    preparedStmt.setDouble(6,selling_price);
	                    preparedStmt.setString(7,man_date);
	                    preparedStmt.setString(8,exp_date);
	                    preparedStmt.setString(9,drug_type);
	                    preparedStmt.setInt(10,quant);
	                    preparedStmt.execute();
	                    System.out.print("Entered");
	                    JOptionPane.showMessageDialog(null, "Added new Drug " + drug_name);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
        		try {
            		Class.forName("com.mysql.jdbc.Driver");
    				Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    				Statement statement = connection.createStatement();
    				drug_id_+=1;
        			String query2 = "update numberkeys set drugid = '"+drug_id_ +"' where slno = 1";
                    statement.executeUpdate(query2);
                    System.out.println("Done updating drugid");
        		}
        		catch(Exception e2) {
        			
        		}
        	}
        });
        btnNewButton_1.setBackground(new Color(255, 160, 122));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        btnNewButton_1.setBounds(193, 522, 259, 50);
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
                    try {
            			Class.forName("com.mysql.jdbc.Driver");
    					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    					Statement statement = connection.createStatement();
    					String query = "select * from numberkeys where slno = 1";
    					ResultSet resultSet = statement.executeQuery(query);
    					while(resultSet.next()) {
    		      			drug_id_ = resultSet.getInt("drugid");
    		      		}
    					System.out.println(drug_id_);
    					drug_id_+=1;
    					
            		}
            		catch(Exception e1) {
            			
            		}

                    }
        });
        btnNewButton.setBounds(744, 523, 183, 48);
        contentPane.add(btnNewButton);
        
        
}
}