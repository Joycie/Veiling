package veilingActions.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
	
	public static boolean validate(String email, String pass){
		boolean status=false;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ondora01.hu.nl:8521/cursus01.hu.nl", 
															"tho5_2013_2a_team3", "welkom_02");
				PreparedStatement ps=con.prepareStatement("select * from gebruikers where name=? and password=?");
				ps.setString(1,email);
				ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				status=rs.next();
			}catch(Exception e){e.printStackTrace();}
			return status;
			}
	}

