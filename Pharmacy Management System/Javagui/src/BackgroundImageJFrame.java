 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
JButton b1;
JLabel l1;
	public BackgroundImageJFrame(String filepath)
	{
	setTitle("Background Color for JFrame");
	setSize(1000,1000);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\SEM-6\\javaswing\\images\\bg2.jpeg")));
	setLayout(new FlowLayout());
	setSize(399,399);
	setSize(400,400);
	}
	public static void main(String args[])
	{
	String filepath = null;
	new BackgroundImageJFrame(filepath);
	}
}