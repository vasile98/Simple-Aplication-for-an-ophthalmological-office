package old;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.SoftBevelBorder;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.sql.*;

public class Patientpanel extends JPanel {
	
	
	 protected Date date = new Date();
	 protected JLabel dataConsultJLabel = new JLabel("Data consultatie");
	 protected JLabel currentdataJLabel;
	 protected JLabel datePacientJLabel = new JLabel("Date Pacient");
	 protected JLabel numeJLabel = new JLabel("Nume:");
	 protected JTextArea numeJTextArea = new JTextArea(1,20);
	 protected JLabel varstaJLabel = new JLabel("Varsta:");
	 protected JTextArea varstaJTextArea = new JTextArea(1,5);
	 protected JLabel telefonJLabel = new JLabel("Telefon:");
	 protected JTextArea telefonJTextArea = new JTextArea(1,10);
	 protected JLabel localitateJLabel = new JLabel("Localitate:");
	 protected JTextArea localitateJTextArea = new JTextArea(1,20);
	 protected JLabel doctorJLabel = new JLabel("Medic consultant: Dr.Antohi Natalia");
	 protected JLabel istoricJLabel = new JLabel("Istoricul bolii actuale");
	 protected JTextArea istoricJTextArea = new JTextArea(3,80);
	 protected JLabel antecedenteJLabel = new JLabel("Antecedente personale patologice");
	 protected JTextArea antecedenteJTextArea = new JTextArea(1,72);
	 protected JLabel alergiiJLabel = new JLabel("Alergii");
	 protected JTextArea alergiiJTextArea = new JTextArea(1,80);
	 protected JLabel ochiJLabel = new JLabel("Ochi");
	 protected JLabel dreptJLabel = new JLabel("Drept");
	 protected JLabel stangJLabel = new JLabel("Stang");
	 protected JLabel diagnosticJLabel = new JLabel("Diagnostic");
	 protected JLabel aoJLabel = new JLabel("AO:");
	 protected JLabel odJLabel = new JLabel("OD:");
	 protected JLabel osJLabel = new JLabel("OS:");
	 protected JTextArea aoJTextArea = new JTextArea(1,85);
	 protected JTextArea odJTextArea = new JTextArea(1,35);
	 protected JTextArea osJTextArea = new JTextArea(1,35);
	 protected JLabel refracttieJLabel = new JLabel("Refractie");
	 protected JLabel nouaJLabel = new JLabel("noua");
	 protected JLabel krJLabel = new JLabel("KR");
	 protected JLabel sfJLabel= new JLabel("sf");
	 protected JLabel cyLabel = new JLabel("cyl");
	 protected JLabel axJLabel = new JLabel("ax");
	 protected JLabel sfJLabel2= new JLabel("sf");
	 protected JLabel cyLabel2 = new JLabel("cyl");
	 protected JLabel axJLabel2 = new JLabel("ax");
	 protected JLabel dpJLabel = new JLabel("dp");
	 protected JTextArea sfJTextArea = new JTextArea(1,5);
	 protected JTextArea cyJTextArea = new JTextArea(1,5);
	 protected JTextArea axJTextArea = new JTextArea(1,5);
	 protected JTextArea sfJTextArea2 = new JTextArea(1,5);
	 protected JTextArea cyJTextArea2 = new JTextArea(1,5);
	 protected JTextArea axJTextArea2 = new JTextArea(1,5);
	 protected JTextArea dpJTextArea = new JTextArea(1,5);
	 protected JTextArea avJTextArea1 = new JTextArea(1,20);
	 protected JTextArea avJTextArea2 = new JTextArea(1,20);
	 protected JTextArea testaTextArea1 = new JTextArea(1,20);
	 protected JTextArea testaTextArea2 = new JTextArea(1,20);
	 protected JTextArea tioJTextArea1 = new JTextArea(1,20);
	 protected JTextArea tioJTextArea2 = new JTextArea(1,20);
	 protected JTextArea tratamenTextArea1 = new JTextArea(1,20);
	 protected JTextArea tratamenTextArea2 = new JTextArea(1,20);
	 protected JTextArea anteriorJTextArea1 = new JTextArea(5,20);
	 protected JTextArea anteriorJTextArea2 = new JTextArea(5,20);
	 protected JTextArea posteriorJTextArea1 = new JTextArea(5,20);
	 protected JTextArea posteriorJTextArea2 = new JTextArea(5,20);
	 protected JTextArea tratamenTextArea = new JTextArea(5,70);
	 protected JTextArea observatiiJTextArea1 = new JTextArea(3,20);
	 protected JTextArea observatiiJTextArea2 = new JTextArea(3,20);
	 protected JTextArea recomandariJTextArea = new JTextArea(5,70);
	 protected JButton saveButton = new JButton("Save");
	 protected JButton backButton = new JButton("Back");
	 protected int window ;
	 protected String nameForUpdate;
	 private JScrollPane pane;
	
	
	public Patientpanel()
	{   
		
		// 0 inseamna ca trebuie inregistrat un nou pacient
		window = 0;
		
	    bildGUI();
		
		
    }
	
	public Patientpanel (String name)
	{   // inseamna ca trebuie reinoita informatia in baza de date
		window = 1;
		//memoram numele pentru reinoirea informatieie 
		nameForUpdate = name;
		ArrayList<String> dataArrayList = new ArrayList<String>();
		
		bildGUI();
		SqliteDB db = new SqliteDB();
		dataArrayList = db.getDataFromName(name);
		db.closeConnection();
		numeJTextArea.append(dataArrayList.get(0));
		varstaJTextArea.append(dataArrayList.get(1));
		telefonJTextArea.append(dataArrayList.get(2));
		localitateJTextArea.append(dataArrayList.get(3));
		istoricJTextArea.append(dataArrayList.get(4));
		antecedenteJTextArea.append(dataArrayList.get(5));
		alergiiJTextArea.append(dataArrayList.get(6));
		aoJTextArea.append(dataArrayList.get(7));
		odJTextArea.append(dataArrayList.get(8));
		osJTextArea.append(dataArrayList.get(9));
		sfJTextArea.append(dataArrayList.get(10));
		cyJTextArea2.append(dataArrayList.get(11));
		axJTextArea.append(dataArrayList.get(12));
		sfJTextArea2.append(dataArrayList.get(13));
		cyJTextArea2.append(dataArrayList.get(14));
		axJTextArea2.append(dataArrayList.get(15));
		avJTextArea1.append(dataArrayList.get(16));
		avJTextArea2.append(dataArrayList.get(17));
		testaTextArea1.append(dataArrayList.get(18));
		testaTextArea2.append(dataArrayList.get(19));
		tioJTextArea1.append(dataArrayList.get(20));
		tioJTextArea2.append(dataArrayList.get(21));
		tratamenTextArea1.append(dataArrayList.get(22));
		tratamenTextArea2.append(dataArrayList.get(23));
		anteriorJTextArea1.append(dataArrayList.get(24));
		anteriorJTextArea2.append(dataArrayList.get(25));
		posteriorJTextArea1.append(dataArrayList.get(26));
		posteriorJTextArea2.append(dataArrayList.get(27));
		tratamenTextArea.append(dataArrayList.get(28));
		observatiiJTextArea1.append(dataArrayList.get(29));
		observatiiJTextArea2.append(dataArrayList.get(30));
		recomandariJTextArea.append(dataArrayList.get(31));
		currentdataJLabel = new JLabel(dataArrayList.get(32));
		
	}
	
	public void bildGUI ()
	{
        JPanel mainJPanel = new JPanel();
		
		mainJPanel.setLayout(new BoxLayout(mainJPanel, BoxLayout.Y_AXIS));
		
		
		
		JPanel dateJPanel = new JPanel();
		dateJPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		dateJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		dataConsultJLabel.setVerticalAlignment(SwingConstants.TOP);
		dataConsultJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		currentdataJLabel = new JLabel(formatter.format(date));
		dateJPanel.add(dataConsultJLabel);
		dateJPanel.add(currentdataJLabel);
		
		mainJPanel.add(dateJPanel);
		
		JPanel pacientJPanel = new JPanel();
		dateJPanel.setLayout(new FlowLayout());
		pacientJPanel.add(datePacientJLabel);
		pacientJPanel.add(Box.createHorizontalStrut(40));
		pacientJPanel.add(numeJLabel);
		pacientJPanel.add(numeJTextArea);
		pacientJPanel.add(varstaJLabel);
		pacientJPanel.add(varstaJTextArea);
		pacientJPanel.add(telefonJLabel);
		pacientJPanel.add(telefonJTextArea);
		pacientJPanel.add(localitateJLabel);
		pacientJPanel.add(localitateJTextArea);
		
		mainJPanel.add(pacientJPanel);
		
		JPanel doctorJPanel = new JPanel();
		doctorJPanel.add(doctorJLabel);
		
		mainJPanel.add(doctorJPanel);
		
		JPanel istoricJPanel = new JPanel();
		istoricJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		istoricJPanel.add(istoricJLabel);
		istoricJPanel.add(istoricJTextArea);
		
		mainJPanel.add(istoricJPanel);
		
		JPanel antecedenteJPanel = new JPanel();
		antecedenteJPanel.add(antecedenteJLabel);
		antecedenteJPanel.add(antecedenteJTextArea);
		
		mainJPanel.add(antecedenteJPanel);
		
		JPanel alergiiJPanel = new JPanel();
		alergiiJPanel.add(alergiiJLabel);
		alergiiJPanel.add(alergiiJTextArea);
		
		mainJPanel.add(alergiiJPanel);
		
		JPanel ochiJPanel = new JPanel();
		ochiJPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ochiJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		ochiJPanel.add(ochiJLabel);
		ochiJPanel.add(Box.createHorizontalStrut(300));
		ochiJPanel.add(dreptJLabel);
		ochiJPanel.add(Box.createHorizontalStrut(350));
		ochiJPanel.add(stangJLabel);
		
		mainJPanel.add(ochiJPanel);
		
		JPanel diagnosticJPanel = new JPanel();
		diagnosticJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		diagnosticJPanel.add(diagnosticJLabel);
		diagnosticJPanel.add(Box.createHorizontalStrut(100));
		diagnosticJPanel.add(aoJLabel);
		diagnosticJPanel.add(aoJTextArea);
		mainJPanel.add(diagnosticJPanel);
		
		JPanel aoJPanel = new JPanel();
		aoJPanel.add(odJLabel);
		aoJPanel.add(odJTextArea);
		aoJPanel.add(Box.createHorizontalStrut(100));
		aoJPanel.add(osJLabel);
		aoJPanel.add(osJTextArea);
		
		mainJPanel.add(aoJPanel);
		
		JPanel refractieJPanel = new JPanel();
		refractieJPanel.setLayout(new GridLayout(2,10,4,0));
		refracttieJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(refracttieJLabel);
		sfJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(sfJLabel);
		cyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(cyLabel);
		axJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(axJLabel);
		refractieJPanel.add(new JLabel(""));
		sfJLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(sfJLabel2);
		cyLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(cyLabel2);
		axJLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(axJLabel2);
		nouaJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		refractieJPanel.add(nouaJLabel);
		refractieJPanel.add(sfJTextArea);
		refractieJPanel.add(cyJTextArea);
		refractieJPanel.add(axJTextArea);
		refractieJPanel.add(new JLabel(""));
		refractieJPanel.add(sfJTextArea2);
		refractieJPanel.add(cyJTextArea2);
		refractieJPanel.add(axJTextArea2);
		
		mainJPanel.add(refractieJPanel);
		
		
		mainJPanel.add(Box.createVerticalStrut(10));
		
		JPanel avJPanel = new JPanel();
		avJPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		avJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		avJPanel.add(new JLabel("AV fara corectie"));
		avJPanel.add(Box.createHorizontalStrut(150));
		avJPanel.add(avJTextArea1);
		avJPanel.add(Box.createHorizontalStrut(200));
		avJPanel.add(avJTextArea2);
		
		
		mainJPanel.add(avJPanel);
		
		JPanel testatJPanel = new JPanel();
		testatJPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		testatJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		testatJPanel.add(new JLabel("AV  cu corectie distanta"));
		testatJPanel.add(Box.createHorizontalStrut(107));
		testatJPanel.add(testaTextArea1);
		testatJPanel.add(Box.createHorizontalStrut(200));
		testatJPanel.add(testaTextArea2);
		
		mainJPanel.add(testatJPanel);
		
		
		JPanel tioJPanel = new JPanel();
		tioJPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tioJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tioJPanel.add(new JLabel("TIO NCT"));
		tioJPanel.add(Box.createHorizontalStrut(189));
		tioJPanel.add(tioJTextArea1);
		tioJPanel.add(Box.createHorizontalStrut(200));
		tioJPanel.add(tioJTextArea2);
		
		mainJPanel.add(tioJPanel);
		
		
		JPanel tratamentJPanel = new JPanel();
		tratamentJPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tratamentJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		tratamentJPanel.add(new JLabel("Tratament TIO"));
		tratamentJPanel.add(Box.createHorizontalStrut(157));
		tratamentJPanel.add(tratamenTextArea1);
		tratamentJPanel.add(Box.createHorizontalStrut(200));
		tratamentJPanel.add(tratamenTextArea2);
		
		mainJPanel.add(tratamentJPanel);
		
		
		JPanel anteriorJPanel = new JPanel();
		anteriorJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		anteriorJPanel.add(new JLabel("Pol anterior"));
		anteriorJPanel.add(Box.createHorizontalStrut(172));
		anteriorJPanel.add(anteriorJTextArea1);
		anteriorJPanel.add(Box.createHorizontalStrut(200));
		anteriorJPanel.add(anteriorJTextArea2);
		
		
		mainJPanel.add(anteriorJPanel);
		
		
		JPanel posteriorJPanel = new JPanel();
		posteriorJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		posteriorJPanel.add(new JLabel("Pol posterior"));
		posteriorJPanel.add(Box.createHorizontalStrut(165));
		posteriorJPanel.add(posteriorJTextArea1);
		posteriorJPanel.add(Box.createHorizontalStrut(200));
		posteriorJPanel.add(posteriorJTextArea2);
		
		mainJPanel.add(posteriorJPanel);
		
		
		JPanel tratamentJPanel2 = new JPanel();
		tratamentJPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		tratamentJPanel2.add(new JLabel("Tratament"));
		tratamentJPanel2.add(Box.createHorizontalStrut(135));
		tratamentJPanel2.add(tratamenTextArea);
		
		
		mainJPanel.add(tratamentJPanel2);
		
		
		JPanel observatiiJPanel = new JPanel();
		observatiiJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		observatiiJPanel.add(new JLabel("Observatii"));
		observatiiJPanel.add(Box.createHorizontalStrut(180));
		observatiiJPanel.add(observatiiJTextArea1);
		observatiiJPanel.add(Box.createHorizontalStrut(200));
		observatiiJPanel.add(observatiiJTextArea2);
		
		mainJPanel.add(observatiiJPanel);
		
		JPanel recomandariJPanel = new JPanel();
		recomandariJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		recomandariJPanel.add(new JLabel("Recomandari"));
		recomandariJPanel.add(Box.createHorizontalStrut(135));
		recomandariJPanel.add(recomandariJTextArea);
		
		
		mainJPanel.add(recomandariJPanel);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		saveButton.setPreferredSize(new Dimension(100,40));
		backButton.setPreferredSize(new Dimension(100,40));
		buttonPanel.add(saveButton);
		buttonPanel.add(Box.createHorizontalStrut(135));
		buttonPanel.add(backButton);
		
		mainJPanel.add(buttonPanel);
		
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenDimensions = toolkit.getScreenSize();
		mainJPanel.setPreferredSize(new Dimension(screenDimensions.width*3/4, screenDimensions.height*91/100));
		
		
		pane = new JScrollPane(mainJPanel);
		
		this.add(pane);
		this.addListeners();
		
		
	}
	
	
	
	
	
	
	public void addListeners()
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
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(window == 0)	
				{
				savingData();
				makeDoc();
				}
				else {
					updatingData();
				}
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				Broweser frameBroweser = new Broweser();
				
			}
		});
	}
	
	public void savingData()
	{
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		SqliteDB db = new SqliteDB();
		Connection c = db.connect();
		try {
			PreparedStatement ptPreparedStatement = c.prepareStatement("insert into Pacienti values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ptPreparedStatement.setString(1,numeJTextArea.getText());
			ptPreparedStatement.setString(2,varstaJTextArea.getText());
			ptPreparedStatement.setString(3,telefonJTextArea.getText());
			ptPreparedStatement.setString(4,localitateJTextArea.getText());
			ptPreparedStatement.setString(5,istoricJTextArea.getText());
			ptPreparedStatement.setString(6,antecedenteJTextArea.getText());
			ptPreparedStatement.setString(7,alergiiJTextArea.getText());
			ptPreparedStatement.setString(8,aoJTextArea.getText());
			ptPreparedStatement.setString(9,odJTextArea.getText());
			ptPreparedStatement.setString(10,osJTextArea.getText());
			ptPreparedStatement.setString(11,sfJTextArea.getText());
			ptPreparedStatement.setString(12,cyJTextArea.getText());
			ptPreparedStatement.setString(13,axJTextArea.getText());
			ptPreparedStatement.setString(14,sfJTextArea2.getText());
			ptPreparedStatement.setString(15,cyJTextArea2.getText());
			ptPreparedStatement.setString(16,axJTextArea2.getText());
			ptPreparedStatement.setString(17,avJTextArea1.getText());
			ptPreparedStatement.setString(18,avJTextArea2.getText());
			ptPreparedStatement.setString(19,testaTextArea1.getText());
			ptPreparedStatement.setString(20,testaTextArea2.getText());
			ptPreparedStatement.setString(21,tioJTextArea1.getText());
			ptPreparedStatement.setString(22,tioJTextArea2.getText());
			ptPreparedStatement.setString(23,tratamenTextArea1.getText());
			ptPreparedStatement.setString(24,tratamenTextArea2.getText());
			ptPreparedStatement.setString(25,anteriorJTextArea1.getText());
			ptPreparedStatement.setString(26,anteriorJTextArea2.getText());
			ptPreparedStatement.setString(27,posteriorJTextArea1.getText());
			ptPreparedStatement.setString(28,posteriorJTextArea2.getText());
			ptPreparedStatement.setString(29,tratamenTextArea.getText());
			ptPreparedStatement.setString(30,observatiiJTextArea1.getText());
			ptPreparedStatement.setString(31,observatiiJTextArea2.getText());
			ptPreparedStatement.setString(32,recomandariJTextArea.getText());
			ptPreparedStatement.setString(33, formatter.format(date));
			ptPreparedStatement.executeUpdate();
	        c.close();
	        
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Eroare la salvarea datelor, consultati asistenta,pe Vasile :)",
				    "Database error",
				    JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		db.closeConnection();
	}
	
	public void updatingData ()
	{   
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		SqliteDB db = new SqliteDB();
		Connection c = db.connect();
		
		try {
			PreparedStatement ptPreparedStatement = c.prepareStatement("update Pacienti "
					                                                   + "set nume = ?,"
					                                                      + " varsta = ?,"
					                                                      + " telefon = ?,"
					                                                      + " localitate = ?,"
					                                                      + " istoric = ?,"
					                                                      + " antecedente = ?,"
					                                                      + " alergii = ?,"
					                                                      + " diaao = ?,"
					                                                      + " diaod = ?,"
					                                                      + " diaos = ?,"
					                                                      + " refractiesfd = ?,"
					                                                      + " refractiecyld = ?,"
					                                                      + " refractieaxd = ?,"
					                                                      + " refractiesfs = ?,"
					                                                      + " refractiecyls = ?,"
					                                                      + " refractieaxs = ?,"
					                                                      + " avfd = ?,"
					                                                      + " avfs = ?,"
					                                                      + " avcd = ?,"
					                                                      + " avcs = ?,"
					                                                      + " tiod = ?,"
					                                                      + " tios = ?,"
					                                                      + " tiotratamentd = ?,"
					                                                      + " tiotrataments = ?,"
					                                                      + " polad = ?,"
					                                                      + " polas = ?,"
					                                                      + " polbd = ?,"
					                                                      + " polbs = ?,"
					                                                      + " tratament = ?,"
					                                                      + " observatiid = ?,"
					                                                      + " observatiis = ?,"
					                                                      + " recomandari = ?,"
					                                                      + " data = ?"
					                                                      + "where nume ='"+nameForUpdate+"'");
			ptPreparedStatement.setString(1,numeJTextArea.getText());
			ptPreparedStatement.setString(2,varstaJTextArea.getText());
			ptPreparedStatement.setString(3,telefonJTextArea.getText());
			ptPreparedStatement.setString(4,localitateJTextArea.getText());
			ptPreparedStatement.setString(5,istoricJTextArea.getText());
			ptPreparedStatement.setString(6,antecedenteJTextArea.getText());
			ptPreparedStatement.setString(7,alergiiJTextArea.getText());
			ptPreparedStatement.setString(8,aoJTextArea.getText());
			ptPreparedStatement.setString(9,odJTextArea.getText());
			ptPreparedStatement.setString(10,osJTextArea.getText());
			ptPreparedStatement.setString(11,sfJTextArea.getText());
			ptPreparedStatement.setString(12,cyJTextArea.getText());
			ptPreparedStatement.setString(13,axJTextArea.getText());
			ptPreparedStatement.setString(14,sfJTextArea2.getText());
			ptPreparedStatement.setString(15,cyJTextArea2.getText());
			ptPreparedStatement.setString(16,axJTextArea2.getText());
			ptPreparedStatement.setString(17,avJTextArea1.getText());
			ptPreparedStatement.setString(18,avJTextArea2.getText());
			ptPreparedStatement.setString(19,testaTextArea1.getText());
			ptPreparedStatement.setString(20,testaTextArea2.getText());
			ptPreparedStatement.setString(21,tioJTextArea1.getText());
			ptPreparedStatement.setString(22,tioJTextArea2.getText());
			ptPreparedStatement.setString(23,tratamenTextArea1.getText());
			ptPreparedStatement.setString(24,tratamenTextArea2.getText());
			ptPreparedStatement.setString(25,anteriorJTextArea1.getText());
			ptPreparedStatement.setString(26,anteriorJTextArea2.getText());
			ptPreparedStatement.setString(27,posteriorJTextArea1.getText());
			ptPreparedStatement.setString(28,posteriorJTextArea2.getText());
			ptPreparedStatement.setString(29,tratamenTextArea.getText());
			ptPreparedStatement.setString(30,observatiiJTextArea1.getText());
			ptPreparedStatement.setString(31,observatiiJTextArea2.getText());
			ptPreparedStatement.setString(32,recomandariJTextArea.getText());
			ptPreparedStatement.setString(33, formatter.format(date));
			ptPreparedStatement.executeUpdate();
	        c.close();
			
			
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Eroare la reinoirea datelor, consultati asistenta,pe Vasile :)",
				    "Database error",
				    JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		db.closeConnection();
	}

	public void printComponenet(Component component){
		  PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName(" Print Component ");

		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum){
		      if (pageNum > 0){
		      return Printable.NO_SUCH_PAGE;
		      }

		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      component.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }
		  });
		  if (pj.printDialog() == false)
		  return;

		  try {
		        pj.print();
		  } catch (PrinterException ex) {
		        JOptionPane.showMessageDialog(new JFrame(), "Ba nu mere de printat");
		  }
		}
	
	
	public void makeDoc ()
	{
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			FileOutputStream out = new FileOutputStream(new File("create_table.docx"));
			XWPFDocument docx = new XWPFDocument(new FileInputStream("C:/Header.docx"));
			XWPFTable table = docx.createTable();
			
			XWPFTableRow tableRowOne = table.getRow(0);
			tableRowOne.getCell(0).setText("Data consultatie");
			tableRowOne.addNewTableCell().setText(formatter.format(date));
			
			XWPFTableRow tableRowTwo = table.createRow();
			tableRowTwo.getCell(0).setText("Date pacient");
			tableRowTwo.getCell(1).setText("Nme: "+numeJTextArea.getText()+" Varsta: "+varstaJTextArea.getText()+" Telefon: " + telefonJTextArea.getText()+ "\n" + " Localitate: " + localitateJTextArea.getText() );
			
			XWPFTableRow tableRowThree  = table.createRow();
			tableRowThree.getCell(0).setText("Medic consultant");
			tableRowThree.getCell(1).setText("Dr. Antohi Natalia");
			
			XWPFTableRow tableRowFour = table.createRow();
			tableRowFour.getCell(0).setText("Istoricul bolii actuale");
			tableRowFour.getCell(1).setText(istoricJTextArea.getText());
			
			XWPFTableRow tableRowFive = table.createRow();
			tableRowFive.getCell(0).setText("Antecedente personale patologice");
			tableRowFive.getCell(1).setText(antecedenteJTextArea.getText());
			
			XWPFTableRow tableRowSix = table.createRow();
			tableRowSix.getCell(0).setText("Alergii");
			tableRowSix.getCell(1).setText(alergiiJTextArea.getText());
			
			XWPFTableRow tableRowSeven = table.createRow();
			tableRowSeven.getCell(0).setText("Ochi");
			tableRowSeven.getCell(1).setText("Drept");
			tableRowSeven.addNewTableCell().setText("Stang");
			
			XWPFTableRow tableRowEight= table.createRow();
			tableRowEight.removeCell(2);
			
 			
			
			docx.write(out);
			out.close();
			
		} catch (Exception e) {
			System.out.print("Error when opening focx file");
		}
	}
	
}
