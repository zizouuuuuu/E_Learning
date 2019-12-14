package dateBase;

import java.sql.*;

public class Connecter extends BD {

	public static int getIdConnected() {

		try(Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("Select id from Connecter");
				){
			
			ResultSet r = pr.executeQuery();
			if(r.next())
			return r.getInt("id");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	public static String getNameConnected() {

		try(Connection con = connect();

			PreparedStatement pr = con.prepareStatement("Select nom from Connecter");
		){

			ResultSet r = pr.executeQuery();
			if(r.next())
				return r.getString("nom");

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static String getLastNameConnected() {

		try(Connection con = connect();

			PreparedStatement pr = con.prepareStatement("Select prenom from Connecter");
		){

			ResultSet r = pr.executeQuery();
			if(r.next())
				return r.getString("prenom");

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}



}
