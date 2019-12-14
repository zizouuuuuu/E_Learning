package Model;

import java.sql.Date;

public class Instructeur extends User implements GestionResInsApp {

	private int id;
	private String grade,specialite;
	
	public Instructeur(int id,String nom, String prenom, Date date, String adresse,int tel,String password , String g, String sp) {
		super(nom, prenom, date, adresse,tel,password);
		this.id = id;
		grade = g;
		specialite = sp;
		
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String g) {
		grade = g;
	}
	public String getSpec() {
		return specialite;
	}
	
	public void setSpec(String sp) {
		specialite = sp;
	}
	@Override
	public void deposer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modifier() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void gererDroitA(Apprenant a) {
		// TODO Auto-generated method stub
		
	}
}
