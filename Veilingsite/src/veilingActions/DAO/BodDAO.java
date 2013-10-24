package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import veilingActions.database.GetConnection;
import veilingDomain.Bod;

public class BodDAO {
	
	public void create(Object T) {
		Bod bod = (Bod) T;
		Connection connection = null;
		connection = GetConnection.getDBConnection();
		if (connection != null) {
			System.out.println("|| Connection ready || ");
		} else {
			System.out.println("|| Connection failed ||");
		}
		try {
			System.out.println(" || Excecuting query ");
			PreparedStatement ps = connection.prepareStatement("INSERT INTO BIEDINGEN (BOD) VALUES (?)");
			ps.setDouble(1,bod.getGeld());

			
			ResultSet rs = ps.executeQuery();
			
			ps.close();
			rs.close();
	
		} catch (SQLException e) {
	
			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
	
	public void retrieve(Object T){
		
	}
	
		
	public void update(Object T) {
		
	}
	public void delete(Object T) {
		// TODO Auto-generated method stub
		
	}
		
}
