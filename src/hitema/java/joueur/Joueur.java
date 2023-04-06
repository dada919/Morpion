package hitema.java.joueur;

public class Joueur {
    private char symbole;
    private int taille;

    public Joueur(char symbole, int taille) {
        this.symbole = symbole;
        this.taille = taille;
    }
    public char getSymbole() {
        return symbole;
    }

    public int[] demanderPosition() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Choisissez un n° de ligne entre (0-" + (taille - 1) + "): ");
        int x = scanner.nextInt();
        System.out.print("Choisissez un n° de colone entre (0-" + (taille - 1) + "): ");
        int y = scanner.nextInt();
        while (x < 0 || x >= taille || y < 0 || y >= taille) {
            System.err.println("Case en dehors de la grille, recommencez:");
            System.out.print("Choisissez un n° de ligne entre (0-" + (taille - 1) + "): ");
            x = scanner.nextInt();
            System.out.print("Choisissez un n° de colone entre (0-" + (taille - 1) + "): ");
            y = scanner.nextInt();
        }
        return new int[]{x, y};
    }
}
