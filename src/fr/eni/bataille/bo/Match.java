package fr.eni.bataille.bo;

import java.util.Scanner;

/** Classe qui représente un Match de bataille classique
 *
 * @author laz_R
 * @version 1.0
 */
public class Match {

    // Déclaration d'instances
    static Scanner scan = new Scanner(System.in);
    static Deck deck = new Deck();

    /** Méthode qui détermine, entre deux cartes, la plus "forte", et la return
     *
     * @param c01 Carte
     * @param c02 Carte
     * @return Carte
     */
    public Carte qui_gagne(Carte c01, Carte c02) {
        if (c01.getValeur().ordinal() < c02.getValeur().ordinal()) {
            return c01;
        }
        else{
            return c02;
        }
    }

    /** Méthode qui régit la façon dont se déroule un pli entre deux joueurs et un paquet de cartes
     *
     * @param joueur1 Joueur
     * @param joueur2 Joueur
     * @param paquet_cartes Carte[]
     */
    public void pli(Joueur joueur1, Joueur joueur2, Carte[] paquet_cartes) {

        // Pioche du 1er joueur
        Carte c01 = joueur1.piocherCarte(paquet_cartes);
        System.out.printf("%s %s a pioché : %s de %s%n", joueur1.getPrenom(), joueur1.getNom(), c01.getValeur(), c01.getCouleur());

        // Pioche du 2ème joueur
        Carte c02 = joueur2.piocherCarte(paquet_cartes);
        System.out.printf("%s %s a pioché : %s de %s%n", joueur2.getPrenom(), joueur2.getNom(), c02.getValeur(), c02.getCouleur());
        System.out.println();

        // Cas normal : Pas d'égalité de valeur
        if (c01.getValeur().ordinal() != c02.getValeur().ordinal()) {
            // On détermine quelle est la carte gagnante
            Carte carte_gagnante = qui_gagne(c01, c02);
            System.out.printf("%s %s gagne le pli !%n", carte_gagnante.getPossesseur().getPrenom(), carte_gagnante.getPossesseur().getNom());

            // Incrémente le nombre de plis gagnés par le joueur qui a gagné le pli
            carte_gagnante.getPossesseur().setPlis_gagnes(carte_gagnante.getPossesseur().getPlis_gagnes() + 1);
        }

        // Cas où les valeurs des cartes sont identiques
        else {
            System.out.println("Égalité !");
        }
    }

    /** Méthode qui régit la façon dont se déroule une manche entre deux joueurs
     *  (Ils'affrontent aux plis juqu'a ce qu'il n'y ai plus de cartes dans le paquet)
     *
     * @param joueur1 Joueur
     * @param joueur2 Joueur
     * @param paquet_cartes Carte[]
     */
    public void manche(Joueur joueur1, Joueur joueur2, Carte[] paquet_cartes) {

        // Initialisation du nombre de carte dans le paquet
        int total_cartes_dans_paquet = 52;

        // On (ré)initialise le nombre de pli gagnés de chaque joueur
        joueur1.setPlis_gagnes(0);
        joueur2.setPlis_gagnes(0);

        // Tant qu'il reste des cartes dans le paquet de cartes
        while (total_cartes_dans_paquet > 0) {

            // Les joueurs s'affrontent aux plis
            pli(joueur1, joueur2, paquet_cartes);

            // Recalcul et affichage du nombre de cartes restantes dans le paquet
            total_cartes_dans_paquet = 0;
            for (int i = 0; i < paquet_cartes.length; i++) {
                if (paquet_cartes[i] != null) {
                    total_cartes_dans_paquet += 1;
                }
            }
            System.out.printf("Cartes restantes : %d%n%n", total_cartes_dans_paquet);

            // À décommenter pour avoir une interaction utilisateur à chaque pli
            //System.out.println("Appuyez sur [ENTRÉE] pour continuer");
            //scan.nextLine();

        }

        // Affiche le vainqueur de la manche et incrémente son nombre de manches gagnées
        if (joueur1.getPlis_gagnes() > joueur2.getPlis_gagnes()) {
            System.out.printf("%s %s remporte la manche !%n%n", joueur1.getPrenom(), joueur1.getNom());
            joueur1.setManches_gagnes(joueur1.getManches_gagnes() + 1);
        }
        else if (joueur2.getPlis_gagnes() > joueur1.getPlis_gagnes()) {
            System.out.printf("%s %s remporte la manche !%n%n", joueur2.getPrenom(), joueur2.getNom());
            joueur2.setManches_gagnes(joueur2.getManches_gagnes() + 1);
        }

        // En cas d'égalité, personne ne remporte la manche
        else {
            System.out.println("Égalité sur la manche, personne ne la remporte !");
            System.out.println();
        }
    }

    /** Méthode qui régit la façon dont se déroule un match entre deux joueurs (en X manches gagnantes)
     *
     * @param joueur1 Joueur
     * @param joueur2 Joueur
     * @param paquet_cartes Carte[]
     * @param nombre_de_manches_a_gagner int
     */
    public void matchComplet(Joueur joueur1, Joueur joueur2, Carte[] paquet_cartes, int nombre_de_manches_a_gagner) {

        // Initialise le nombre de manches gagnées à 0 pour chaque joueur
        joueur1.setManches_gagnes(0);
        joueur2.setManches_gagnes(0);

        // Tant qu'aucun des deux joueurs n'a atteint le nombre de manches gagnées requis pour remporter le match
        while (joueur1.getManches_gagnes() < nombre_de_manches_a_gagner && joueur2.getManches_gagnes() < nombre_de_manches_a_gagner) {

            // Ils s'affrontent dans une manche
            manche(joueur1,joueur2,paquet_cartes);
            // puis on rempli à nouveau le paquet de carte
            paquet_cartes = deck.nouveau_deck();

            // Affichage du total de manches gagnées par chaque joueur
            System.out.printf("%s %s • manches gagnées : %d/%d%n", joueur1.getPrenom(), joueur1.getNom(), joueur1.getManches_gagnes(), nombre_de_manches_a_gagner);
            System.out.printf("%s %s • manches gagnées : %d/%d%n%n", joueur2.getPrenom(), joueur2.getNom(), joueur2.getManches_gagnes(), nombre_de_manches_a_gagner);

            // À décommenter si on veut une interaction utilisateur entre chaque manche
            System.out.println("Appuyez sur [ENTRÉE] pour continuer");
            scan.nextLine();
        }

        // Affichage du vainqueur
        if (joueur1.getManches_gagnes() >= nombre_de_manches_a_gagner) {
            System.out.printf("%s %s remporte le match !!!%n", joueur1.getPrenom(), joueur1.getNom());
        }
        else {
            System.out.printf("%s %s remporte le match !!!%n", joueur2.getPrenom(), joueur2.getNom());
        }
    }
}
