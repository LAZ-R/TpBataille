package fr.eni.bataille.main;

import fr.eni.bataille.bo.Carte;
import fr.eni.bataille.bo.Deck;
import fr.eni.bataille.bo.Joueur;
import fr.eni.bataille.bo.Match;

public class main {
    public static void main(String[] args) {

        Deck deck = new Deck();
        Carte[] deck_actuel;
        Match match = new Match();

        // demande identité joueur 1
        Joueur joueur1 = new Joueur("fils d'Arathorn", "Aragorn,");

        // demande identité joueur 2
        Joueur joueur2 = new Joueur("Vertefeuille", "Legolas");

        // demande du nombre de manche

        // début du match

        deck_actuel = deck.nouveau_deck();

        match.pli(joueur1, joueur2, deck_actuel);

    }
}
