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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButtonMenuItem;


class Messge {
	int msgid = 0;
	int senderid = 0;
	int rcvrid = 0;
	String msg = null;
	String sender_name=null;
	Timestamp st;
	
	ArrayList<Message> msg_rcvd;
	public Messge (int msgid , String sender_name , int senderid, String msg,Timestamp st) {
		this.msgid = msgid;
		this.sender_name = sender_name;
		this.senderid = senderid;
		//this.rcvrid = rcvrid; //all are same then no need
		this.msg = msg;
		this.st = st;
	}
}


public class ViewMessages extends JFrame{
	JPanel panel;
	private JPanel contentPane;
	private JTextField message;
	int msg_id = 0;
	int emp_id=0;
	int receiver_id = 0;
	DefaultTableModel defaultTableModel;
    JTable table;
    String msg= null;
   
    
	ArrayList<ViewMessages> msgs_rcvd ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	String get_Name(int id) {
		
		try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			//get username id of this user here the person who received the message
			String query = "select * from users  where idusers= '"+id+"'"  ;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
					String username = resultSet.getString("name");
					return username;
      		}
			System.out.println(receiver_id);						
			
		}
        catch(Exception e1) {
        	e1.printStackTrace();
        }
		
		return "Aparna";
		
	}
	
	public 	ViewMessages(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\sending-message-icon-paper-plane-260nw-1727034376 (2).jpg"));
		Set<String> hash_Set = new HashSet<String>(); 
		ArrayList<Message> msg_rcvd = new ArrayList();
		System.out.println("Message " + msg_rcvd.size());
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1100, 650);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 153, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);   
        
        JLabel lblAddDrugs = new JLabel("View Messages from Pharmacy");
        lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\message-icon-mobile-phone-chat-260nw-1714040833 (2).jpg"));
        lblAddDrugs.setForeground(new Color(240, 255, 240));
        lblAddDrugs.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
        lblAddDrugs.setBounds(262, 93, 767, 147);
        contentPane.add(lblAddDrugs);
        
        JButton btnNewButton = new JButton("Reply Pharmacy");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MessagePharmacy mp = new MessagePharmacy(username);
        		mp.setVisible(true);
        		
        	}
        });
        btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        btnNewButton.setBounds(521, 330, 241, 64);
        contentPane.add(btnNewButton);
        
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			//get username id of this user here the person who received the message
			String query = "select * from customerlogin  where username= '"+username+"'"  ;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
					receiver_id = resultSet.getInt("customerid");
					System.out.println("------**********------");
      		}
			System.out.println(receiver_id);						
			
		}
        catch(Exception e1) {
        	e1.printStackTrace();
        }
        //store message items in an object
        try {
        	System.out.println("Displaying messages in console");
        	Class.forName("com.mysql.jdbc.Driver");
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
			Statement statement = connection.createStatement();
			String query = "select * from messages  where receiverid = '"+receiver_id+"'"  ;
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				int sender =  resultSet.getInt("senderid");
				int msgid = resultSet.getInt("msgid");
				String message = resultSet.getString("message");
				Timestamp st =  resultSet.getTimestamp("timestamp");
				String sendername = get_Name(sender);
				System.out.println(sender+" " +message +" " + st + " " + sendername);
				Message msg = new Message(msgid,sendername,sender,message,st);
				msg_rcvd.add(msg);
				hash_Set.add(sendername);
			}
       }
        catch(Exception e2) {
        	
        }
        for(int i=0;i<msg_rcvd.size();i++) {
			System.out.println(msg_rcvd.get(i));
		}
        
        //add to comboBox
      
        
        JFrame frame2 = new JFrame("Your messages");
        frame2.getContentPane().setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
        frame2.getContentPane().setLayout(new FlowLayout());
        //frame2.setSize(1023, 550);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        JTable table = new JTable(defaultTableModel);
        table.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        frame2.getContentPane().add(new JScrollPane(table));
        defaultTableModel.addColumn("Message id");
        defaultTableModel.addColumn("Sender");
        defaultTableModel.addColumn("Message");
        defaultTableModel.addColumn("Time Stamp"); 
        
        for(int i=0;i<msg_rcvd.size();i++) {        	
        	defaultTableModel.addRow(new Object[]{msg_rcvd.get(i).msgid ,msg_rcvd.get(i).sender_name ,msg_rcvd.get(i).msg , msg_rcvd.get(i).st});        	
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(250);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        frame2.setVisible(true);
        frame2.validate();
	}
	
	
	
	
	
}
