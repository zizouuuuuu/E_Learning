package Model;

import java.sql.Date;

public class User {

	protected String nom,prenom,adresse,password;
	protected Date dateN;
	protected int tel;
	
	public User(String nom, String prenom,Date dateN,String adresse,int tel,String password) {
	this.nom = nom;
	this.prenom = prenom;
	this.dateN = dateN;
	this.adresse = adresse;
	this.tel = tel;
	this.password = password;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String n) {
		nom = n;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String p) {
		prenom = p;
	}
	
	public Date getDate() {
		return dateN;
	}
	public void setDate(Date d) {
		dateN = d;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String a) {
		adresse = a;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
}
