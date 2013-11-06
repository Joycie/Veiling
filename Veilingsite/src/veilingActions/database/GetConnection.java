package veilingActions.database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/*
 *  In dit project zijn op verschillende plekken letters verstopt.
 *  Wij willen natuurlijk dat de code zorgvuldig en met veel liefde wordt gelezen. 
 *  Het lijkt ons daarom de beste manier om dat te doen doormiddel van een spelletje.
 *  Weet jij de letters te vinden en er een woord van te maken?
 *  de letters zijn als te vinden in een comment dus bijvoorbeeld : // z
 *  
 *  Mvg, Team 3
 *  
 *  P.s. veel zoekplezier
 */
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