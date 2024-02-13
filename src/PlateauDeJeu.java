public class PlateauDeJeu {
    public static void main(String[] args) {
        // Dimensions du plateau de jeu
        int lignes = 10;
        int colonnes = 11;

        // Génération du plateau de jeu
        char[][] plateau = genererPlateau(lignes, colonnes);

        // Affichage du plateau de jeu centré dans le terminal
        afficherPlateauAvecCouleurs(plateau);
    }

    // Fonction pour générer un plateau de jeu
    public static char[][] genererPlateau(int lignes, int colonnes) {
        char[][] plateau = new char[lignes][colonnes];

        // Initialisation du plateau avec des cases représentées par un carré noir Unicode
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                plateau[i][j] = '\u25A0'; // Caractère Unicode pour un carré noir
            }
        }

        // Vous pouvez ajouter des éléments ou des caractères spécifiques au plateau ici

        return plateau;
    }

    // Fonction pour afficher le plateau de jeu centré dans le terminal avec des couleurs
    public static void afficherPlateauAvecCouleurs(char[][] plateau) {
        // Récupérer la largeur du terminal
        int largeurTerminal = getLargeurTerminal();

        // Calculer l'offset pour centrer le plateau
        int offset = (largeurTerminal - plateau[0].length * 3) / 2; // Chaque case est maintenant de largeur 3

        // Afficher le plateau centré avec des couleurs
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < offset; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < plateau[i].length; j++) {
                // Utiliser printf pour ajuster la largeur de chaque cellule et ajouter des couleurs
                System.out.printf("\u001B[34m%c\u001B[0m ", plateau[i][j]); // Code d'échappement ANSI pour la couleur bleue
            }
            System.out.println();
        }
    }

    // Fonction pour récupérer la largeur du terminal
    public static int getLargeurTerminal() {
        return 80; // Remplacez cela par une méthode pour obtenir la largeur réelle du terminal si nécessaire
    }
}
