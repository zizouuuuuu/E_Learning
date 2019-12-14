package Model;

import java.sql.Date;

public class Sondage {
	
	private int numS,idUser;
	private String titre,contenu, choix1, choix2, choix3, choix4, createur;
    private int nb1, nb2, nb3, nb4, nbPart;

	public Sondage(int numS, String titre, String contenu, String choix1, String choix2, String choix3, String choix4, int numUser, String nom, int nb1, int nb2, int nb3, int nb4, int nbPart) {
		this.setNumS(numS);
		this.titre = titre;
		this.contenu = contenu;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.choix4 = choix4;
		this.idUser = numUser;
		this.createur = nom;
		this.nb1 = nb1;
		this.nb2 = nb2;
		this.nb3 = nb3;
		this.nb4 = nb4;
		this.nbPart = nbPart;
	}

	public int getNumS() {
		return numS;
	}

	public void setNumS(int numS) {
		this.numS = numS;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getChoix1() {
		return choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getChoix4() {
		return choix4;
	}

	public void setChoix4(String choix4) {
		this.choix4 = choix4;
	}

	public String getCreateur() {
		return createur;
	}

	public void setCreateur(String createur) {
		this.createur = createur;
	}

    public int getNb1() {
        return nb1;
    }

    public void setNb1(int nb1) {
        this.nb1 = nb1;
    }

    public int getNb2() {
        return nb2;
    }

    public void setNb2(int nb2) {
        this.nb2 = nb2;
    }

    public int getNb3() {
        return nb3;
    }

    public void setNb3(int nb3) {
        this.nb3 = nb3;
    }

    public int getNb4() {
        return nb4;
    }

    public void setNb4(int nb4) {
        this.nb4 = nb4;
    }

	public int getNbPart() {
		return nbPart;
	}

	public void setNbPart(int nbPart) {
		this.nbPart = nbPart;
	}
}
