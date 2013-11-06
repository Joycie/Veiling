package veilingJUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;
import veilingService.VeilingService;

public class UnitTestsCreateRetrieve {
	private static Boek boek;
	
	@BeforeClass
	public static void startup(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		boek = new Boek("testboek", 265, "een test boek", 1, "", "test", "test", "test", date, 2);
	}

	@Test
	public void gebruikerToevoegenTest() {
		try {
			VeilingService.createGebruiker("testacount", "", "testacount",
					"testacount", "1111TT", "testacount",
					"testacount@testacount.test", "testacount1234", 947563388,
					896546743);
		} catch (Exception e) {
			assertEquals(new Exception(
					"gebruiker kon niet in de database gezet worden"), e);
		}
	}

	@Test(expected = SQLException.class)
	public void gebruikerToevoegenBestaandEmail() throws SQLException {
		if(!
		VeilingService.createGebruiker("testacount", "", "testacount",
				"testacount", "1111TT", "testacount", "joeltroost@hotmail.com",
				"testacount1234", 947563388, 896546743)){
			Exception e = new Exception();
			throw new SQLException(e.getMessage());
		}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderEmail() throws SQLException {
		if(!
				VeilingService.createGebruiker("testacount", "", "testacount",
						"testacount", "1111TT", "testacount", "",
						"testacount1234", 947563388, 896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderVoornaam() throws SQLException {
		if(!
				VeilingService.createGebruiker("", "", "testacount",
						"testacount", "1111TT", "testacount",
						"testacount@testacount.test", "testacount1234", 947563388,
						896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderAchternaam() throws SQLException {
		if(!
				VeilingService.createGebruiker("testacount", "", "",
						"testacount", "1111TT", "testacount",
						"testacount@testacount.test", "testacount1234", 947563388,
						896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderAdres() throws SQLException {
		if(!
				VeilingService.createGebruiker("testacount", "", "testacount",
						"", "1111TT", "testacount",
						"testacount@testacount.test", "testacount1234", 947563388,
						896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderWachtwoord() throws SQLException {
		if(!
				VeilingService.createGebruiker("testacount", "", "testacount",
						"testacount", "1111TT", "testacount",
						"testacount@testacount.test", "", 947563388,
						896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderTelefoonnummer() throws SQLException {
		if(!VeilingService.createGebruiker("testacount", "", "testacount",
						"testacount", "1111TT", "testacount",
						"testacount@testacount.test", "testacount1234", 0,
						896546743)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test (expected = SQLException.class)
	public void gebruikerToevoegenZonderRekeningnummer() throws SQLException {
		if(!
				VeilingService.createGebruiker("testacount", "", "testacount",
						"testacount", "1111TT", "testacount",
						"testacount@testacount.test", "testacount1234", 947563388,
						0)){
					Exception e = new Exception();
					throw new SQLException(e.getMessage());
				}	
	}
	@Test
	public void boekToevoegenTest(){
		try{
		VeilingService.voegBoekToe(boek);
		}catch(Exception e){
			assertEquals(new Exception(
					"boek kon niet in de database gezet worden"), e);
		}
	}
	@Test (expected = SQLException.class)
	public void boekToevoegenBestaandisbn() throws SQLException{
		boek.setIsbn("1234567890");
		if(!
				VeilingService.voegBoekToe(boek)){
					Exception e = new Exception();
					boek.setIsbn("testboek");
					throw new SQLException(e.getMessage());
				}	
		boek.setIsbn("testboek");
	}
	@Test (expected = SQLException.class)
	public void boekToevoegenZonderisbn() throws SQLException{
		boek.setIsbn("");
		if(!
				VeilingService.voegBoekToe(boek)){
					Exception e = new Exception();
					boek.setIsbn("testboek");
					throw new SQLException(e.getMessage());
				}	
		boek.setIsbn("testboek");
	}
	@AfterClass
	public static void Restore() {
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}

			PreparedStatement ps = connection
					.prepareStatement("delete from gebruikers where voornaam = 'testacount' and achternaam = 'testacount'");
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
			PreparedStatement ps2 = connection
					.prepareStatement("delete from drukken where boeken_isbn = 'testboek'");
			ResultSet rs2 = ps2.executeQuery();
			rs2.close();
			ps2.close();
			PreparedStatement ps3 = connection
					.prepareStatement("delete from boeken where isbn = 'testboek'");
			ResultSet rs3 = ps3.executeQuery();
			rs3.close();
			ps3.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
}
