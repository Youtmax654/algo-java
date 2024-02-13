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
        Console.clear();
        System.out.println("Voici les règles");
    }

    public static void leave() {
        Console.clear();
        System.out.println("Au revoir !");
    }
}
