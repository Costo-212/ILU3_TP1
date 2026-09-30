package testFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {

    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        System.out.println(jeu.affichageJeuDeCartes());

        Carte[] cartes = jeu.donnerCartes();
        System.out.println("Nombre de cartes : " + cartes.length); // 106
    }
}