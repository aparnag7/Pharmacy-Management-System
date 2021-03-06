import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Insets;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    
    public static void main(String[] args) {
        new UserLogin();
    }

       public UserLogin() {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                try {
                    BackgroundPane background = new BackgroundPane();
					background.setBackground(ImageIO.read(new File("C:\\\\Users\\\\hp\\\\Desktop\\\\SEM-6\\\\javaswing\\\\images\\\\bg3.jpeg")));
	                JFrame frame = new JFrame("Login Page");
	                frame.setBounds(1000,1000,786,555);
	                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                frame.setContentPane(background);
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{0.0};
        frame.getContentPane().setLayout(gridBagLayout);
        GridBagConstraints gbc_lblPharamacyManagementSystem = new GridBagConstraints();
        
        gbc_lblPharamacyManagementSystem.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc_lblPharamacyManagementSystem.gridwidth = GridBagConstraints.REMAINDER;
        JLabel lblPharamacyManagementSystem = new JLabel("Login");
        gbc_lblPharamacyManagementSystem.gridx = 1;
        gbc_lblPharamacyManagementSystem.gridy = -10;
        lblPharamacyManagementSystem.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\login1.jpg"));
        lblPharamacyManagementSystem.setForeground(SystemColor.textHighlightText);
        lblPharamacyManagementSystem.setFont(new Font("Sitka Banner", Font.BOLD, 42));
        frame.getContentPane().add(lblPharamacyManagementSystem, gbc_lblPharamacyManagementSystem);
        
        
        GridBagConstraints gbc_Username = new GridBagConstraints();
        gbc_Username.insets = new Insets(0, 0, 5, 5);
        gbc_Username.gridx = 0;
        gbc_Username.gridy = 10;
        gbc_Username.anchor = GridBagConstraints.SOUTHWEST;
        
        JLabel Username = new JLabel("Username");
        Username.setForeground(SystemColor.textHighlightText);
        Username.setVerticalAlignment(SwingConstants.TOP);
        Username.setFont(new Font("Sitka Banner", Font.BOLD, 32));
        frame.getContentPane().add(Username, gbc_Username);

        textField = new JTextField();
        textField.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        textField.setColumns(13);
        textField.setAlignmentX(RIGHT_ALIGNMENT);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridy = 10;
        gbc_textField.gridx = 4;
        frame.getContentPane().add(textField, gbc_textField);
                
        GridBagConstraints gbc_Password = new GridBagConstraints();
        gbc_Password.insets = new Insets(0, 0, 5, 5);
        gbc_Password.gridx = 0;
        gbc_Password.gridy = 20;
        gbc_Password.anchor = GridBagConstraints.SOUTHWEST;
        gbc_Password.gridwidth = GridBagConstraints.REMAINDER;
        JLabel Password = new JLabel("Password");
        //Password.setAlignmentX(LEFT_ALIGNMENT);
        Password.setForeground(SystemColor.textHighlightText);
        Password.setVerticalAlignment(SwingConstants.TOP);
        Password.setFont(new Font("Sitka Banner", Font.BOLD, 32));
        frame.getContentPane().add(Password, gbc_Password);
       
        
        
        passwordField = new JPasswordField();
        passwordField.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 170, 281, 68);
        passwordField.setColumns(13);
        //passwordField.setAlignmentX(RIGHT_ALIGNMENT);
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 10, 0);
        gbc_passwordField.gridy = 20;
        gbc_passwordField.anchor = GridBagConstraints.WEST;
        gbc_passwordField.gridx = 4;
        frame.getContentPane().add(passwordField, gbc_passwordField);


        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.gridy = 4;
        gbc_button.anchor = GridBagConstraints.SOUTHWEST;
        //bc_button.gridwidth = GridBagConstraints.REMAINDER; 
        btnNewButton = new JButton("Login");
        btnNewButton.setForeground(UIManager.getColor("FormattedTextField.selectionBackground"));
        btnNewButton.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                try {
                	Class.forName("com.mysql.jdbc.Driver");  
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "Phoebe2001#");
                    System.out.println("Connection made");
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select name, password from users where name=? and password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        HomePage ah = new HomePage(userName);
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

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
        btnNewButton.setBounds(247, 320, 491, 114);
        GridBagConstraints gbc_lgbutton = new GridBagConstraints();
        gbc_lgbutton.anchor = GridBagConstraints.WEST;
        gbc_lgbutton.gridx = 1;
        gbc_lgbutton.gridy = 22;
        frame.getContentPane().add(btnNewButton , gbc_lgbutton);
        
      /*  label = new JLabel("");
        label.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
        label.setBounds(20, 11, 988, 551);
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 0, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 0;
        contentPane.add(label, gbc_label);
         
         */
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
                }
                catch (IOException e1) {
                	e1.printStackTrace();
				}
    		}
    	});
       }
}