package fr.eni.bataille.bo;

public class Match {

    public Carte qui_gagne(Carte c01, Carte c02) {
        if (c01.getValeur().ordinal() < c02.getValeur().ordinal()) {
            return c01;
        }
        else{
            return c02;
        }
    }

    public void pli(Joueur joueur1, Joueur joueur2, Carte[] paquet_cartes) {
        Carte c01 = joueur1.piocherCarte(paquet_cartes);
        System.out.printf("%s %s a pioché %s de %s%n", joueur1.getPrenom(), joueur1.getNom(), c01.getValeur(), c01.getCouleur());
        Carte c02 = joueur2.piocherCarte(paquet_cartes);
        System.out.printf("%s %s a pioché %s de %s%n", joueur2.getPrenom(), joueur2.getNom(), c02.getValeur(), c02.getCouleur());
        System.out.println();
        if (c01.getValeur().ordinal() != c02.getValeur().ordinal()) {
            Carte carte_gagnante = qui_gagne(c01, c02);
            System.out.printf("%s %s gagne le pli !%n", carte_gagnante.getPossesseur().getPrenom(), carte_gagnante.getPossesseur().getNom());
            carte_gagnante.getPossesseur().setPlis_gagnes(carte_gagnante.getPossesseur().getPlis_gagnes() + 1);
        }
        else {
            System.out.println("Égalité !");
        }
    }
}
