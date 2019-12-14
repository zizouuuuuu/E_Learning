package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Administrateur;
import Model.Instructeur;

public class ProfilInstructorDB extends BD {

	
public static ArrayList<Instructeur> display(int id) {
		
		ArrayList<Instructeur> instr = new ArrayList<>();
		try( Connection con = connect();
				PreparedStatement pr = con.prepareStatement("Select * from instructeur where id=?");
				){
			   pr.setInt(1,id);
			   ResultSet r = pr.executeQuery();
			while(r.next()) {
				instr.add(new Instructeur(r.getInt("id"),r.getString("nom"),r.getString("prenom"), r.getDate("dateNaiss"), r.getString("adresse"),id, r.getString("grade"), r.getString("specialite"), r.getString("password")));
				
				System.out.println("Affichage reussie");
				return instr;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
				
		return null;
	}

	public static void modify(int id, String nom, String prenom, String dateN, String adresse, String grade, String specialite, String password) {
		
		try( Connection con = connect();
				PreparedStatement pr1 = con.prepareStatement("Update instructeur set nom=?,prenom=?, dateNaiss=?, adresse=?, grade=?, specialite=?, password=? where id=? ");

				){
			    
			  pr1.setString(1, nom);
			  pr1.setString(2,prenom);
			  pr1.setString(3,dateN);
			  pr1.setString(4,adresse);
			  pr1.setString(5,grade);
			  pr1.setString(6,specialite);
			  pr1.setString(8,password);
			  
			  pr1.execute();
			  System.out.println("Modification effectuée avec succée");
			  
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
public static void Inscrire(int id, String nom, String prenom, Date date, String adresse, String grade,String sp,String password) {
		
		try(Connection con = connect();
		PreparedStatement pr = con.prepareStatement("Insert into instructeur(id,nom,prenom,dateNaiss,adresse,grade,specialite,password)values(?,?,?,?,?,?,?,?)");)
		{
		    pr.setInt(1,id);
		pr.setString(2,nom);
		pr.setString(3,prenom);
		pr.setDate(4,date);
		pr.setString(5,adresse);
		pr.setString(6,grade);
		pr.setString(7,sp);
		pr.setString(8,password);
		
		pr.execute();
		System.out.println("Inscription d'un instructeur");
		PreparedStatement pr1 = con.prepareStatement("Insert into user(numUser,nom,prenom,password,instructeur)values(?,?,?,?,?)");
		pr1.setInt(1,id);
		pr1.setString(2,nom);
		pr1.setString(3,prenom);
		pr1.setString(4, password);
		pr1.setBoolean(5, true);
		pr1.execute();
		
		System.out.println("Instruceur ajouté dans la table user");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		
		
	}
}
