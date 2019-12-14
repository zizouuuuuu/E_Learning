package dateBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends BD {
	
	public static int Connect(String username, String password) {
		
		try{
			Connection con = connect();
			
			PreparedStatement ps,pc;
			ps = con.prepareStatement("Select * from user where Nom=? and password=?");
			ps.setString(1, username);
		    ps.setString(2, password);
			ResultSet re = ps.executeQuery();
			
			pc = con.prepareStatement("delete from Connecter");
			
			if(re.next()) {
				
				if(re.getBoolean("admin")) 
					{
					
					pc.execute();
					PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom) values(?,?,?)");
					p.setInt(1, re.getInt("numUser"));
					p.setString(2,re.getString("nom"));
					p.setString(3,re.getString("prenom"));
					p.execute();
					  return 0;
					}
				else if(re.getBoolean("instructeur")) 
					{
					
					pc.execute();
						PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom) values(?,?,?)");
						p.setInt(1, re.getInt("numUser"));
						p.setString(2,re.getString("nom"));
						p.setString(3,re.getString("prenom"));
					p.execute();
					  return 1;	
					}
				else if(re.getBoolean("apprenant")) 
					{
					
					pc.execute();
						PreparedStatement p = con.prepareStatement( "Insert into Connecter(id,nom,prenom) values(?,?,?)");
						p.setInt(1, re.getInt("numUser"));
						p.setString(2,re.getString("nom"));
						p.setString(3,re.getString("prenom"));
					p.execute();
					return 2;	
					}
				
				
			}
			else ps.close();
			
			return -1;
		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
}
