package fr.eni.bataille.main;

import fr.eni.bataille.bo.Carte;
import fr.eni.bataille.bo.Deck;
import fr.eni.bataille.bo.Joueur;
import fr.eni.bataille.bo.Match;

import java.util.Scanner;

/** Simulation de bataille entre deux joueurs
 *
 * @author laz_R
 * @version 1.0
 */
public class main {

    public static void main(String[] args) {

        // Déclaration d'instances
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        Match match = new Match();

        // Variables
        Carte[] deck_actuel;

        // TRAITEMENT PRINCIPAL

        System.out.println("******* BATAILLE *******");
        System.out.println();

        // Demande identité joueur 1
        System.out.println("Prénom du Joueur 1 ?");
        String prenom_joueur_1 = scan.nextLine();
        System.out.println("Nom du Joueur 1 ?");
        String nom_joueur_1 = scan.nextLine();
        Joueur joueur1 = new Joueur(nom_joueur_1, prenom_joueur_1);

        // Demande identité joueur 2
        System.out.println("Prénom du Joueur 2 ?");
        String prenom_joueur_2 = scan.nextLine();
        System.out.println("Nom du Joueur 2 ?");
        String nom_joueur_2 = scan.nextLine();
        Joueur joueur2 = new Joueur(nom_joueur_2, prenom_joueur_2);

        // Demande du nombre de manche gagnantes
        System.out.println("Nombre de manches à gagner pour remporter le match ?");
        int nbr_manches_gagnantes = scan.nextInt();
        scan.nextLine();
        System.out.println();

        // Initialisation du match
        deck_actuel = deck.nouveau_deck();
        System.out.printf("%s %s * VS * %s %s%n[%d manche(s) gagnante(s)]%n%n", joueur1.getPrenom(), joueur1.getNom(), joueur2.getPrenom(), joueur2.getNom(), nbr_manches_gagnantes);
        System.out.println("Appuyez sur [ENTRÉE] pour continuer");
        scan.nextLine();

        // Début du match
        match.matchComplet(joueur1, joueur2, deck_actuel, nbr_manches_gagnantes);

    }
}
