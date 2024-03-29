package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import veilingActions.database.GetConnection;
import veilingDomain.Bod;
import veilingInterface.VeilingInterface;

public class BodDAO implements VeilingInterface {
	
	public boolean create(Object T) {
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
			PreparedStatement ps = connection.prepareStatement("INSERT INTO BIEDINGEN (GEBRUIKER_KLANTNR, BEDRAG, AANBIEDINGEN_ID, BIEDINGDATUM) VALUES (?, ?, ?, ?)");
			ps.setInt(1,bod.getKlantnr());
			ps.setDouble(2, bod.getBedrag());
			ps.setInt(3, bod.getAanbiedingid());
			ps.setTimestamp(4, bod.getDatumTijd());
			
			ResultSet rs = ps.executeQuery();
			
			ps.close();
			rs.close();
			
			PreparedStatement ps2 = connection.prepareStatement("UPDATE AANBIEDINGEN SET EINDPRIJS = ? WHERE AANBIEDINGEN.ID = ?");
			ps2.setDouble(1, bod.getBedrag());
			ps2.setInt(2, bod.getAanbiedingid());
			ResultSet rs2 = ps2.executeQuery();
			
			ps2.close();
			rs2.close();
		} catch (SQLException e) {
	
			System.out.println("|| Failed to complete query || ");
			e.printStackTrace();
			return false;
		}
		GetConnection.closeConnection();
		return true;
	}
	
	public void retrieve(Object T){
		
	}
	
		
	public boolean update(Object T) {
		return false;
		
	}
	public void delete(Object T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object retrieve(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
