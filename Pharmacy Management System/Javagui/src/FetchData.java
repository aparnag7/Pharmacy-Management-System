import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
 
public class FetchData implements ActionListener {
 
    JFrame frame1;//creating object of first JFrame
    JLabel nameLabel;//creating object of JLabel
    JTextField nameTextField;//creating object of JTextfield
    JButton fetchButton;//creating object of JButton
    JButton resetButton;//creating object of JButton
    
    JFrame frame2;//creating object of second JFrame
    DefaultTableModel defaultTableModel;//creating object of DefaultTableModel
    JTable table;//Creating object of JTable
    Connection connection;//Creating object of Connection class
    Statement statement;//Creating object of Statement class
    int flag=0;
    
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
 
    FetchData() throws IOException {
 
        frame1 = new JFrame();
        frame1.setTitle("Search Drugs");//setting the title of first JFrame
        BackgroundPane background = new BackgroundPane();
		background.setBackground(ImageIO.read(new File("C:\\\\Users\\\\hp\\\\Desktop\\\\SEM-6\\\\javaswing\\\\images\\\\bg3.jpeg")));
        GridBagLayout bagLayout = new GridBagLayout();//creating object of GridBagLayout
        GridBagConstraints bagConstraints = new GridBagConstraints();//creating object of GridBagConstratints
        frame1.setSize(650, 300);//setting the size of first JFrame
        frame1.setLayout(bagLayout);//setting the layout to GridBagLayout of first JFrame
 
        bagConstraints.insets = new Insets(15, 40, 0, 0);//Setting the padding between the components and neighboring components
        JLabel lblAddDrugs = new JLabel("Search Drugs");
        lblAddDrugs.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblAddDrugs.setBounds(300, 100, 350, 100);
        lblAddDrugs.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\search.jpg"));
        lblAddDrugs.setAlignmentX(0);
        frame1.add(lblAddDrugs);
        
        nameLabel = new JLabel("Enter Drug Name");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 15;
        frame1.add(nameLabel, bagConstraints);
 
        nameTextField = new JTextField(15);
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 15;
        frame1.add(nameTextField, bagConstraints);
 
        fetchButton = new JButton("Fetch Drugs");
        fetchButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\products.jpg"));
        fetchButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        bagConstraints.gridx = 0;
        bagConstraints.gridy = 30;
        bagConstraints.ipadx = 60;
        frame1.add(fetchButton, bagConstraints);
 
        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        resetButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\reset2.jpg"));
        bagConstraints.gridx = 1;
        bagConstraints.gridy = 30;
        frame1.add(resetButton, bagConstraints);
 
        fetchButton.addActionListener(this);
        resetButton.addActionListener(this);
 
        
        frame1.setVisible(true);
        frame1.validate();
        
 
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if (e.getSource() == fetchButton) {
 
            String userName = nameTextField.getText().toString();//getting text of username text field and storing it in a String variable
            frameSecond(userName);//passing the text value to frameSecond method
 
        }
        if (e.getSource() == resetButton) {
            nameTextField.setText("");//resetting the value of username text field
        }
 
    }
 
 
    public void frameSecond(String userName) {
    
     //setting the properties of second JFrame
        frame2 = new JFrame("Database Results");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);
 
        //Setting the properties of JTable and DefaultTableModel
        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        table.setFillsViewportHeight(true);
        frame2.add(new JScrollPane(table));
        defaultTableModel.addColumn("Drug Name");
        defaultTableModel.addColumn("Doseage");
        defaultTableModel.addColumn("MRP");
        defaultTableModel.addColumn("Expiry Date");
        
 
 
 
        try {
        
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");//Crating connection with database
            statement = connection.createStatement();//crating statement object
            String query = "select * from drugs where drugname = '" + userName +"'";//Storing MySQL query in A string variable
            ResultSet resultSet = statement.executeQuery(query);//executing query and storing result in ResultSet
            
            boolean flag1 = false;
            boolean flag2 = false;
            while (resultSet.next()) {
            
             //Retrieving details from the database and storing it in the String variables
                String drugname = resultSet.getString("drugname");
                Double doseage = resultSet.getDouble("dose");
                Double Price = resultSet.getDouble("sprice");
                Date ExpiryDate = resultSet.getDate("expirydate");
                if (userName.equalsIgnoreCase(drugname)) {
                    flag1 = true;
                    defaultTableModel.addRow(new Object[]{drugname, doseage, Price, ExpiryDate});//Adding row in Table              
                }                
            }
            
            String query2 = "select * from drugs where company = '" + userName +"'";//Storing MySQL query in A string variable
            ResultSet resultSet2 = statement.executeQuery(query2);//executing query and storing result in ResultSet
            
 
            while (resultSet2.next()) {            
                String drugname = resultSet2.getString("drugname");
                Double doseage = resultSet2.getDouble("dose");
                Double Price = resultSet2.getDouble("sprice");
                Date ExpiryDate = resultSet2.getDate("expirydate");
                String company = resultSet2.getString("company");
                if (userName.equalsIgnoreCase(company)) {
                    flag2 = true;
                    defaultTableModel.addRow(new Object[]{drugname, doseage, Price, ExpiryDate});//Adding row in Table                                      
                }                
            }           
                        
            if (flag2 == false && flag1 == false) {
                JOptionPane.showMessageDialog(null, "No Such Drug Found");//When invalid keyword is entered
            }
            else {
            	frame2.setVisible(true);
                frame2.validate();
            }
 
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
 
 
    }
}