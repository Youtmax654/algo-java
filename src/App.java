import java.util.Scanner;

import Utils.Console;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        Console.clear();
        System.out.println("Menu :");
        System.out.println("1. Jouer");
        System.out.println("2. Voir les règles");
        // System.out.println("3. Voir les scores");
        System.out.println("3. Quitter");
        System.out.println("Veuillez choisir une option : ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                play();
                break;
            case 2:
                showRules();
                break;
            case 3:
                leave();
                break;
            default:
                System.out.println("Choix invalide");
                break;
        }
    }

    public static void play() {
        Console.clear();
        System.out.println("Jouer");
    }

    public static void showRules() {
        Scanner input = new Scanner(System.in);
        Console.clear();
        System.out.println("----- les règles -----\n - Tu possède un pion de couleur qui vas etre le tiens tout le long de la partie.\n - Ton pion peux ce deplacé horizontalement et verticalement mais que d'une seule casse.\n - Après s'être déplacer tu es obliger de casser un bloc.\n - Un bloc detruit est un trou dans le terrain donc aucun joueur peux s'y poser.");
        System.out.println("\n----- Petite specificité -----\n - Un joueur ne peux pas ce déplacer sur une case detruite / hors du terrain ou sur un joueur.\n - Un joueur ne peux pas casser un bloc déjà detruite / sous un joueur ou hors du terrain.\n - Un joueur est considérer comme un bloc");
        System.out.println("\n----- Conditions de victoire / défaite -----\n - La victoire est accorder a la derniere personne a etre libre d'encore ce deplacer\n La defaite est donner a celui qui n'est plus capable de ce deplacer sur le terrain 'donc bloquer'.");
        System.out.println("\n 1. Retour");
        int choice = input.nextInt();
        if (choice == 1) {
            menu();
        }
    }
    

    public static void leave() {
        Console.clear();
        System.out.println("Au revoir !");
    }
}
