import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class CustomerRegister extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private JFrame frame;
    private JLabel lblAlreadyRegistered;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerRegister frame = new CustomerRegister();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CustomerRegister() {
    	setForeground(new Color(72, 209, 204));
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\register.jpg"));
    	setBackground(new Color(72, 209, 204));
    	
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1058, 730);
        setResizable(true);
        contentPane = new JPanel(); 
        contentPane.setForeground(new Color(72, 209, 204));
        contentPane.setBackground(new Color(72, 209, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
           
        JLabel lblNewLabel = new JLabel("Customer Registration");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\addnewuser.jpg"));
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 46));
        lblNewLabel.setBounds(356, 21, 510, 93);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setForeground(new Color(25, 25, 112));
        textField.setBackground(new Color(224, 255, 255));
        textField.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField.setBounds(198, 152, 170, 52);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(0, 0, 128));
        passwordField.setBackground(new Color(224, 255, 255));
        passwordField.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        passwordField.setBounds(812, 365, 176, 52);
        contentPane.add(passwordField);
        //name 
        textField2 = new JTextField();
        textField2.setForeground(new Color(0, 0, 128));
        textField2.setBackground(new Color(224, 255, 255));
        textField2.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField2.setBounds(812, 152, 176, 52);
        contentPane.add(textField2);
        textField2.setColumns(10);
        //designation
        textField3 = new JTextField();
        textField3.setForeground(new Color(0, 0, 128));
        textField3.setBackground(new Color(224, 255, 255));
        textField3.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField3.setBounds(198, 250, 176, 59);
        contentPane.add(textField3);
        textField3.setColumns(10);
        
        textField4 = new JTextField();
        textField4.setForeground(new Color(25, 25, 112));
        textField4.setBackground(new Color(224, 255, 255));
        textField4.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField4.setBounds(192, 361, 176, 59);
        contentPane.add(textField4);
        textField4.setColumns(10);

        
        //username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(new Color(240, 255, 240));
        lblUsername.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblUsername.setBounds(33, 368, 193, 52);
        contentPane.add(lblUsername);
        //password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(240, 255, 240));
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblPassword.setBounds(619, 365, 193, 52);
        contentPane.add(lblPassword);
        //now get details
        JLabel lblName = new JLabel("Name");
        lblName.setForeground(new Color(240, 255, 240));
        lblName.setBackground(Color.CYAN);
        lblName.setFont(new Font("Sitka Text", Font.PLAIN, 31));
        lblName.setBounds(53, 152, 193, 52);
        contentPane.add(lblName);
        //designation
        JLabel lblDesgn = new JLabel("Phone Number");
        lblDesgn.setForeground(new Color(240, 255, 240));
        lblDesgn.setBackground(Color.CYAN);
        lblDesgn.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblDesgn.setBounds(609, 152, 193, 52);
        contentPane.add(lblDesgn);
        
        JLabel lblAge = new JLabel("Age");
        lblAge.setForeground(new Color(240, 255, 240));
        lblAge.setBackground(new Color(240, 255, 240));
        lblAge.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblAge.setBounds(53, 254, 193, 52);
        contentPane.add(lblAge);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(240, 255, 240));
        lblAddress.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblAddress.setBackground(new Color(240, 255, 240));
        lblAddress.setBounds(609, 250, 193, 52);
        contentPane.add(lblAddress);
        
        textField_1 = new JTextField();
        textField_1.setForeground(new Color(0, 0, 128));
        textField_1.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField_1.setColumns(10);
        textField_1.setBackground(new Color(224, 255, 255));
        textField_1.setBounds(812, 242, 176, 52);
        contentPane.add(textField_1);        
        
        btnNewButton =  new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String Name = textField.getText();
        		String phone_number = textField2.getText();
        		String username = textField4.getText();
        		String age = textField3.getText();
                String password = passwordField.getText();
                String address = textField_1.getText();
                int Age = Integer.parseInt(age);
                
                boolean flag = false;
                int id = 0;
                try {
                	Class.forName("com.mysql.jdbc.Driver");  
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
                    System.out.println("Connection made for keytable");
                    Statement statement = connection.createStatement();
                    String query1 = "select * from numberkeys where slno = 1";
                    ResultSet resultSet = statement.executeQuery(query1);
                    while(resultSet.next()) {
                    	id = resultSet.getInt("cstmid");
                    }
                    id+=1;
                    String query2 = "update numberkeys set cstmid =  '"+id +"' where slno = 1";
                    statement.executeUpdate(query2);
                    System.out.println("Done updating Customerid");
                }
                catch(Exception e1) {
                	
                }
                
                
                try {
                	Class.forName("com.mysql.jdbc.Driver");  
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
                    System.out.println("Connection made");
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from users where name=? and password=?");
                    Statement stmt = null;
                    System.out.println("Inserting into DB---Table Customer");
                    stmt = connection.createStatement();

                    String query = " insert into customer (customerid,cname,phonenumber,age,address,numberofpuchases)" + " values (?, ?, ?,?,?,?)";

                    PreparedStatement preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setInt(1, id);
                    preparedStmt.setString(2, Name);
                    preparedStmt.setString(3, phone_number);
                    preparedStmt.setInt(4, Age);
                    preparedStmt.setString(5, address);
                    preparedStmt.setInt(6, 0);
                    preparedStmt.execute();
                    flag = true;
                    
                    if (flag) {                         
                        dispose();
                        CustomerHomePage ah = new CustomerHomePage(username);
                        ah.setTitle("Home Page----"+username);
                        ah.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        flag = true;
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "User Name already exists");
                    }
                    if(flag) {
                   	 String query2 = "insert into customerlogin (customerid,username,password)" + "values(?,?,?)";
                     PreparedStatement preparedStmt2 = connection.prepareStatement(query2);
                     preparedStmt2.setInt(1, id);
                     preparedStmt2.setString(2, username);
                     preparedStmt2.setString(3, password);
                     preparedStmt2.execute();
                    }
                } 
                	catch (SQLException | ClassNotFoundException sqlException) {
                    sqlException.printStackTrace();
                }

        	}
        });
        btnNewButton.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
        btnNewButton.setBackground(new Color(0, 120, 215));
        btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 28));
        btnNewButton.setBounds(480, 449, 162, 73);
        
        contentPane.add(btnNewButton);
        
        lblAlreadyRegistered = new JLabel("Already Registered? ");
        lblAlreadyRegistered.setForeground(new Color(240, 255, 240));
        lblAlreadyRegistered.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblAlreadyRegistered.setBackground(new Color(240, 255, 240));
        lblAlreadyRegistered.setBounds(269, 585, 259, 52);
        contentPane.add(lblAlreadyRegistered);
        
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CustomerLogin obj = new CustomerLogin();
                obj.setTitle("Customer Login");
                obj.setVisible(true);
        	}
        });
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\login1.jpg"));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        btnNewButton_1.setBounds(569, 578, 213, 59);
        contentPane.add(btnNewButton_1);
        
            
    }
}