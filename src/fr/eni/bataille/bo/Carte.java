package fr.eni.bataille.bo;

import fr.eni.bataille.enumerations.Couleur;
import fr.eni.bataille.enumerations.Valeur;

/** Classe qui représente une carte à jouer (avec sa couleur et sa valeur)
 *
 * @author laz_R
 * @version 1.0
 */
public class Carte {

    // Attributs d'instance
    private Couleur couleur;
    private Valeur valeur;
    private Joueur possesseur;

    //Attributs de classe

    //Méthodes

    /** Constructeur avec tous les paramètres (sauf possésseur, il ne s'ajoute lui même qu'au moment de la pioche)
     *
     * @param couleur enum Couleur
     * @param valeur enum Valeur
     */
    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    public Joueur getPossesseur() {
        return possesseur;
    }

    public void setPossesseur(Joueur possesseur) {
        this.possesseur = possesseur;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "couleur=" + couleur +
                ", valeur=" + valeur +
                '}';
    }
}
