import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Insets;
import javax.swing.JTabbedPane;

class Drugs {
	int drugid = 0;
	String drug_name = null;
	String drug_company = null;
	double dosage = 0.0;
	Date expdate = null;
	
	Drugs(int drugid, String drug_name, String drug_company, double dosage ,  Date expdate) {
		this.drugid = drugid;
		this.drug_name = drug_name;
		this.drug_company = drug_company;
		this.dosage = dosage;
		this.expdate = expdate;				
	}
	
}

public class SearchDrug extends JFrame{
//this should have a textbox to get drug name as input.
	ArrayList<Drugs> drugs_arr;	
	JFrame f;
    JLabel lblDrugName;
    JTextField CostPrice_text;
    JButton submit, cancel;
    private JPanel contentPane;
    private JTextField Drugname;
    private JTextField CompanyName;
    private JTextField drugname;
    JFrame frame2;
    DefaultTableModel defaultTableModel;
    JTable table;
    Connection connection;
    Statement statement;
    
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
	
	public SearchDrug() {
		setAlwaysOnTop(true);
		//f=new JFrame();    
		drugs_arr= new ArrayList<Drugs>();	
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\products.jpg"));
        setBounds(450, 190, 707, 319);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAddDrugs = new JLabel("Search Drugs");
        lblAddDrugs.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblAddDrugs.setBounds(253, 43, 325, 50);
        contentPane.add(lblAddDrugs);
        
        JLabel lblNewLabel = new JLabel("Enter a drug name or Company");
        lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 20));
        lblNewLabel.setBounds(41, 124, 307, 63);
        contentPane.add(lblNewLabel);
        
        drugname = new JTextField();
        drugname.setBounds(460, 133, 191, 42);
        contentPane.add(drugname);
        drugname.setColumns(10);
        String dn = drugname.getText();
        JButton searchdrug = new JButton("Search Drug");
        searchdrug.setFont(new Font("Times New Roman", Font.BOLD, 26));
        System.out.println(dn);
        
        searchdrug.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Search Drug");
        		
        		 try {
        		        
        	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
        	            statement = connection.createStatement();
        	            String query = "select * from drugs where drugname = '" + dn+"'";
        	            ResultSet resultSet = statement.executeQuery(query);
        	            
        	            boolean flag1 = false;
        	            boolean flag2 = false;
        	            while (resultSet.next()) {        	                    	            
        	            	int drugid = resultSet.getInt("iddrugs");
        	                String drugname = resultSet.getString("drugname");
        	                String company = resultSet.getString("company");
        	                Double doseage = resultSet.getDouble("dose");
        	                Double Price = resultSet.getDouble("sprice");
        	                Date ExpiryDate = resultSet.getDate("expirydate");
        	                if (dn.equalsIgnoreCase(drugname)) {
        	                    flag1 = true;
        	                    Drugs d = new Drugs(drugid,drugname,company,doseage,ExpiryDate);
        	                    drugs_arr.add(d);             
        	                }                
        	            }
        	            
        	            String query2 = "select * from drugs where company = '" + dn +"'";
        	            ResultSet resultSet2 = statement.executeQuery(query2);
        	            
        	 
        	            while (resultSet2.next()) {  
        	            	System.out.println("RS2");
        	            	int drugid = resultSet2.getInt("iddrugs");
        	                String drugname = resultSet2.getString("drugname");
        	                Double doseage = resultSet2.getDouble("dose");
        	                Double Price = resultSet2.getDouble("sprice");
        	                Date ExpiryDate = resultSet2.getDate("expirydate");
        	                String company = resultSet2.getString("company");
        	                if (dn.equalsIgnoreCase(company)) {
        	                    flag2 = true;
        	                    System.out.println("F2");
        	                    Drugs d = new Drugs(drugid,drugname,company,doseage,ExpiryDate);
        	                    drugs_arr.add(d);             	                                                
        	                }                
        	            }           
        	            if (flag2 == false && flag1 == false) {
        	                JOptionPane.showMessageDialog(null, "No Such Drug Found");
        	            }
        	            else {
        	            	display_drugs();
        	            }
        	 
        	        } catch (SQLException throwables) {
        	            throwables.printStackTrace();
        	        }
        	 
        		
        		
        	}
        });
        searchdrug.setBounds(292, 207, 191, 50);
        contentPane.add(searchdrug);
        //conditions to check
        //get name in textbox print anything that match
        String column[]={"Drug Name", "Type" , "Selling Price"};
                
	}
	void display_drugs() {
    	JFrame frame2 = new JFrame("Search Results");
        frame2.getContentPane().setLayout(new FlowLayout());
        frame2.setSize(400, 400);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        JTable table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.getContentPane().add(new JScrollPane(table));
        defaultTableModel.addColumn("Drug id");
        defaultTableModel.addColumn("Drug Name");
        defaultTableModel.addColumn("Drug Company");
        defaultTableModel.addColumn("Quantity"); 
        defaultTableModel.addColumn("Expiry Date");
        for(int i=0;i<drugs_arr.size();i++) {
        	int id = drugs_arr.get(i).drugid;
        	String drugname = drugs_arr.get(i).drug_name;
        	String drugcompany = drugs_arr.get(i).drug_company;
        	double doseage = drugs_arr.get(i).dosage;
        	Date expdate = drugs_arr.get(i).expdate;
        	defaultTableModel.addRow(new Object[]{id,drugname,drugcompany,doseage,expdate});
        }        
        frame2.setVisible(true);
        frame2.validate();
    }
	
	
}
