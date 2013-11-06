package veilingJUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import veilingActions.database.GetConnection;
import veilingDomain.Aanbieding;
import veilingDomain.Bod;
import veilingDomain.Boek;
import veilingDomain.Gebruiker;
import veilingService.VeilingService;

public class UnitTestsCreateRetrieve {
	private static Boek boek;
	private static Aanbieding aanbieding;
	private static Timestamp eind;
	private static Bod bod;
	private static Gebruiker gebruiker;
	
	@BeforeClass
	public static void startup(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date currentDate = calendar.getTime();
		java.sql.Date date = new java.sql.Date(currentDate.getTime());
		eind = new Timestamp(date.getTime());
		boek = new Boek("testboek", 265, "een test boek", 1, "", "test", "test", "test", date, 2);
		aanbieding = new Aanbieding(0, 40, eind, 6, "testboek", 1, boek);
		bod = new Bod(eind, 6, 9, 50);
		gebruiker = new Gebruiker(0, "testacount2", "", "testacount2", "testacount2", "test", "test", "test", 453, 634);
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}

			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO AANBIEDINGEN( ID , STARTPRIJS , EINDTIJD , GEBRUIKERS_KLANTNR , DRUKKEN_BOEKEN_ISBN , DRUKKEN_NUMMER , INSERT_DATE) VALUES ( 9 , 40 , SYSDATE + 1 , 6 , 'testboek' , 1 , SYSDATE) ");
			ResultSet rs = ps.executeQuery();
			rs.close();
			ps.close();
			PreparedStatement ps2 = connection
					.prepareStatement("INSERT INTO BOEKEN (ISBN, TITEL, BESCHRIJVING, UITGEVERIJ, DATUM, TAAL, AANTALPAGINA, AUTEUR, CATEGORIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, boek.getIsbn());
			ps.setString(2, boek.getTitel());
			ps.setString(3, boek.getBeschrijving());
			ps.setString(4, boek.getUitgeverij());
			ps.setDate(5, boek.getDatum());
			ps.setString(6, boek.getTaal());
			ps.setInt(7, boek.getAantalpagina());
			ps.setString(8, boek.getAuteur());
			ps.setInt(9, boek.getCategorie());

			ResultSet rs2 = ps2.executeQuery();
			ps2.close();
			rs2.close();
			PreparedStatement ps3 = connection
					.prepareStatement("INSERT INTO AANBIEDINGEN( ID , STARTPRIJS , EINDTIJD , GEBRUIKERS_KLANTNR , DRUKKEN_BOEKEN_ISBN , DRUKKEN_NUMMER , INSERT_DATE) VALUES ( 8 , 40 , SYSDATE + 1 , 6 , 'testboek' , 1 , SYSDATE) ");
			ResultSet rs3 = ps3.executeQuery();
			rs3.close();
			ps3.close();
			PreparedStatement ps4 = connection
					.prepareStatement("INSERT INTO GEBRUIKERS (klantnr, VOORNAAM, TUSSENVOEGSEL, ACHTERNAAM, ADRES, POSTCODE, EMAIL, WACHTWOORD, TELEFOONNUMMER, REKENINGNUMMER, PLAATS) VALUES (2, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, gebruiker.getVoornaam());
			ps.setString(2, gebruiker.getTussenvoegsel());
			ps.setString(3, gebruiker.getAchternaam());
			ps.setString(4, gebruiker.getAdres());
			ps.setString(5, gebruiker.getPostcode());
			ps.setString(6, gebruiker.getEmail());
			ps.setString(7, gebruiker.getWachtwoord());
			ps.setInt(8, gebruiker.getTelefoonnummer());
			ps.setInt(9, gebruiker.getRekeningnummer());
			ps.setString(10, gebruiker.getPlaats());

			ResultSet rs4 = ps4.executeQuery();

			ps4.close();
			rs4.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
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
	@Test
	public void aanbiedingToevoegenTest(){
		try{
		VeilingService.voegVeilingToe(aanbieding);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding kon niet in de database gezet worden"), e);
		}
	}
	@Test (expected = SQLException.class)
	public void aanbiedingToevoegenZonderEindtijd() throws SQLException{
		aanbieding.setEindtijd(null);
		if(!
				VeilingService.voegVeilingToe(aanbieding)){
					Exception e = new Exception();
					aanbieding.setEindtijd(eind);
					throw new SQLException(e.getMessage());
				}	
		aanbieding.setEindtijd(eind);
	}
	@Test (expected = SQLException.class)
	public void aanbiedingToevoegenZonderKlantnummer() throws SQLException{
		aanbieding.setGebruikers_klantnr(0);
		if(!
				VeilingService.voegVeilingToe(aanbieding)){
					Exception e = new Exception();
					aanbieding.setGebruikers_klantnr(6);
					throw new SQLException(e.getMessage());
				}	
		aanbieding.setGebruikers_klantnr(6);
	}
	@Test (expected = SQLException.class)
	public void aanbiedingToevoegenZonderIsbn() throws SQLException{
		aanbieding.setDrukken_isbn("");
		if(!
				VeilingService.voegVeilingToe(aanbieding)){
					Exception e = new Exception();
					aanbieding.setDrukken_isbn("testboek");
					throw new SQLException(e.getMessage());
				}	
		aanbieding.setDrukken_isbn("testboek");
	}
	@Test
	public void bodToevoegenTest(){
		try{
		VeilingService.bieden(bod);
		}catch(Exception e){
			assertEquals(new Exception(
					"bod kon niet in de database gezet worden"), e);
		}
	}
	@Test
	public void aanbiedingHalenTest(){
		try{
		VeilingService.getAanbieding(9);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding halen niet gelukt"), e);
		}
	}
	@Test
	public void aanbiedingHalenTest2(){
		try{
		VeilingService.getBiedingenById(9);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding halen niet gelukt"), e);
		}
	}
	@Test
	public void aanbiedingHalenZonderCategorie(){
		try{
		VeilingService.retrieveVeilingen("0");
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding halen niet gelukt"), e);
		}
	}
	@Test
	public void aanbiedingHalenMetCategorie(){
		try{
		VeilingService.retrieveVeilingen("1");
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding halen niet gelukt"), e);
		}
	}
	@Test
	public void aanbiedingHalenTest3(){
		try{
		VeilingService.updateEindtijdAanbieding(aanbieding);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding halen niet gelukt"), e);
		}
	}
	@Test
	public void gebruikersHalenEmail(){
		try{
		VeilingService.checkEmail("joeltroost@hotmail.com");
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruiker halen niet gelukt"), e);
		}
	}
	@Test
	public void gebruikersHalenKlantnummer(){
		try{
		VeilingService.retrieveUser(6);
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruiker halen niet gelukt"), e);
		}
	}
	@Test
	public void gebruikerslijstHalen(){
		try{
		VeilingService.getGebruikerslijst();
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruikerslijst halen niet gelukt"), e);
		}
	}
	@Test
	public void boekHalen1(){
		try{
		VeilingService.checkBoek("1234567890");
		}catch(Exception e){
			assertEquals(new Exception(
					"boek halen niet gelukt"), e);
		}
	}
	@Test
	public void boekHalen2(){
		try{
		VeilingService.getBoek("1234567890");
		}catch(Exception e){
			assertEquals(new Exception(
					"boek halen niet gelukt"), e);
		}
	}
	@Test
	public void categorieHalen(){
		try{
		VeilingService.getCategorielijst();
		}catch(Exception e){
			assertEquals(new Exception(
					"categorie halen niet gelukt"), e);
		}
	}
	@Test
	public void checkDruk(){
		try{
		VeilingService.checkDruk("1234567890", 1);
		}catch(Exception e){
			assertEquals(new Exception(
					"druk checken niet gelukt"), e);
		}
	}
	@Test
	public void verwijderAanbieding(){
		try{
		VeilingService.deleteAanbieding(aanbieding);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding verwijderen niet gelukt"), e);
		}
	}
	@Test
	public void pasAanbiedingAan(){
		try{
			aanbieding.setDrukken_isbn("1234567890");
		VeilingService.aanbiedingWijzigen(aanbieding);
		}catch(Exception e){
			assertEquals(new Exception(
					"aanbieding wijzigen niet gelukt"), e);
		}
	}
	@Test
	public void pasKlantAan(){
		try{
			gebruiker.setEmail("noggeenemail@nisk.nl");
		VeilingService.updateGebruiker(gebruiker.getVoornaam(), gebruiker.getTussenvoegsel(), gebruiker.getAchternaam(), gebruiker.getAdres(), gebruiker.getPostcode(), gebruiker.getPlaats(), gebruiker.getEmail(), gebruiker.getTelefoonnummer(), gebruiker.getRekeningnummer(), 2);
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruiker wijzigen niet gelukt"), e);
		}
	}
	@Test
	public void pasKredietAan1(){
		try{
		VeilingService.updateKrediet(2, 90);
		}catch(Exception e){
			assertEquals(new Exception(
					"krediet wijzigen niet gelukt"), e);
		}
	}
	@Test
	public void pasKredietAan2(){
		try{
		VeilingService.kredietInleveren(2, 50);
		}catch(Exception e){
			assertEquals(new Exception(
					"krediet wijzigen niet gelukt"), e);
		}
	}
	@Test
	public void blokkeerGebruiker(){
		try{
		VeilingService.blockUser(2);
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruiker blokeren niet gelukt"), e);
		}
	}
	@Test
	public void deblokkeerGebruiker(){
		try{
		VeilingService.deblockUser(2);
		}catch(Exception e){
			assertEquals(new Exception(
					"gebruiker deblokeren niet gelukt"), e);
		}
	}
	@Test
	public void adminGebruiker(){
		try{
		VeilingService.giveAdmin(2);
		}catch(Exception e){
			assertEquals(new Exception(
					"admin maken niet gelukt"), e);
		}
	}
	@Test
	public void de_adminGebruiker(){
		try{
		VeilingService.takeAdmin(2);
		}catch(Exception e){
			assertEquals(new Exception(
					"ontadminnen niet gelukt"), e);
		}
	}
	@Test
	public void boekenlijstHalen(){
		try{
		VeilingService.getBoekenlijst();
		}catch(Exception e){
			assertEquals(new Exception(
					"boekenlijst halen niet gelukt"), e);
		}
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
					.prepareStatement("delete from gebruikers where voornaam = 'testacount' and achternaam = 'testacount' or voornaam = 'testacount2' and achternaam = 'testacount2'");
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
			PreparedStatement ps4 = connection
					.prepareStatement("delete from biedingen where aanbiedingen_id = 9");
			ResultSet rs4 = ps4.executeQuery();
			rs4.close();
			ps4.close();
			PreparedStatement ps5 = connection
					.prepareStatement("delete from aanbiedingen where drukken_boeken_isbn = 'testboek' or id= 8");
			ResultSet rs5 = ps5.executeQuery();
			rs5.close();
			ps5.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GetConnection.closeConnection();
	}
}
