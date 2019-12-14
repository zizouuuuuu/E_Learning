package Model;

import java.sql.Date;

public class Blog {
	
	private int numB;
	private String nomB,contenu, photo;
	private Date dateC, dateExp;

	public Blog(int numB, String nomB, Date dateC, String contenu, Date dateExp, String photo) {
		this.numB = numB;
		this.setNomB(nomB);
		this.setDateC(dateC);
		this.setContenu(contenu);
		this.setDateExp(dateExp);
		this.setPhoto(photo);
		
	}
	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	public String getNomB() {
		return nomB;
	}
	public void setNomB(String nomB) {
		this.nomB = nomB;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDateExp() {
		return dateExp;
	}
	public void setDateExp(Date dateExp) {
		this.dateExp = dateExp;
	}
	
}
