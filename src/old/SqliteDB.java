package old;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SqliteDB {
	
	Connection c = null;
	Statement statement = null;
	
	public SqliteDB ()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Eroare la conectarea la baza de date, consultati asistenta,pe Vasile :)",
				    "Database error",
				    JOptionPane.ERROR_MESSAGE);
			System.out.print("Error:"+ e.getLocalizedMessage());
		}
		
	}
	
	
	
	public  Connection  connect ()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:mydatabase.sqlite");
		return c;	
		} catch (Exception e) {
			System.out.print("Error:"+ e.getLocalizedMessage());
			JOptionPane.showMessageDialog(new JFrame(),
				    "Eroare la conecatrea la baza de date, consultati asistenta,pe Vasile :)",
				    "Database error",
				    JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void ExecuteQuery (String query)
	{
		try {
			this.statement = c.createStatement();
			statement.executeQuery(query);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Eroare la executarea query-ului, consultati asistenta,pe Vasile :)",
				    "Database error",
				    JOptionPane.ERROR_MESSAGE);
			System.out.print("Error when executing query!!"+ e.getMessage());
		}
	}
	
	public ArrayList<String> existName (String name)
	{
		ArrayList<String> nameList = new ArrayList<String>();
		
		try {
			this.statement = c.createStatement();
			ResultSet rSet = statement.executeQuery("select*from Pacienti where nume like '%"+name+"%'" );
			while (rSet.next())
			{
				String numeString = rSet.getString("nume");
				nameList.add(numeString);
			}
		} catch (Exception e) {
			System.out.print("Error when cheking the name:"+ e.getMessage());
		}
		return nameList;
	}
	
	public ArrayList<String> getDataFromName (String name)
	{
		ArrayList<String> datArrayList = new ArrayList<String>();
		try {
			this.statement = c.createStatement();
			ResultSet rSet = statement.executeQuery("select*from Pacienti where nume like '"+name+"'" );
			if (rSet.next()) {
				for(int i=1 ; i<=33 ;i++)
					datArrayList.add(rSet.getString(i));
				
			}
		} catch (Exception e) {
			System.out.print("Error when geting the data"+ e.getMessage());
		}
		return datArrayList;
		
	}
	
	
	
	public void closeConnection ()
	{
		try {
			c.close();
		} catch (Exception e) {
			System.out.print("error on closing");
		}
	}
}
