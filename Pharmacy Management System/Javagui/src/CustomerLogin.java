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

public class CustomerLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField4;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private JFrame frame;
    private JLabel lblAlreadyRegistered;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerLogin frame = new CustomerLogin();
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
    public CustomerLogin() {
    	setTitle("Customer Login");
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
           
        JLabel lblNewLabel = new JLabel("Customer Login");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\addnewuser.jpg"));
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 46));
        lblNewLabel.setBounds(356, 21, 510, 93);
        contentPane.add(lblNewLabel);

        passwordField = new JPasswordField();
        passwordField.setForeground(new Color(0, 0, 128));
        passwordField.setBackground(new Color(224, 255, 255));
        passwordField.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        passwordField.setBounds(619, 281, 176, 52);
        contentPane.add(passwordField);
        
        textField4 = new JTextField();
        textField4.setForeground(new Color(25, 25, 112));
        textField4.setBackground(new Color(224, 255, 255));
        textField4.setFont(new Font("Sitka Display", Font.PLAIN, 32));
        textField4.setBounds(619, 175, 176, 52);
        contentPane.add(textField4);
        textField4.setColumns(10);

        
        //username
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(new Color(240, 255, 240));
        lblUsername.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblUsername.setBounds(383, 179, 193, 52);
        contentPane.add(lblUsername);
        //password
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(240, 255, 240));
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblPassword.setBounds(383, 281, 193, 52);
        contentPane.add(lblPassword);
        
        
        
        btnNewButton =  new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {       		
        		 CustomerRegister cr ;
					try {
						cr = new  CustomerRegister();
						cr.setVisible(true);
					} 
					finally {
						
					}

        	}
        });
        btnNewButton.setForeground(new Color(240, 255, 240));
        btnNewButton.setBackground(new Color(0, 0, 128));
        btnNewButton.setFont(new Font("Sitka Heading", Font.BOLD, 28));
        btnNewButton.setBounds(538, 516, 162, 73);
        
        contentPane.add(btnNewButton);
        
        lblAlreadyRegistered = new JLabel("New Customer?");
        lblAlreadyRegistered.setForeground(new Color(240, 255, 240));
        lblAlreadyRegistered.setFont(new Font("Sitka Display", Font.PLAIN, 31));
        lblAlreadyRegistered.setBackground(new Color(240, 255, 240));
        lblAlreadyRegistered.setBounds(269, 526, 259, 52);
        contentPane.add(lblAlreadyRegistered);
        
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.setForeground(new Color(240, 255, 240));
        btnNewButton_1.setBackground(new Color(0, 0, 128));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			String userName = textField4.getText();
        			String password = passwordField.getText();        			
        			try {
                    	Class.forName("com.mysql.jdbc.Driver");  
                        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
                        System.out.println("Connection made");
                        PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select username, password from customerlogin where username=? and password=?");
                        st.setString(1, userName);
                        st.setString(2, password);
                        ResultSet rs = st.executeQuery();
                        if (rs.next()) {
                            dispose();
                            CustomerHomePage ah = new CustomerHomePage(userName);
                            ah.setTitle("Welcome");
                            ah.setVisible(true);
                            JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                        } else {
                            JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                        }
                    } catch (SQLException | ClassNotFoundException sqlException) {
                        sqlException.printStackTrace();
                    }
                }        		
        });
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\login1.jpg"));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        btnNewButton_1.setBounds(493, 380, 213, 59);
        contentPane.add(btnNewButton_1);
    
    }
}