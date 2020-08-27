package datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.KontaktModel;

public class Datenbank {
	
	private Connection connection;
	private Statement statement;
	
	
	// Datenbank Connection
	
	public boolean open() {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kontakt","root","jaromysql");
			statement = connection.createStatement();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	// Kontakte hinzufügen
	
	public void addKontakt(Statement statement,String vorname,String nachname,String mobile,String email) throws SQLException {
		statement.executeUpdate
		("Insert into kontakte values " + "('" + vorname + "', '" + nachname + "', '" + mobile + "', '" + email + "')");
	}
	
	// Kontakte löschen
	
	public void deleteKontakt(Statement statement) throws SQLException {
		statement.executeUpdate("Delete from kontakte");
	}
	
	// Kontakte laden
	
	public ObservableList<KontaktModel> loadKontakt(Statement statement, ObservableList<KontaktModel> list) throws SQLException {
		
		list = FXCollections.observableArrayList();
		
		ResultSet resultSet = statement.executeQuery("Select * from kontakte");
		
		while(resultSet.next()) {
			list.add(new KontaktModel(
					resultSet.getString(1),
					resultSet.getString(2), 
					resultSet.getString(3),
					resultSet.getString(4)));
		}
		return list;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public Statement getStatement() {
		return statement;
	}

}
