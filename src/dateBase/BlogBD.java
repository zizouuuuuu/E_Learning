package dateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Blog;

import java.sql.Date;

public class BlogBD extends BD {

	public static void CreerBlog(int id,String nomB, Date dateC, String contenu, Date dateExp, String photo) {
		
		try(
				Connection con = connect();
				
				PreparedStatement pr = con.prepareStatement("insert into blog(nomB,dateC,contenu,dateExp,photo,numUser)values(?,?,?,?,?,?)");
				){
				
			pr.setString(1,nomB);
			pr.setDate(2,dateC);
			pr.setString(3,contenu);
			pr.setDate(4,dateExp);
			pr.setString(5,photo);
			pr.setInt(6,id);
			pr.execute();
			
			System.out.println("Creation du blog effecuté");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static ArrayList<Blog> partager(int numB) {
		
		ArrayList<Blog> bl = new ArrayList<>();
		
		try(
				Connection con = connect();
				PreparedStatement pr = con.prepareStatement("Select * from blog where numB=?");
				){
				
			pr.setInt(1,numB);
			ResultSet r = pr.executeQuery();
			
			if(r.next()) {
				bl.add(new Blog(r.getInt("numB"), r.getString("nomB"), r.getDate("dateC"), r.getString("contenu"), r.getDate("dateExp"), r.getString("photo")));
				System.out.println("Partage effectué");
				return bl;
			}
			else { System.out.println("Partage impossible");
			return null;
			}
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}
}
