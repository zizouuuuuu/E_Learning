package dateBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BD {
	public static Connection connect()
	{
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			return DriverManager.getConnection("jdbc:ucanaccess://DateBase.accdb");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}


