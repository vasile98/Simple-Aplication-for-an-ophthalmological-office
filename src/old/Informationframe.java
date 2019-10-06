package old;

import java.awt.Container;

import javax.swing.JFrame;

public class Informationframe extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Informationframe (String name)
	{
	  setTitle("Pacient vechi");
	
			
	   setExtendedState(JFrame.MAXIMIZED_BOTH);
	  setUndecorated(true);
	   
	   Container content = getContentPane();
	   Patientpanel myPatientpanel = new Patientpanel(name);
	   content.add(myPatientpanel);
	   
	   
	   
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setVisible(true);

	}
}
