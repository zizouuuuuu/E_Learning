package dateBase;

import java.sql.*;
import java.util.ArrayList;

import Model.Sondage;
import org.hsqldb.SqlInvariants;
import sample.listTwoPar;

import javax.print.attribute.ResolutionSyntax;

public class SondageBD extends BD{
	
	public static void creerSondage(String titre, String contenu, String choix1, String choix2, String choix3, String choix4, int numUser, String createur) {
		
		try(  
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("insert into sondage(titre,contenu,choix1,choix2,choix3,choix4,numUser,createur) values(?,?,?,?,?,?,?,?)");
				
				){

			pr.setString(1,titre);
			pr.setString(2,contenu);
			pr.setString(3,choix1);
			pr.setString(4,choix2);
			pr.setString(5,choix3);
			pr.setString(6,choix4);
			pr.setInt(7,numUser);
			pr.setString(8,createur);
			pr.execute();
						
			System.out.println("Creation du sondage éffectué");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static ArrayList<listTwoPar> afficherSondage(){
		ArrayList<listTwoPar> s = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select titre,createur from sondage");
		) {
			ResultSet r = pr.executeQuery();

			while(r.next()){
				s.add(new listTwoPar(r.getString("titre"), r.getString("createur")));
			}
			return s;

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	public static ArrayList<Sondage> consulterSondage(String titre) {
		ArrayList<Sondage> snd = new ArrayList<>();
			try(
					Connection con = connect();
					PreparedStatement pr = con.prepareStatement("select * from sondage where titre=?")
			){
			
			pr.setString(1,titre);
			ResultSet rs = pr.executeQuery();
			
			if(rs.next()) {
				snd.add(new Sondage(rs.getInt("numS"),titre, rs.getString("contenu"), rs.getString("choix1"), rs.getString("choix2"), rs.getString("choix3"), rs.getString("choix4"), rs.getInt("numUser"), rs.getString("createur"), rs.getInt("nb1"), rs.getInt("nb2"), rs.getInt("nb3"), rs.getInt("nb4"), rs.getInt("nbPart")));
				return snd;
			}
			else return null;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	

	
	public static int getIdSondage(String titre){
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select numS from sondage where titre=?");
		){
		pr.setString(1,titre);

		ResultSet r = pr.executeQuery();

		if(r.next()) return r.getInt("numS");

		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
			return -1;
	}

	public static void participer1(String titre) {
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("update sondage set nb1=nb1+1, nbPart=nbPart+1 where titre=?");
				){

			pr.setString(1, titre);
			pr.execute();
			
			System.out.println("Ajout participation");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			
		
		
	}

	public static void participer2(String titre) {
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("update sondage set nb2=nb2+1,nbPart=nbPart+1 where titre=?");
		){

			pr.setString(1, titre);
			pr.execute();

			System.out.println("Ajout participation");

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}



	}

    public static void participer3(String titre) {
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("update sondage set nb3=nb3+1,nbPart=nbPart+1 where titre=?");
        ){

            pr.setString(1, titre);
            pr.execute();

            System.out.println("Ajout participation");

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    public static void participer4(String titre) {
        try(
                Connection con = connect();
                PreparedStatement pr = con.prepareStatement("update sondage set nb4=nb4+1,nbPart=nbPart+1 where titre=?");
        ){

            pr.setString(1, titre);
            pr.execute();

            System.out.println("Ajout participation");

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

	public static ArrayList<listTwoPar> getMesSondages(int numUser){
		ArrayList<listTwoPar> s = new ArrayList<>();
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("select titre, createur from sondage where numUser=?");
		){
			pr.setInt(1,numUser);

			ResultSet r = pr.executeQuery();
			while(r.next()){
				s.add(new listTwoPar(r.getString("titre"),r.getString("createur")));
			}
			System.out.println("Selection faite");
			return s;


		}catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void supprimerSondage(String titre){
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("delete from sondage where titre=?");
		){
			pr.setString(1,titre);
			pr.execute();

			System.out.println(("Suppression de votre sondage effectué"));

		}catch (SQLException e){
			System.out.println(e.getMessage());
		}

	}

}
