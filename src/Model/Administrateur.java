package Model;

import java.sql.Date;

public class Administrateur extends User {
	private int id;
	public Administrateur(int id,String nom, String prenom, Date date, String adresse, int tel,String password) {
	super(nom, prenom, date, adresse,tel,password);
	this.id = id;
	
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	
}

