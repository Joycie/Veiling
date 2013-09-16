package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
 
public class Databasetest {
 
	public static void main(String[] argv) {
 
		System.out.println("-------- Database connectie test. ------");
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Geen oracle database JAR gevonden");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("Oracle JAR gevonden!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", "tho5_2013_2a_team3",
					"welkom_02");
 
		} catch (SQLException e) {
 
			System.out.println("Connectie mislukt!");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("Connectie geslaagd");
		} else {
			System.out.println("Mislukt");
		}
	}
 
}