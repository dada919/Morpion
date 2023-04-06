package hitema.java.morpion;

import hitema.java.joueur.Joueur;
import hitema.java.plateau.Plateau;

public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;

    public Jeu(int taille) {
        plateau = new Plateau(taille);
        joueur1 = new Joueur('X', taille);
        joueur2 = new Joueur('O', taille);
    }

    public void lancer() {
        Joueur joueurActuel = joueur1;
        boolean fin = false;
        while (!fin) {
            plateau.afficher();
            System.out.println(joueurActuel.getSymbole() + " à vous de jouer: ");
            int[] position = joueurActuel.demanderPosition();
            while (!plateau.placer(position[0], position[1], joueurActuel.getSymbole())) {

                position = joueurActuel.demanderPosition();
            }

            if (plateau.verifierVictoire(joueurActuel.getSymbole())) {
                System.out.println(joueurActuel.getSymbole() + " à GAGNER !");
                fin = true;
            } else if (plateau.estPlein()) {
                System.out.println("Egalité");
                fin = true;
            } else {
                joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
            }
        }
        plateau.afficher();
    }
    public static int demanderTaille() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Choisissez la taille de la grille entre 3 et 9 cases: ");
        int taille = scanner.nextInt();
        while (taille < 3 || taille > 9) {
            System.err.print("Choisissez une taille entre 3 et 9 cases: ");
            taille = scanner.nextInt();
        }
        return taille;
    }
}

