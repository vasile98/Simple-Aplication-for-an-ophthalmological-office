package old;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Oldpatient extends JFrame {
	
	public Oldpatient ()
	{
        setTitle("Pacient Vechi");
		
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Dimension screenDimensions = toolkit.getScreenSize();
		setSize(screenDimensions.width*3/4, screenDimensions.height*3/4);		
		setLocation(new Point(screenDimensions.width/5, screenDimensions.height/5));
		
		Container content = getContentPane();
		Oldpatientpanel panel1 = new Oldpatientpanel();
		content.add(panel1);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
	}

}
