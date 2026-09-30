package testFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabots;

public class TestSabots {

    public static void main(String[] args) {
        testPiocher();
        testIterateur();
        testExceptions();
    }

    // 2.a : avec piocher
    private static void testPiocher() {
        Sabots sabot = new Sabots(new JeuDeCartes().donnerCartes());
        while (!sabot.estVide()) {
            System.out.println("je pioche " + sabot.piocher());
        }
    }

    // 2.b : avec itérateur + remove
    private static void testIterateur() {
        Sabots sabot = new Sabots(new JeuDeCartes().donnerCartes());
        Iterator<Carte> it = sabot.iterator();
        while (it.hasNext()) {
            Carte carte = it.next();
            System.out.println("je pioche " + carte);
            it.remove();
        }
    }

    // 2.c : les exceptions
    private static void testExceptions() {
        // piocher dans la boucle
        Sabots sabot = new Sabots(new JeuDeCartes().donnerCartes());
        try {
            for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
                Carte carte = it.next();
                System.out.println("je pioche " + carte);
                it.remove();
                sabot.piocher(); // doit lever l'exception
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("OK : ConcurrentModificationException");
        }

        // ajouter dans la boucle (après un piocher avant la boucle)
        sabot = new Sabots(new JeuDeCartes().donnerCartes());
        Carte asDuVolant = sabot.piocher(); // libère une place
        try {
            for (Iterator<Carte> it = sabot.iterator(); it.hasNext();) {
                Carte carte = it.next();
                System.out.println("je pioche " + carte);
                sabot.ajouterCarte(asDuVolant); // doit lever l'exception
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("OK : ConcurrentModificationException");
        }
    }
}