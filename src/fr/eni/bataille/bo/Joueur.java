package fr.eni.bataille.bo;

import java.util.Random;

public class Joueur {
    private String nom;
    private String prenom;
    private int plis_gagnes;

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public int getPlis_gagnes() {
        return plis_gagnes;
    }

    public void setPlis_gagnes(int plis_gagnes) {
        this.plis_gagnes = plis_gagnes;
    }

    public Carte piocherCarte(Carte[] paquet_cartes) {
        Carte carte_piochee;
        Random rand = new Random();
        int aleatoire = rand.nextInt(paquet_cartes.length);
        while (paquet_cartes[aleatoire] == null) {
            aleatoire = rand.nextInt(paquet_cartes.length);
        }
        carte_piochee = paquet_cartes[aleatoire];
        carte_piochee.setPossesseur(this);
        paquet_cartes[aleatoire] = null;
        return carte_piochee;
    }
}
