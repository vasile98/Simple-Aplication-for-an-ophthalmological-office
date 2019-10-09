/**
 * A panel were user can search an old patient ,choose between result and see the old consultation
 * 
 * @author Vasile Antohi
 */
package old;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Oldpatientpanel extends JPanel {
	
	protected JTextArea searchJTextArea = new JTextArea(1,40);
	protected JButton backButton = new JButton("Back");
	protected JButton searchButton = new JButton("Search");
    protected DefaultListModel<String>  listModel = new DefaultListModel<String>();
    protected JList myList;
	
	/**
	 * Simple panel with 2 buttons and a search area where the user can find an old patient 
	 * I am using a Jlist to print all the possible patient after a search 
	 */
	public Oldpatientpanel ()
	{
				
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		mainPanel.add(new JLabel("Nume:"));
		searchJTextArea.setAlignmentY(BOTTOM_ALIGNMENT);
		mainPanel.add(searchJTextArea);
		myList = new JList(listModel);
		mainPanel.add(myList);
		
		
		this.add(mainPanel);
		
		JPanel butonPanel = new JPanel();
		butonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		searchButton.setPreferredSize(new Dimension(200,100));
		backButton.setPreferredSize(new Dimension(200,100));
		butonPanel.add(searchButton);
		butonPanel.add(Box.createHorizontalStrut(40));
		butonPanel.add(backButton);
		
		this.add(butonPanel);
		
		
		addListeners();
		
		
		
	}
	/**
	 * This function adds functionality to buttons and the Jlist
	 * When an element from Jlist is clicked user is directed to a panel with his information from database 
	 */
	public void addListeners ()
	{
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				Broweser frameBroweser = new Broweser();
				
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SqliteDB db = new SqliteDB();
				listModel.removeAllElements();
				ArrayList<String> nameList = new ArrayList<String>();
				nameList=db.existName(searchJTextArea.getText());
				if(nameList.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Nu exista pacient cu acest nume in baza de date");
				}
				else 
				{
					for(int i=0;i< nameList.size();i++)
						{
						 listModel.addElement(nameList.get(i));
						}
				}
				
				
				db.closeConnection();
			}
		});
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {

		        	String selectedItemString = (String)myList.getSelectedValue();
		        	Informationframe frame = new Informationframe(selectedItemString);
		        	JComponent comp = (JComponent) e.getSource();
					Window win = SwingUtilities.getWindowAncestor(comp);
					win.dispose();
		        	
		         }
		    }
		        	
		        	
		};
		myList.addMouseListener(mouseListener);
		
	}

}
