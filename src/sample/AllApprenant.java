package sample;

public class AllApprenant {

    private String nom, prenom, specialite;
    private int matricule;

    public AllApprenant(int matricule,String nom, String prenom, String specialite){
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.matricule = matricule;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    public String toString(){
        return nom+" "+prenom+" "+specialite;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }
}
