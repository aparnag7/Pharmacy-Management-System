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

	public class CustomerHomePage extends JFrame{

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    UserHome frame = new UserHome();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	    
	    public CustomerHomePage(String userSes) {
	    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(450, 190, 1216, 737);
	        setResizable(true);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(240, 128, 128));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        //logout
	        JButton btnNewButton = new JButton("Logout");
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\logout.jpg"));
	        btnNewButton.setForeground(new Color(0, 0, 0));
	        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
	                if (a == JOptionPane.YES_OPTION) {
	                    dispose();
	                    CustomerLogin obj = new CustomerLogin();
	                    obj.setTitle("Customer Login");
	                    obj.setVisible(true);
	                }
	                dispose();
	                CustomerLogin obj = new CustomerLogin();

	                obj.setTitle("Employee Login");
	                obj.setVisible(true);

	            }
	        });
	        btnNewButton.setBounds(446, 137, 550, 77);
	        contentPane.add(btnNewButton);
	        
	        //change password
	        JButton cpbutton = new JButton("Change Password\r\n");
	        cpbutton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\cp.jpg"));
	        cpbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        cpbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                ChangePassword bo = new ChangePassword(userSes,"customer");
	                bo.setTitle("Change Password");
	                bo.setVisible(true);
	            }
	        });
	        cpbutton.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	        cpbutton.setBounds(446, 261, 550, 77);
	        contentPane.add(cpbutton);
	        
	        //send messages
	        JButton Messagebutton = new JButton("Message Pharmacy");
	        Messagebutton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\send1.jpg"));
	        Messagebutton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        Messagebutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                MessagePharmacy sd ;
					try {
						sd = new MessagePharmacy(userSes);
						sd.setVisible(true);
					} 
					finally {
						
					}
	            }
	        });
	        Messagebutton.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	        Messagebutton.setBounds(446, 391, 550, 84);
	        contentPane.add(Messagebutton);
	        
	        //view messages 
	        JButton ViewMsgbutton = new JButton("View Messages\r\n from Pharmacy");
	        ViewMsgbutton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\msg1.jpg"));
	        ViewMsgbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
	        ViewMsgbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                ViewMessages sd ;
					try {
						sd = new ViewMessages(userSes);
						sd.setVisible(true);
					} 
					finally {
						
					}
	            }
	        });
	        ViewMsgbutton.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
	        ViewMsgbutton.setBounds(446, 521, 550, 84);
	        contentPane.add(ViewMsgbutton);
	        
	        JLabel lblNewLabel = new JLabel("Welcome ");
	        lblNewLabel.setForeground(new Color(0, 102, 153));
	        lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 52));
	        lblNewLabel.setBounds(584, 32, 250, 60);
	        contentPane.add(lblNewLabel);
	        
	    }
}
