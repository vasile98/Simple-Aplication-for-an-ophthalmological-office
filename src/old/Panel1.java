/**
 * Panel with 2 buttons to choose a new patient or to change the information of an old patient
 * 
 * @author Vasile Antohi
 */
package old;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Panel1  extends JPanel{
	
	
		
	protected JButton newPatientButton = new JButton("Pacient nou");
	protected JButton oldPatientButton = new JButton("Pacient Vechi");
		
   public Panel1()
   {   
	   setLayout(new GridBagLayout());
	   
	   newPatientButton.setPreferredSize(new Dimension(200,100));
	   oldPatientButton.setPreferredSize(new Dimension(200,100));
       add(newPatientButton);
       add(Box.createRigidArea(new Dimension(100, 0)));
       add(oldPatientButton);
       
       this.addListeners();
   }
 /**
  * This function adds functionality to buttons
  */
	public void addListeners ()
	{
		newPatientButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				Patientframe fPatientframe = new Patientframe();
				
			}
		});
		
		oldPatientButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				Oldpatient frameOldpatient = new Oldpatient();
				
			}
		});
	}
		
}


