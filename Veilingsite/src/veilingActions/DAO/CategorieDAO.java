package veilingActions.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import veilingActions.database.GetConnection;
import veilingDomain.Boek;
import veilingDomain.Categorie;
import veilingInterface.VeilingInterface;

public class CategorieDAO implements VeilingInterface<Categorie> {
	private static ArrayList<Categorie> categorielijst = new ArrayList<Categorie>();

	@Override
	public boolean create(Object T) {
		return false;

	}

	@Override
	public Categorie retrieve(String ID) {
		Categorie categorie = null;
		try {
			Connection connection = null;
			connection = GetConnection.getDBConnection();
			if (connection != null) {
				System.out.println("|| Connection ready || ");
			} else {
				System.out.println("|| Connection failed ||");
			}
			PreparedStatement ps3 = connection
					.prepareStatement("select * from categorie");
			ResultSet rs3 = ps3.executeQuery();
			categorielijst.clear();
			while (rs3.next()) {
				String naam = rs3.getString("naam");
				int categorieboek = rs3.getInt("id");
				categorie = new Categorie(categorieboek, naam);
				categorielijst.add(categorie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		GetConnection.closeConnection();
		return categorie;
	}

	@Override
	public void update(Object T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object T) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Categorie> getCategorielijst() {
		return categorielijst;
	}

	public static void setCategorielijst(ArrayList<Categorie> categorielijst) {
		CategorieDAO.categorielijst = categorielijst;
	}
	
}
