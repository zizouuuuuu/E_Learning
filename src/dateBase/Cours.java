package dateBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Cour;
import com.sun.source.tree.ConditionalExpressionTree;


public class Cours extends BD{

	public static void creerCour(String titre, String path,int numF) {
		try(
		Connection con = connect();

		PreparedStatement pr = con.prepareStatement("insert into coursF(titre,path,numF)values(?,?,?)");
		){

	pr.setString(1,titre);
	pr.setString(2,path);
	pr.setInt(3,numF);

	pr.execute();

		System.out.println("Creation du cour avec succé");

}catch(SQLException e) {
	System.out.println(e.getMessage());
}
	}


	public static ArrayList<String> afficherCours(int numF) {
		ArrayList<String> cours = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select titre from coursF where numF=?");
				){

			pr.setInt(1,numF);
			ResultSet rs = pr.executeQuery();
				while(rs.next()) {
				cours.add((rs.getString("titre")));
					}
			return cours;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	public static String getPath(String titre){
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select path from coursF where titre=?");
				){
			pr.setString(1,titre);
			ResultSet r = pr.executeQuery();

			if(r.next()){
				return r.getString("path");
			}
			else return null;

		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void supprimerCour(String titre){
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("delete from coursF where titre=?");
				){
			pr.setString(1,titre);
			pr.execute();

			System.out.println("Suppression du cour effectué");

		}catch (SQLException e){
			System.out.println(e.getMessage());
		}



	}
}
