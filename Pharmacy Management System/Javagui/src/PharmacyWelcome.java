import java.awt.EventQueue;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import java.awt.ScrollPane;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.MutableComboBoxModel;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTree;
import javax.swing.DefaultComboBoxModel;
public class PharmacyWelcome extends JFrame{
	private JPanel contentPane;
    private JFrame frame;
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PharmacyWelcome frame = new PharmacyWelcome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	PharmacyWelcome() {
		setTitle("Pharmacy Welcome Page");
		getContentPane().setBackground(new Color(0, 206, 209));
		setForeground(new Color(72, 209, 204));
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\register.jpg"));
    	setBackground(new Color(72, 209, 204));
    	setVisible(true);
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1095, 753);
        setResizable(true);
        contentPane = new JPanel(); 
        contentPane.setForeground(new Color(72, 209, 204));
        contentPane.setBackground(new Color(72, 209, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Pharmacy");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 59));
        lblNewLabel.setForeground(new Color(240, 255, 240));
        lblNewLabel.setBounds(489, 55, 328, 79);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Employee");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		WelcomePage obj = new WelcomePage();
                obj.setVisible(true);

        	}
        });
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\emp1.png"));
        btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
        btnNewButton.setBounds(192, 279, 388, 220);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("      Customer");
        btnNewButton_1.setBackground(new Color(255, 250, 250));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\cust2.jpg"));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CustomerLogin obj = new CustomerLogin();
                obj.setTitle("Customer Login");
                obj.setVisible(true);
        	}
        });
        btnNewButton_1.setBounds(661, 279, 381, 228);
        contentPane.add(btnNewButton_1);
        
        JLabel lblSelectProfileType = new JLabel("Select Profile Type");
        lblSelectProfileType.setForeground(new Color(240, 255, 240));
        lblSelectProfileType.setFont(new Font("Trebuchet MS", Font.BOLD, 45));
        lblSelectProfileType.setBounds(437, 168, 417, 79);
        contentPane.add(lblSelectProfileType);
	}
}
