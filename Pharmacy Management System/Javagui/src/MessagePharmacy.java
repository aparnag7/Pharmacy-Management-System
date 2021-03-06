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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

public class MessagePharmacy extends JFrame{
	JPanel panel;
	private JPanel contentPane;
	private JTextField message;
	int msg_id = 0;
	int emp_id=0;
	int receiver_id = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public MessagePharmacy(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\msg1.jpg"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(102, 153, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);   

        JLabel lblAddDrugs = new JLabel("Message  Pharmacy");
        lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\msg1.jpg"));
        lblAddDrugs.setForeground(new Color(240, 255, 240));
        lblAddDrugs.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
        lblAddDrugs.setBounds(224, 59, 593, 50);
        contentPane.add(lblAddDrugs);
        
        message = new JTextField();
        message.setFont(new Font("Sitka Display", Font.PLAIN, 20));
        message.setBounds(437, 223, 508, 149);
        contentPane.add(message);
        message.setColumns(10);
        
        JLabel lblEnterMessage = new JLabel("Enter Message");
        lblEnterMessage.setForeground(new Color(240, 255, 240));
        lblEnterMessage.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        lblEnterMessage.setBounds(70, 252, 325, 50);
        contentPane.add(lblEnterMessage);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			
			String query = "select * from customerlogin  where username= '"+username+"'"  ;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
      			emp_id = resultSet.getInt("customerid");
      		}
			System.out.println(emp_id);
        }
        catch(Exception e1) {
        	e1.printStackTrace();
        }
        
        JButton btnNewButton = new JButton("Send");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\send1.jpg"));
        btnNewButton.setBackground(new Color(255, 255, 204));
        btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
        btnNewButton.setForeground(new Color(0, 206, 209));
        btnNewButton.setBounds(362, 442, 200, 50);
        contentPane.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                	Class.forName("com.mysql.jdbc.Driver");
        			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
        			Statement statement = connection.createStatement();
        			
        			String query = "select * from numberkeys where slno = 1";
        			ResultSet resultSet = statement.executeQuery(query);
        			while(resultSet.next()) {
              			msg_id = resultSet.getInt("msgid");
              		}
        			System.out.println(msg_id);
        			msg_id+=1;
                }
                catch(Exception e1) {
                	e1.printStackTrace();
                }
        		
        		try {
                	Class.forName("com.mysql.jdbc.Driver");
        			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
        			Statement statement = connection.createStatement();
        			
        			String query1 = "insert into customermsgs (msgid,customerid,message,timestamp)" + "values(?,?,?,?)";
        			PreparedStatement preparedStmt = connection.prepareStatement(query1);
                    preparedStmt.setInt(1, msg_id);
                    preparedStmt.setInt(2, emp_id);                   
                    preparedStmt.setString(3,message.getText());
                    Calendar calendar = Calendar.getInstance();            
                    preparedStmt.setTimestamp(4,new java.sql.Timestamp(new java.util.Date().getTime())); //CURRENT DATE AND TIME 
                    preparedStmt.execute();
                    System.out.print("Entered");
                    JOptionPane.showMessageDialog(null, "Message Sent Successfully");
        			String query2 = "update numberkeys set msgid =  '"+msg_id +"' where slno = 1";
                    statement.executeUpdate(query2);
                    System.out.println("Done updating msgid");
                    System.out.println(msg_id);
                }
                catch(Exception e1) {
                	e1.printStackTrace();
                }
        	}
        });
	}
}
