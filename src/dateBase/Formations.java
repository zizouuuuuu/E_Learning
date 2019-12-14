package dateBase;

import java.sql.*;
import java.util.ArrayList;

public class Formations extends BD {

	public static int getNumF(String nomF) {
		try (
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("select numF from formation where nomF=?");
		) {
			pr.setString(1, nomF);
			ResultSet r = pr.executeQuery();

			if (r.next()) return r.getInt("numF");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}


	public static ArrayList<String> afficherFormation(int id){
		ArrayList<String> frm = new ArrayList<>();

		try(
				Connection con = connect();

				PreparedStatement pr = con.prepareStatement("select nomF from formation where id=?");
		) {
			pr.setInt(1,id);
			ResultSet r = pr.executeQuery();
			while(r.next()){
				frm.add(r.getString("nomF"));
			}
			System.out.println("Affichage des formation reussi");
			return frm;

		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
			return null;
	}

	public static void supprimerFormation(int numF){
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("delete from coursF where numF=?");
				PreparedStatement pr1 = con.prepareStatement("delete from accee where numF=?");
				PreparedStatement pr2 = con.prepareStatement("select idQuiz from Quiz where numF=?");
				PreparedStatement pr3 = con.prepareStatement("delete from Question where idQuiz=?");
				PreparedStatement pr4 = con.prepareStatement("delete from Quiz where numF=?");
				PreparedStatement pr5 = con.prepareStatement("delete from formation where numF=?");
		) {
		    pr.setInt(1,numF);
		    pr.execute();

            pr1.setInt(1,numF);
            pr1.execute();

            pr2.setInt(1,numF);
            ResultSet r = pr2.executeQuery();
            if(r.next()) {
				pr3.setInt(1, r.getInt("idQuiz"));
				pr3.execute();
			}

            pr4.setInt(1,numF);
            pr4.execute();

            pr5.setInt(1, numF);
            pr5.execute();

			System.out.println("Suppression de la formation");

		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void ajouterFormation(String nomF, int id) {
		
		try(
				Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("insert into formation(nomF,id)values(?,?)");
				){
			
			pr.setString(1,nomF);
			pr.setInt(2,id);
			
			pr.execute();
			
				System.out.println("Creation de la formation avec succée");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	
	public static void modifierFormation(int numF, String nomF, Date dateC) {
		
		try(
				Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("update formation set nomF=?, dateC=? where numF=?");
				){
			
			pr.setString(1,nomF);
			pr.setDate(2,dateC);
			pr.setInt(3,numF);
			
			pr.execute();
			
				System.out.println("Modification éffectuée avec succée");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
public static void gererDroitAcces(ArrayList<Integer> app, int numF){
		
		try(
				Connection con = connect();
				
				){
			
			for(int i=0;i<app.size();i++) {
				
		        PreparedStatement pr = con.prepareStatement("insert into accee(matricule,numF)values(?,?)");
				
				pr.setInt(1,app.get(i));
				pr.setInt(2,numF);
				pr.execute();
				
				System.out.println("Accee des etudiants vers le cours est effecté");
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
