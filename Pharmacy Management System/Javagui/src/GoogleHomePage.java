 import javax.swing.text.*;
    import javax.swing.*;
    import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;

public class GoogleHomePage {

  public static void main(String[] args) {

	  JFrame frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JEditorPane editorPane = new JEditorPane();

	    try {
			editorPane.setPage(new URL("https://www.medtalks.in/live-corona-counter-india"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    frame.add(new JScrollPane(editorPane));

	    frame.setSize(300, 200);
	    frame.setVisible(true);
  }

}