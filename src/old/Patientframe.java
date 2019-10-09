/**
 * Frame for the patientpanel
 * 
 * @author Vasile Antohi
 */
package old;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Patientframe extends JFrame {
	
	public Patientframe()
	{
		
		   setTitle("Pacient Nou");
				
		   Toolkit toolkit = Toolkit.getDefaultToolkit();
				
		   setExtendedState(JFrame.MAXIMIZED_BOTH);
		   setUndecorated(true);
		   
		   Container content = getContentPane();
		   Patientpanel myPatientpanel = new Patientpanel();
		   content.add(myPatientpanel);
		   
		   
		   
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setVisible(true);
				
					

	}
	

}
