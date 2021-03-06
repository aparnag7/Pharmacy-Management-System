import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class WelcomePage extends JFrame{

    public static void main(String[] args) {
        new WelcomePage();
    }

    public WelcomePage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    BackgroundPane background = new BackgroundPane();
                    background.setBackground(ImageIO.read(new File("C:\\\\Users\\\\hp\\\\Desktop\\\\SEM-6\\\\javaswing\\\\images\\\\bg3.jpeg")));
  
                    JFrame frame = new JFrame("Welcome Page");
                    frame.setBounds(1000,1000,373,419);
                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(background);
                   
                    GridBagLayout gridBagLayout = new GridBagLayout();
                    gridBagLayout.rowWeights = new double[]{0.0, 0.0};
                    frame.getContentPane().setLayout(gridBagLayout);
                    GridBagConstraints gbc_lblPharamacyManagementSystem = new GridBagConstraints();
                    gbc_lblPharamacyManagementSystem.gridy = 0;
                    gbc_lblPharamacyManagementSystem.anchor = GridBagConstraints.NORTHWEST;
                    gbc_lblPharamacyManagementSystem.gridwidth = GridBagConstraints.REMAINDER;
                    JLabel lblPharamacyManagementSystem = new JLabel("                                             Pharmacy Employee");
                    lblPharamacyManagementSystem.setForeground(SystemColor.textHighlightText);
                    lblPharamacyManagementSystem.setVerticalAlignment(SwingConstants.TOP);
                    lblPharamacyManagementSystem.setFont(new Font("Sitka Banner", Font.BOLD, 38));
                    frame.getContentPane().add(lblPharamacyManagementSystem, gbc_lblPharamacyManagementSystem);
                    
                    JButton lgbutton = new JButton("Login\r\n");
                    lgbutton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\loginimg.jpg"));
                    lgbutton.setAlignmentX(Component.LEFT_ALIGNMENT);
                    lgbutton.setForeground(Color.WHITE);
                    lgbutton.setBackground(new Color(255, 51, 0));
                    lgbutton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            UserLogin bo = new UserLogin();
                            bo.setTitle("Employee Login");
                            bo.setVisible(true);
                        }
                    });
                    lgbutton.setFont(new Font("Tahoma", Font.PLAIN, 32));
                    lgbutton.setBounds(247, 320, 491, 114);
                    GridBagConstraints gbc_lgbutton = new GridBagConstraints();
                    gbc_lgbutton.anchor = GridBagConstraints.WEST;
                    gbc_lgbutton.gridy = 1;
                    frame.getContentPane().add(lgbutton, gbc_lgbutton);
 
                    //register
                    JButton rgbutton = new JButton("Register\r\n");
                    rgbutton.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    rgbutton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\register2.jpeg"));
                    rgbutton.setForeground(Color.WHITE);
                    rgbutton.setBackground(new Color(255, 51, 0));
                    rgbutton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            UserRegister bo = new UserRegister();
                            bo.setTitle("Employee Register");
                            bo.setVisible(true);
                        }
                    });
                    rgbutton.setFont(new Font("Tahoma", Font.PLAIN, 32));
                    rgbutton.setBounds(247, 320, 491, 114);
                    GridBagConstraints gbc_rgbutton = new GridBagConstraints();
                    gbc_rgbutton.gridx = 1;
                    frame.getContentPane().add(rgbutton, gbc_rgbutton);
                    //scb
                  /*  JPanel panel = new JPanel();
                    JScrollPane jScrollPane = new JScrollPane(panel);
                    jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    frame.getContentPane().add(jScrollPane);                   
                  */
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
}
    