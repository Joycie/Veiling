package veilingActions.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class GetConnection {
	static Connection dbConnection = null;
	public static Connection getDBConnection() {


		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Oracle JDBC driver loaded ok.");

		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver.");
			System.out.println(e.getMessage());

		}

		try {
			dbConnection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl",
					"tho5_2013_2a_team3", "welkom_02");
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		return dbConnection;
	}
	public static void closeConnection(){
		try {
			System.out.println("|| Closed connection || ");
			dbConnection.close();
		} catch (SQLException e) {
			System.out.println("|| Can't close connection || ");
			e.printStackTrace();
		}
	}
}