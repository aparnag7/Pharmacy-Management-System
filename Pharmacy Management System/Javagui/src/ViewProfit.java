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
import com.toedter.calendar.JMonthChooser;


/*Display profit by day,month,year
 * By Company
 * By salesman
 * */
public class ViewProfit extends JFrame{
	JPanel panel;
	private JPanel contentPane;
	private JTextField profitMade;
	Double profit_obtained=0.0;
	String dateofsales = null;
	int month_number = 0;
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

	public ViewProfit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\profit.jpg"));
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(250, 128, 114));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblAddDrugs = new JLabel("View Profits");
        lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\profit.jpg"));
        lblAddDrugs.setForeground(new Color(240, 255, 240));
        lblAddDrugs.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
        lblAddDrugs.setBounds(362, 52, 325, 50);
        contentPane.add(lblAddDrugs);
        
        JLabel lblNewLabel = new JLabel("Select Criterion");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblNewLabel.setForeground(new Color(240, 255, 240));
        lblNewLabel.setBounds(409, 126, 156, 41);
        contentPane.add(lblNewLabel);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Given Date");
        rdbtnNewRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        rdbtnNewRadioButton.setBounds(97, 189, 139, 41);
        contentPane.add(rdbtnNewRadioButton);
        
        JDateChooser PickDate = new JDateChooser();
        PickDate.setBounds(280, 189, 161, 35);
        contentPane.add(PickDate);
        // PickDate.getDate()
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(786, 183, 124, 41);
        contentPane.add(comboBox);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("By Company");
        rdbtnNewRadioButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        rdbtnNewRadioButton_1.setBounds(572, 183, 149, 41);
        contentPane.add(rdbtnNewRadioButton_1);
        
        profitMade = new JTextField();
        profitMade.setBounds(428, 371, 187, 50);
        contentPane.add(profitMade);
        profitMade.setColumns(10);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Given Month");
        rdbtnNewRadioButton_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
        rdbtnNewRadioButton_2.setBounds(101, 268, 111, 23);
        contentPane.add(rdbtnNewRadioButton_2);
        
        JMonthChooser monthChooser = new JMonthChooser();
        monthChooser.setBounds(261, 245, 100, 50);
        contentPane.add(monthChooser);
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_1);
        G.add(rdbtnNewRadioButton_2);
        
        JButton btnNewButton = new JButton("View Profits");
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\profit2.jpg"));
        btnNewButton.setBounds(176, 371, 200, 50);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.setSelectedIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\reset2.jpg"));
        btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		profit_obtained = 0.0;
        		comboBox.removeAllItems();
        		G.clearSelection();
        		PickDate.setDate(null);
        		profitMade.setText("");
        		monthChooser.setMonth(0);
        	}
        });
        btnNewButton_1.setBounds(683, 371, 200, 50);
        contentPane.add(btnNewButton_1);
      
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
						Statement statement = connection.createStatement();
						
						//get profits from Order History 
						if(rdbtnNewRadioButton.isSelected()) {
							
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
							dateofsales = sdf1.format(PickDate.getDate());
							String query = "select * from saleshistory where dateofsales  = '" +dateofsales+"'";
		              		ResultSet resultSet = statement.executeQuery(query);
		              		while(resultSet.next()) {
		              			double profit = resultSet.getDouble("profit");
		              			double quantity = resultSet.getDouble("quantity");
		              			profit_obtained += (profit*quantity);
		              		}
		              		System.out.println("Profit: " + profit_obtained);
		              		profitMade.setText(profit_obtained+"");
		              		
						}
						else if(rdbtnNewRadioButton_1.isSelected()) {
							//get selection of comboBox
							//where all company name is selected item. Add to profit variable
							String company_name = (String) comboBox.getSelectedItem();
							String query = "select * from saleshistory where company = '" +company_name+"'";
							ResultSet resultSet = statement.executeQuery(query);
		              		while(resultSet.next()) {
		              			double profit = resultSet.getDouble("profit"); 
		              			double quantity = resultSet.getDouble("quantity");
		              			profit_obtained += (profit*quantity);
		              		}
		              		System.out.println("Profit: " + profit_obtained);
		              		profitMade.setText(profit_obtained+"");
							
						}
						else if(rdbtnNewRadioButton_2.isSelected()) {
								
								System.out.println(monthChooser.getMonth());
								int mth = monthChooser.getMonth();
								String query = "select * from saleshistory";
								ResultSet resultSet = statement.executeQuery(query);
								while(resultSet.next()) {
									String date = resultSet.getString("dateofsales");
									java.sql.Date dat = java.sql.Date.valueOf(date);
									Calendar cal = Calendar.getInstance();
									cal.setTime(dat);
									int month = cal.get(Calendar.MONTH);
									if(month == mth) {
										double profit = resultSet.getDouble("profit"); 
										double quantity = resultSet.getDouble("quantity");
				              			profit_obtained += (profit*quantity);
									}
								}
								System.out.println("Profit: " + profit_obtained);
			              		profitMade.setText(profit_obtained+"");
						}
						
            		 }
					
					catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        	}
        	});
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		comboBox.removeAllItems();
        		profitMade.setText("");
        	}
        }
        		);
        
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			PickDate.setDate(null);
        			profitMade.setText("");
        			Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					Statement statement = connection.createStatement();
					String query = "select * from saleshistory";
              		ResultSet resultSet = statement.executeQuery(query);
              		while (resultSet.next()) {
              		String company_name = resultSet.getString("company");
              		System.out.println(company_name);
              		comboBox.addItem(company_name);
              		
              		}
        		}
        		catch(Exception e1) {
        			
        		}
        	}
        }
        );
        	

	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}