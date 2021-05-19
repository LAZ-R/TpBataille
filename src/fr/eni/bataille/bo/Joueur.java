package fr.eni.bataille.bo;

import java.util.Random;

/** Classe qui représente un Joueur
 *
 * @author laz_R
 * @version 1.0
 */
public class Joueur {

    // Attributs d'instance
    private String nom;
    private String prenom;
    private int plis_gagnes;
    private int manches_gagnes;

    // Méthodes

    /** Constructeur avec tous les paramètres (sauf plis gagnés et manches gagnés qui s'auto-incrémentent automatiquement)
     *
     * @param nom String
     * @param prenom String
     */
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

    public int getManches_gagnes() {
        return manches_gagnes;
    }

    public void setManches_gagnes(int manches_gagnes) {
        this.manches_gagnes = manches_gagnes;
    }

    /** Méthode qui choisi une carte au hasard d'un tableau de cartes,
     *  lui attribut le joueur concerné comme possésseur,
     *  l'enlève du paquet de cartes et la return
     *
     * @return Carte
     */
    public Carte piocherCarte(Carte[] paquet_cartes) {

        Carte carte_piochee;

        Random rand = new Random();
        int aleatoire = rand.nextInt(paquet_cartes.length);

        // Tant que le nombre choisi au hasard tombe sur une case vide du tableau
        while (paquet_cartes[aleatoire] == null) {
            // On en choisi un autre jusqu'a ce qu'il tombe sur une case non vide
            aleatoire = rand.nextInt(paquet_cartes.length);
        }

        // On extrait la carte du paquet
        carte_piochee = paquet_cartes[aleatoire];
        paquet_cartes[aleatoire] = null;

        // On lui attribut comme possésseur le joueur qui l'a pioché
        carte_piochee.setPossesseur(this);

        return carte_piochee;
    }
}
