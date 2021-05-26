import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1 ;
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

    public UserHome() {
    	//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\bg3.jpeg"));

    }

    public UserHome(String userSes) {

    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //logout
        JButton btnNewButton = new JButton("Logout");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Emp-Login");
                    obj.setVisible(true);
                }
                dispose();
                UserLogin obj = new UserLogin();

                obj.setTitle("Emp-Login");
                obj.setVisible(true);

            }
        });
        btnNewButton.setBounds(247, 118, 491, 100);
        contentPane.add(btnNewButton);
        
        //change password
        JButton cpbutton = new JButton("Change Password\r\n");
        cpbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        cpbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangePassword bo = new ChangePassword(userSes,"");
                bo.setTitle("Change Password");
                bo.setVisible(true);
            }
        });
        cpbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        cpbutton.setBounds(247, 320, 491, 100);
        contentPane.add(cpbutton);
        
        // add drug
        /*
        JButton drugbutton = new JButton("Add new drug\r\n");
        drugbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        drugbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddDrugs ad;
				try {
					ad = new AddDrugs();
					ad.setTitle("Add new drug");
	                ad.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                            }
        });
        drugbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        drugbutton.setBounds(247, 522, 491, 100);
        contentPane.add(drugbutton);
        
        
        JButton Vdrugbutton = new JButton("View Drugs\r\n");
        Vdrugbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        Vdrugbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FetchData sd ;
				try {
					sd = new FetchData();
					
				} 
				finally {
					
				}
                            }
        });
        Vdrugbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Vdrugbutton.setBounds(247, 560, 491, 100);
        contentPane.add(Vdrugbutton);
        */
        /*
        JButton Vdrugbutton = new JButton("View Drugs\r\n");
        Vdrugbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        Vdrugbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewProfit sd ;
				try {
					sd = new ViewProfit();
					sd.setVisible(true);
				} 
				finally {
					
				}
            }
        });
        Vdrugbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Vdrugbutton.setBounds(247, 560, 491, 100);
        contentPane.add(Vdrugbutton);
        */
        /*
        JButton Vdrugbutton = new JButton("Message Others\r\n");
        Vdrugbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        Vdrugbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageOthers sd ;
				try {
					sd = new MessageOthers(userSes);
					sd.setVisible(true);
				} 
				finally {
					
				}
            }
        });
        Vdrugbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Vdrugbutton.setBounds(247, 560, 491, 100);
        contentPane.add(Vdrugbutton);
        */
        JButton Vdrugbutton = new JButton("View Messages\r\n");
        Vdrugbutton.setBackground(UIManager.getColor("Button.disabledForeground"));
        Vdrugbutton.addActionListener(new ActionListener() {
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
        Vdrugbutton.setFont(new Font("Tahoma", Font.PLAIN, 35));
        Vdrugbutton.setBounds(247, 560, 491, 100);
        contentPane.add(Vdrugbutton);
    }
}