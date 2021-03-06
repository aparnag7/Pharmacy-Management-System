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

//create new class to store objects

public class GenerateBill extends JFrame {

    private static final long serialVersionUID = 1L;
    Customer bought;
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField CostPrice_text;
    JPasswordField password_text;
    JButton submit, cancel;
    double grand_total=0;
    boolean bill_flag = true;
    int productid = 0;
    //private JPanel contentPane;
    String productName = null;
  //  int product_id = 0;
    Date date = null;
    double cp =0;
    double sp =0;
    int id = 0;
    int quanty = 0;
    double doseage= 0;
    int drugid = 0;
    int c_id;
    String c_name;
    int no_of_purchases;
    boolean discount_given = false;
    ArrayList<GenerateBill> productsAdded;
    ArrayList<GenerateBill> productsBought;
    ArrayList<Customer> customers;
    GenerateBill(int id ,int drugid, String productName, double cp, double sp,int quanty,double doseage) {
    	this.id = id;
    	this.drugid = drugid;
    	this.productName = productName;
    	this.cp = cp;
    	this.sp = sp;
    	this.quanty = quanty;
    	this.doseage = doseage;
    }
    
  
    
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

    int inc(int x) {
    	return x+=1;
    }
    public GenerateBill() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Downloads\\profit.jpg"));
    	  productsAdded = new ArrayList<GenerateBill>(); 
//    	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(450, 190, 1378, 731);
          setResizable(true);
          JPanel contentPane = new JPanel();
          contentPane.setBackground(new Color(250, 128, 114));
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);
          
          JLabel lblAddDrugs = new JLabel("Generate Bill");
          lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\bill.jpg"));
          lblAddDrugs.setForeground(new Color(240, 255, 240));
          lblAddDrugs.setFont(new Font("Trebuchet MS", Font.BOLD, 42));
          lblAddDrugs.setBounds(519, 36, 325, 50);
          contentPane.add(lblAddDrugs);
          
          JLabel lblCompany = new JLabel("Drug name");
          lblCompany.setForeground(new Color(240, 255, 240));
          lblCompany.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblCompany.setBounds(746, 194, 150, 29);
          contentPane.add(lblCompany);

          JLabel lblSellPrice = new JLabel("Selling Price");
          lblSellPrice.setForeground(new Color(240, 255, 240));
          lblSellPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblSellPrice.setBounds(750, 307, 166, 44);
          contentPane.add(lblSellPrice);
          
          JLabel lblNewLabel = new JLabel("Drug Type");
          lblNewLabel.setForeground(new Color(240, 255, 240));
          lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblNewLabel.setBounds(93, 196, 117, 25);
          contentPane.add(lblNewLabel);
          
          JDateChooser manDate = new JDateChooser();
          manDate.setBounds(943, 395, 217, 20);
          contentPane.add(manDate);
          
          JLabel lblNewLabel_1 = new JLabel("Date");
          lblNewLabel_1.setForeground(new Color(240, 255, 240));
          lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
          lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblNewLabel_1.setBounds(786, 372, 198, 43);
          contentPane.add(lblNewLabel_1);
          
          JLabel lblNewLabel_2 = new JLabel("Doseage/Weight");
          lblNewLabel_2.setForeground(new Color(240, 255, 240));
          lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblNewLabel_2.setBounds(93, 313, 222, 32);
          contentPane.add(lblNewLabel_2);
                  
          JTextField SellingPrice = new JTextField();
          SellingPrice.setEditable(false);
          SellingPrice.setFont(new Font("Trebuchet MS", Font.PLAIN, 32));
          SellingPrice.setBounds(943, 302, 249, 50);
          contentPane.add(SellingPrice);
          SellingPrice.setColumns(10);
          
          JRadioButton rdbtnNewRadioButton = new JRadioButton("Tablet");
          rdbtnNewRadioButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
          rdbtnNewRadioButton.setBounds(225, 196, 111, 23);
          contentPane.add(rdbtnNewRadioButton);
          
          JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Injection Fluid");
          rdbtnNewRadioButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
          rdbtnNewRadioButton_1.setBounds(371, 193, 117, 24);
          contentPane.add(rdbtnNewRadioButton_1);
          
          JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Syrup");
          rdbtnNewRadioButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
          rdbtnNewRadioButton_2.setBounds(519, 194, 111, 23);
          contentPane.add(rdbtnNewRadioButton_2);
          
          JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Cream");
          rdbtnNewRadioButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
          rdbtnNewRadioButton_3.setBounds(225, 245, 117, 23);
          contentPane.add(rdbtnNewRadioButton_3);

          JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Masks");
          rdbtnNewRadioButton_4.setFont(new Font("Verdana", Font.PLAIN, 14));
          rdbtnNewRadioButton_4.setBounds(371, 244, 111, 23);
          contentPane.add(rdbtnNewRadioButton_4);
          
          JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Other Products");
          rdbtnNewRadioButton_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
          rdbtnNewRadioButton_5.setBounds(519, 245, 117, 23);
          contentPane.add(rdbtnNewRadioButton_5);
          
          ButtonGroup G = new ButtonGroup();
          G.add(rdbtnNewRadioButton);
          G.add(rdbtnNewRadioButton_1);
          G.add(rdbtnNewRadioButton_2);
          G.add(rdbtnNewRadioButton_3);
          G.add(rdbtnNewRadioButton_4);
          G.add(rdbtnNewRadioButton_5);
          JSpinner quantity = new JSpinner();
          quantity.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
          quantity.setBounds(355, 372, 228, 20);
          contentPane.add(quantity);
          
          JLabel Quantity = new JLabel("Maximum Quantity");
          Quantity.setForeground(new Color(240, 255, 240));
          Quantity.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          Quantity.setBounds(93, 365, 222, 32);
          contentPane.add(Quantity);
          
          JComboBox comboBox = new JComboBox();
          comboBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
          comboBox.setMaximumRowCount(2);
          comboBox.setEditable(true);
          comboBox.setModel(new DefaultComboBoxModel());
          comboBox.setBounds(943, 198, 208, 30);
          contentPane.add(comboBox); 
          customers = new ArrayList<Customer>();                
          
          JComboBox comboBox_2 = new JComboBox();
          comboBox_2.setBounds(371, 135, 207, 22);
          contentPane.add(comboBox_2);
          
          JLabel lblNewLabel_3 = new JLabel("Select Customer ID ");
          lblNewLabel_3.setForeground(new Color(240, 255, 240));
          lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblNewLabel_3.setBounds(93, 130, 238, 22);
          contentPane.add(lblNewLabel_3);
          
          try {
        	  //get all customers here 
        	  Class.forName("com.mysql.jdbc.Driver");
				Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
				Statement statement = connection.createStatement();
				String query = "select * from customer";
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()) {
					c_id = rs.getInt("customerid");
					c_name = rs.getString("cname");
					no_of_purchases = rs.getInt("numberofpuchases");
					Customer cs =  new Customer(c_id,c_name,no_of_purchases);
					customers.add(cs);				
					comboBox_2.addItem(c_id+"");
					System.out.println("---------------------");
				}
          }
          catch(Exception e) {
        	  System.out.println("---------ERROR------------");
        	  e.printStackTrace();
          }
          
          
          JButton btnNewButton_1 = new JButton("Generate Bill");
          btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\adddrugs.jpg"));
          btnNewButton_1.setForeground(new Color(112, 128, 144));
          btnNewButton_1.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		if(bill_flag==true) {
          			
          		}
          		
          		//delete these items in db
          			Double max_quantity=0.0; 
          			int drug_id=0;
          			String company =null;
          			for(int i=0;i<productsAdded.size();i++) {
          			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					Statement statement = connection.createStatement();
					System.out.println("Going to alter DB");
      				System.out.println(productsAdded.get(i).productName);
      				String query1 = "select * from drugs where drugname = '" + productsAdded.get(i).productName + "'";
      				ResultSet rs1 = statement.executeQuery(query1);
      				while(rs1.next()) {
      				drug_id = rs1.getInt("iddrugs"); 
      				company = rs1.getString("company");
      				max_quantity = rs1.getDouble("quantity");
      				System.out.println("Max quantity" + max_quantity);}
      				productsAdded.get(i).drugid = drug_id;
	            	}
				catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
          		 if(max_quantity == productsAdded.get(i).quanty) {
          			try {
          				//try deleting here
          				Class.forName("com.mysql.jdbc.Driver");
    					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    					Statement statement = connection.createStatement();
    					System.out.println("Going to alter DB");
          				System.out.println(productsAdded.get(i).productName);
          				String query2 = "delete from drugs where drugname = '" + productsAdded.get(i).productName + "'";
          				statement.executeUpdate(query2);
          				System.out.println("Deleted with drugid" + productsAdded.get(i).drugid);
          			}
          			catch (SQLException | ClassNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
          			}
          			}
          			else {
          				try {
          				System.out.println("Max quantity" + max_quantity);
          				double remaining = max_quantity - productsAdded.get(i).quanty;
          				Class.forName("com.mysql.jdbc.Driver");
    					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    					Statement statement = connection.createStatement();
    					System.out.println("Going to alter DB");
          				System.out.println(productsAdded.get(i).productName);
      
          				String query3 = "update drugs set quantity= '"+remaining +"' where drugname = '"+productsAdded.get(i).productName+"' and dose = '"+productsAdded.get(i).doseage+"' " ;
          				statement.executeUpdate(query3);
          				System.out.println("Done" + productsAdded.get(i).drugid);
          				}
          				catch (SQLException | ClassNotFoundException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
              			}
          			}
          		 
          		 	try {
          		 		String customerid = (String) comboBox_2.getSelectedItem();
          		 		c_id = Integer.parseInt(customerid);
          		 		bought = Customer.find_customer(c_id);
          		 		System.out.println("Customer: "+bought.number_of_purchases); 
          		 		Class.forName("com.mysql.jdbc.Driver");
    					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    					Statement statement = connection.createStatement();
    					System.out.println("Adding to sales history");
    					String query3 = "insert into saleshistory (iddrugs,drugname,company,quantity,profit,dose,dateofsales,customerid)" + "values (?,?,?,?,?,?,?,?)";
    					double flag = 0.0;
    					if(discount_given==true) {
    						flag=0.95;
    					}
    					else {
    						flag = 1.0;
    					}
    					 PreparedStatement preparedStmt = connection.prepareStatement(query3);
    	                    preparedStmt.setInt(1, drug_id);
    	                    preparedStmt.setString(2,productsAdded.get(i).productName);
    	                    preparedStmt.setString(3, company);
    	                    preparedStmt.setDouble(4, productsAdded.get(i).quanty);
    	                    preparedStmt.setDouble(5, (productsAdded.get(i).sp - productsAdded.get(i).cp)*flag); 
    	                    preparedStmt.setDouble(6, productsAdded.get(i).doseage);
    	                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    	            		String man_date = sdf1.format(manDate.getDate());
    	                    preparedStmt.setString(7,man_date);
    	                    preparedStmt.setInt(8, c_id);
    	                    preparedStmt.execute();
    	                    System.out.println("Inserted into saleshistory");
    	                    
    	                    //now add number of purchases for customer; 
    	                    bought.update_purchase();
    	                    System.out.println("Updated purchase count");    	                    
          		 	}       		 	
          		 	catch(Exception e2) {
          		 		System.out.println("Failed inserting into sales history");
          		 		e2.printStackTrace();
          		 	}
          		 	System.out.println("Number of purchases	"+bought.number_of_purchases);
          		 	if((bought.number_of_purchases%5)!=0) {
                  		JOptionPane.showMessageDialog(null, "Total Bill: " + grand_total);
                  		DisplayBill(grand_total);}
                  	else {
                  			//give 5% discount
                  			System.out.println("Discount given");
                  			grand_total = grand_total*0.95;
                  			discount_given = true;
                  			JOptionPane.showMessageDialog(null, "Total Bill after 5% discount: " + grand_total);
                  			DisplayBill(grand_total);
                  			
                  		}          		 	
          		}
          	}
          });
          btnNewButton_1.setBackground(Color.RED);
          btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          btnNewButton_1.setBounds(461, 540, 325, 50);
          contentPane.add(btnNewButton_1);
          
          JButton btnNewButton = new JButton("Add another item");
          btnNewButton.setBackground(Color.RED);
          btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\reset.jpg"));
          btnNewButton.setForeground(new Color(119, 136, 153));
          btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          JComboBox comboBox_1 = new JComboBox();
          comboBox_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
          comboBox_1.setMaximumRowCount(2);
          comboBox_1.setEditable(true);
          comboBox_1.setBounds(371, 311, 208, 30);
          contentPane.add(comboBox_1);
          
          rdbtnNewRadioButton.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
						Statement statement = connection.createStatement();
          			System.out.println("Drug Form in action");
              		String drug_type="";
              		drug_type="Tablet";
              		comboBox.removeAllItems();
            		comboBox_1.removeAllItems();
            		SellingPrice.setText("");
            		quantity.setValue(0);
              		String query = "select * from drugs where drugtype = '" + drug_type + "'";
              		ResultSet resultSet = statement.executeQuery(query);
              		while (resultSet.next()) {
              		String drug_name = resultSet.getString("drugname");
              		System.out.println(drug_name);
              		comboBox.addItem(drug_name);
              		 }
					}
					
					catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                   }
          });
          rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
  					try {
  						Class.forName("com.mysql.jdbc.Driver");
  						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
  						Statement statement = connection.createStatement();
            			System.out.println("Drug Form in action");
                		String drug_type="";
                		drug_type="Injection Fluid";
                		comboBox.removeAllItems();
                		comboBox_1.removeAllItems();
                		SellingPrice.setText("");
                		quantity.setValue(0);
                		
                		String query = "select * from drugs where drugtype = '" + drug_type + "'";
                		ResultSet resultSet = statement.executeQuery(query);
                		while (resultSet.next()) {
                		String drug_name = resultSet.getString("drugname");
                		System.out.println(drug_name);
                		comboBox.addItem(drug_name);
                		//System.out.println(productsAdded);
                		 }
  					}
  					
  					catch (SQLException | ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
                     }
            });
          rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
  					try {
  						Class.forName("com.mysql.jdbc.Driver");
  						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
  						Statement statement = connection.createStatement();
            			//System.out.println("Drug Form in action");
                		String drug_type="";
                		drug_type="Syrup";
                		comboBox.removeAllItems();
                		comboBox_1.removeAllItems();
                		SellingPrice.setText("");
                		quantity.setValue(0);
                		String query = "select * from drugs where drugtype = '" + drug_type + "'";
                		ResultSet resultSet = statement.executeQuery(query);
                		while (resultSet.next()) {
                		String drug_name = resultSet.getString("drugname");
                		//System.out.println(drug_name);
                		comboBox.addItem(drug_name);
                		}
  					}
  					
  					catch (SQLException | ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
                     }
            });
          rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
  					try {
  						Class.forName("com.mysql.jdbc.Driver");
  						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
  						Statement statement = connection.createStatement();            		
                		String drug_type="";
                		drug_type="Cream";
                		comboBox.removeAllItems();
                		comboBox_1.removeAllItems();
                		SellingPrice.setText("");
                		quantity.setValue(0);
                		String query = "select * from drugs where drugtype = '" + drug_type + "'";
                		ResultSet resultSet = statement.executeQuery(query);
                		while (resultSet.next()) {
                		String drug_name = resultSet.getString("drugname");
                		//System.out.println(drug_name);
                		comboBox.addItem(drug_name);
                		 }
  					}
  					
  					catch (SQLException | ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
                     }
            });
          
          rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
  					try {
  						Class.forName("com.mysql.jdbc.Driver");
  						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
  						Statement statement = connection.createStatement();
            			//System.out.println("Drug Form in action");
                		String drug_type="";
                		drug_type="Masks";
                		comboBox.removeAllItems();
                		comboBox_1.removeAllItems();
                		SellingPrice.setText("");
                		quantity.setValue(0);
                		String query = "select * from drugs where drugtype = '" + drug_type + "'";
                		ResultSet resultSet = statement.executeQuery(query);
                		while (resultSet.next()) {
                		String drug_name = resultSet.getString("drugname");
                		//System.out.println(drug_name);
                		comboBox.addItem(drug_name);
                		 }
  					}
  					
  					catch (SQLException | ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
                     }
            });
            
            rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
              	public void actionPerformed(ActionEvent e) {
    					try {
    						Class.forName("com.mysql.jdbc.Driver");
    						Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
    						Statement statement = connection.createStatement();
              			//System.out.println("Drug Form in action");
                  		String drug_type="";
                  		drug_type="Others";
                  		comboBox.removeAllItems();
                  		comboBox_1.removeAllItems();
                  		SellingPrice.setText("");
                  		quantity.setValue(0);
                  		String query = "select * from drugs where drugtype = '" + drug_type + "'";
                  		ResultSet resultSet = statement.executeQuery(query);
                  		while (resultSet.next()) {
                  		String drug_name = resultSet.getString("drugname");
                  		//System.out.println(drug_name);
                  		comboBox.addItem(drug_name);
                  		 }
    					}
    					
    					catch (SQLException | ClassNotFoundException e1) {
    						// TODO Auto-generated catch block
    						e1.printStackTrace();
    					}
                       }
              });
          
          
          btnNewButton.setBounds(702, 440, 346, 58);
          contentPane.add(btnNewButton);
          
          JButton btnNewButton_2 = new JButton("Next Customer");
          btnNewButton_2.setBackground(Color.RED);
          btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\l (1).jpg"));
          btnNewButton_2.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		//System.out.println("Date of sales: " + manDate.getDate());
          		grand_total=0;
          		G.clearSelection();
          		bill_flag = false;
      			comboBox.removeAllItems();
      			manDate.setDate(null);
        		comboBox_1.removeAllItems();
        		SellingPrice.setText("");
        		quantity.setValue(0);
        		grand_total=0;
        	    bill_flag = true;
        	    productid = 0;
        	    productName = null;
        	    cp =0;
        	    sp =0;
        	    id = 0;
        	    quanty = 0;
        	    doseage= 0;
        	    productsAdded.clear();
          	}
          });
          btnNewButton_2.setForeground(new Color(112, 128, 144));
          btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
          btnNewButton_2.setBounds(955, 571, 208, 58);
          contentPane.add(btnNewButton_2);
          
          JButton btnNewButton_3 = new JButton("Add to cart");
          btnNewButton_3.setBackground(Color.RED);
          btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\10 (2).jpg"));
          btnNewButton_3.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		String s_p = SellingPrice.getText();
          		Double sprice = Double.parseDouble(s_p);
          		Double qty = 0.0;
          		int q = (int) quantity.getValue();
          		qty = Double.valueOf(q);
          		grand_total += sprice*qty;
          		System.out.println(sprice +" "+ qty);
          		Double item_dose = (Double) comboBox_1.getSelectedItem();
          		String productName =(String) comboBox.getSelectedItem();
          		System.out.println("Added item: "+grand_total);
          		id+=1;
          		GenerateBill item = new GenerateBill(id,0,productName,cp,sprice,q,item_dose);
          		productsAdded.add(item); 
         		System.out.println(productsAdded.size());
          		for(int i=0;i<productsAdded.size();i++) {
                	System.out.println(productsAdded.get(i).id);
                	System.out.println(productsAdded.get(i).productName);
                }
          		
          		
          	}
          });
          btnNewButton_3.setForeground(new Color(119, 136, 153));
          btnNewButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
          btnNewButton_3.setBounds(223, 442, 298, 58);
          contentPane.add(btnNewButton_3);
          
         
          
          JLabel lblNewLabel_4 = new JLabel("New Customer? ");
          lblNewLabel_4.setForeground(new Color(240, 255, 240));
          lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
          lblNewLabel_4.setBounds(749, 133, 178, 20);
          contentPane.add(lblNewLabel_4);
          
          JButton btnNewButton_4 = new JButton("Register First");
          btnNewButton_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
          btnNewButton_4.setForeground(new Color(70, 130, 180));
          btnNewButton_4.setBounds(943, 135, 198, 23);
          contentPane.add(btnNewButton_4);
           
          btnNewButton_4.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			CustomerRegister cr  = new CustomerRegister();
        			cr.setVisible(true);
        		}
          });
         
                                 
        
          comboBox.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		String item = (String) comboBox.getSelectedItem();
          		try {
				    Class.forName("com.mysql.jdbc.Driver");
					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
					Statement statement = connection.createStatement();
					SellingPrice.setText("");
					comboBox_1.removeAllItems();
					quantity.setValue(0);
        			//System.out.println("Drug Form in action");
            		String query = "select * from drugs where drugname = '" + item + "'";
            		ResultSet resultSet = statement.executeQuery(query);
            		while (resultSet.next()) {
            		Double drug_dose = resultSet.getDouble("dose");
            		//System.out.println(drug_dose);
            		comboBox_1.addItem(drug_dose);
            		 }
					}					
					catch (SQLException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}          	
          	}
          });
          System.out.println(G.getSelection());
          comboBox_1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Double item_dose = (Double) comboBox_1.getSelectedItem();
            		String name = (String) comboBox.getSelectedItem();
            		try {
            		SellingPrice.setText("");
            		quantity.setValue(0);
  				    Class.forName("com.mysql.jdbc.Driver");
  					Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
  					Statement statement = connection.createStatement();
          			//System.out.println("Drug Form in action");
              		String query = "select * from drugs where drugname = '" + name + "' and dose = '" + item_dose + "' ";
              		ResultSet resultSet = statement.executeQuery(query);
              		while (resultSet.next()) {
              		productid = resultSet.getInt("iddrugs");
              		Double sellingprice = resultSet.getDouble("sprice");
              		int q = resultSet.getInt("quantity");
              		cp = resultSet.getDouble("cprice");
              		SellingPrice.setText(sellingprice+"");
              		quantity.setValue(q);
              		 }
  					}
  					
  					catch (SQLException | ClassNotFoundException e1) {
  						// TODO Auto-generated catch block
  						e1.printStackTrace();
  					}
            	
            	}
            });
          
          //reset button actionlistener
          btnNewButton.addActionListener(new ActionListener() {
      		public void actionPerformed(ActionEvent e) {
      			
      			G.clearSelection();
      			comboBox.removeAllItems();
      			//manDate.setDate(null);
        		comboBox_1.removeAllItems();
        		SellingPrice.setText("");
        		quantity.setValue(0);
          		
      		}
        });  
}
    void DisplayBill(Double total) {
    	JFrame frame2 = new JFrame("BILL");
        frame2.getContentPane().setLayout(new FlowLayout());
        frame2.setSize(400, 400);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        JTable table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.getContentPane().add(new JScrollPane(table));
        defaultTableModel.addColumn("SNo");
        defaultTableModel.addColumn("Drug Name");
        defaultTableModel.addColumn("Cost/item");
        defaultTableModel.addColumn("Quantity"); 
        defaultTableModel.addColumn("Total Cost");
        for(int i=0;i<productsAdded.size();i++) {
        	Double costp = productsAdded.get(i).cp;
        	Double sellp = productsAdded.get(i).sp;
        	int qt = productsAdded.get(i).quanty;
        	Double qty_temp = Double.valueOf(qt);
        	Double total_for_this = sellp * qty_temp;
        	defaultTableModel.addRow(new Object[]{productsAdded.get(i).id ,productsAdded.get(i).productName,productsAdded.get(i).sp , productsAdded.get(i).quanty,total_for_this});
        }
        System.out.println("Number of purchases" + bought.number_of_purchases);
        if(discount_given==true) { 
        	defaultTableModel.addRow(new Object[] {"You were given 5% off"});
        	defaultTableModel.addRow(new Object[] {"Original Bill : " , total/0.95});
        }
        defaultTableModel.addRow(new Object[] {"Total Bill : " , total});        
        frame2.setVisible(true);
        frame2.validate();
    }
}//end of class


// delete items only after generating bill 
// add the items in order history

