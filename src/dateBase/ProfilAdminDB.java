package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Administrateur;

public class ProfilAdminDB extends BD{
	
	public static ArrayList<Administrateur> display() {
		
		ArrayList<Administrateur> admin = new ArrayList<>();
		try( Connection con = connect();
				PreparedStatement pr = con.prepareStatement("Select * from admin");
				){
			   ResultSet r = pr.executeQuery();
			while(r.next()) {
				admin.add(new Administrateur(r.getInt("id"),r.getString("nom"),r.getString("prenom"),r.getDate("dateNaiss"),r.getString("adresse"),0, r.getString("password")));
				
				System.out.println("Affichage reussie");
				con.close();
				return admin;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
				
		return null;
	}

	public static void modify(int id,String nom, String prenom, String string, String adresse,String password) {
		
		try( Connection con = connect();
				PreparedStatement pr1 = con.prepareStatement("Update admin set nom=?,prenom=?, dateNaiss=?, adresse=?, password=? where id=? ");

				){
			    
			  pr1.setInt(1, id);
			  pr1.setString(2,nom);
			  pr1.setString(3,prenom);
			  pr1.setString(4,string);
			  pr1.setString(5,adresse);
			  pr1.setString(6,password);
			  
			  pr1.execute();
			  System.out.println("Modification effectue avec succee");
			  
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
