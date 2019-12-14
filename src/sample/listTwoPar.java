package sample;

import java.util.ArrayList;

public class listTwoPar {
    private String titre,createur;

    public listTwoPar(String titre, String createur){
        this.titre = titre;
        this.createur = createur;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCreateur() {
        return createur;
    }

    public void setCreateur(String createur) {
        this.createur = createur;
    }
}
