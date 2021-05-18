package fr.eni.bataille.bo;

import fr.eni.bataille.enumerations.Couleur;
import fr.eni.bataille.enumerations.Valeur;

public class Deck {

    public Carte[] nouveau_deck() {
        Carte[] deck_complet = new Carte[52];

        deck_complet[0] = new Carte(Couleur.CARREAU, Valeur.AS);
        deck_complet[1] = new Carte(Couleur.CARREAU, Valeur.ROI);
        deck_complet[2] = new Carte(Couleur.CARREAU, Valeur.DAME);
        deck_complet[3] = new Carte(Couleur.CARREAU, Valeur.VALET);
        deck_complet[4] = new Carte(Couleur.CARREAU, Valeur.DIX);
        deck_complet[5] = new Carte(Couleur.CARREAU, Valeur.NEUF);
        deck_complet[6] = new Carte(Couleur.CARREAU, Valeur.HUIT);
        deck_complet[7] = new Carte(Couleur.CARREAU, Valeur.SEPT);
        deck_complet[8] = new Carte(Couleur.CARREAU, Valeur.SIX);
        deck_complet[9] = new Carte(Couleur.CARREAU, Valeur.CINQ);
        deck_complet[10] = new Carte(Couleur.CARREAU, Valeur.QUATRE);
        deck_complet[11] = new Carte(Couleur.CARREAU, Valeur.TROIS);
        deck_complet[12] = new Carte(Couleur.CARREAU, Valeur.DEUX);

        deck_complet[13] = new Carte(Couleur.COEUR, Valeur.AS);
        deck_complet[14] = new Carte(Couleur.COEUR, Valeur.ROI);
        deck_complet[15] = new Carte(Couleur.COEUR, Valeur.DAME);
        deck_complet[16] = new Carte(Couleur.COEUR, Valeur.VALET);
        deck_complet[17] = new Carte(Couleur.COEUR, Valeur.DIX);
        deck_complet[18] = new Carte(Couleur.COEUR, Valeur.NEUF);
        deck_complet[19] = new Carte(Couleur.COEUR, Valeur.HUIT);
        deck_complet[20] = new Carte(Couleur.COEUR, Valeur.SEPT);
        deck_complet[21] = new Carte(Couleur.COEUR, Valeur.SIX);
        deck_complet[22] = new Carte(Couleur.COEUR, Valeur.CINQ);
        deck_complet[23] = new Carte(Couleur.COEUR, Valeur.QUATRE);
        deck_complet[24] = new Carte(Couleur.COEUR, Valeur.TROIS);
        deck_complet[25] = new Carte(Couleur.COEUR, Valeur.DEUX);

        deck_complet[26] = new Carte(Couleur.PIQUE, Valeur.AS);
        deck_complet[27] = new Carte(Couleur.PIQUE, Valeur.ROI);
        deck_complet[28] = new Carte(Couleur.PIQUE, Valeur.DAME);
        deck_complet[29] = new Carte(Couleur.PIQUE, Valeur.VALET);
        deck_complet[30] = new Carte(Couleur.PIQUE, Valeur.DIX);
        deck_complet[31] = new Carte(Couleur.PIQUE, Valeur.NEUF);
        deck_complet[32] = new Carte(Couleur.PIQUE, Valeur.HUIT);
        deck_complet[33] = new Carte(Couleur.PIQUE, Valeur.SEPT);
        deck_complet[34] = new Carte(Couleur.PIQUE, Valeur.SIX);
        deck_complet[35] = new Carte(Couleur.PIQUE, Valeur.CINQ);
        deck_complet[36] = new Carte(Couleur.PIQUE, Valeur.QUATRE);
        deck_complet[37] = new Carte(Couleur.PIQUE, Valeur.TROIS);
        deck_complet[38] = new Carte(Couleur.PIQUE, Valeur.DEUX);

        deck_complet[39] = new Carte(Couleur.TREFLE, Valeur.AS);
        deck_complet[40] = new Carte(Couleur.TREFLE, Valeur.ROI);
        deck_complet[41] = new Carte(Couleur.TREFLE, Valeur.DAME);
        deck_complet[42] = new Carte(Couleur.TREFLE, Valeur.VALET);
        deck_complet[43] = new Carte(Couleur.TREFLE, Valeur.DIX);
        deck_complet[44] = new Carte(Couleur.TREFLE, Valeur.NEUF);
        deck_complet[45] = new Carte(Couleur.TREFLE, Valeur.HUIT);
        deck_complet[46] = new Carte(Couleur.TREFLE, Valeur.SEPT);
        deck_complet[47] = new Carte(Couleur.TREFLE, Valeur.SIX);
        deck_complet[48] = new Carte(Couleur.TREFLE, Valeur.CINQ);
        deck_complet[49] = new Carte(Couleur.TREFLE, Valeur.QUATRE);
        deck_complet[50] = new Carte(Couleur.TREFLE, Valeur.TROIS);
        deck_complet[51] = new Carte(Couleur.TREFLE, Valeur.DEUX);

        return deck_complet;
    }
}
