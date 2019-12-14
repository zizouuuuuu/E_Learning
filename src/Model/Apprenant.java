package Model;

import java.sql.Date;

public class Apprenant extends User implements GestionResInsApp{

	private int matricule,section,niveau;
	private String filiere,specialite;
	
	public Apprenant(int matricule,String nom, String prenom, Date date, String adresse,String password ,int s,int niv,String sp) {
		super(nom, prenom, date, adresse,0,password);
		
		this.matricule = matricule;
		section = s;
		niveau = niv;
		
		specialite = sp;
	
	}
	
	public void setMatricule(int mat) {
		matricule = mat;
	}
	public int getMatricule() {
		return matricule;
	}
	
	 public int getSection() {
		return section;
	}
	
	public void setSection(int s) {
		section = s;
	}
	
	public int getNiv() {
		return niveau;
	}
	
	public void setNiv(int n) {
		niveau = n;
	}
	
	public String getfiliere() {
		return filiere;
	}
	
	public void setFiliere(String f) {
		filiere = f;
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
