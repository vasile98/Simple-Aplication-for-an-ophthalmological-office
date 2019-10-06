package old;
import java.awt.*;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class Broweser extends JFrame {
	
	public Broweser()
	{
		setTitle("Main");
		
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension screenDimensions = toolkit.getScreenSize();
		setSize(screenDimensions.width*3/4, screenDimensions.height*3/4);		
		setLocation(new Point(screenDimensions.width/5, screenDimensions.height/5));
		
		Container content = getContentPane();
		Panel1 panel1 = new Panel1();
		content.add(panel1);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
 
public static void main(String[] args)
{
	Broweser myBroweser = new Broweser();
}
	
}
