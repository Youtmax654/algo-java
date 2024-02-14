import java.util.Scanner;
import Utils.Console;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        Console.clear();

        System.out.println("\u001B[32m***********************************");
        System.out.println("         Block by Bloc         ");
        System.out.println("***********************************\u001B[0m");
        System.out.println(" ");
        System.out.println("Menu :");
        System.out.println(" ");
        System.out.println("\u001B[32m[1] Play");
        System.out.println("[2] Show Rules");
        System.out.println("[3] Exit\u001B[0m");
        System.out.println(" ");
        System.out.print("Choose an option : ");

        String choice = input.next();

        switch (choice) {
            case "1":
                play();
                break;
            case "2":
                showRules();
                break;
            case "3":
                leave();
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menu();
        }
        input.close();
    }

    public static void play() {
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Play               ");
        System.out.println("***********************************\u001B[0m");

        // Assigning a random pseudonym for Player 1
        String J1 = assignPseudo();

        // Assigning a pseudonym for Player 2, ensuring it is different from Player 1
        String J2;
        do {
            J2 = assignPseudo();
        } while (J2.equals(J1)); // Check if J2 is the same as J1, if so, assign a new pseudonym

        // Displaying the assigned pseudonyms
        System.out.println("Pseudo for Player 1: " + J1);
        System.out.println("Pseudo for Player 2: " + J2);

        // Generating a random number to select the player who starts the game
        Random random = new Random();
        int startingPlayerIndex = random.nextInt(2);

        // Add gameBoard spawn

        // Displaying a message indicating whose turn it is to start
        String startingPlayer = startingPlayerIndex == 0 ? J1 : J2;
        System.out.println("It's your turn " + startingPlayer + " !");
    }

    public static void showRules() {
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("         These are the rules         ");
        System.out.println("***********************************\u001B[0m");
    }

    public static void leave() {
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }

    // Random Pseudo
    public static String assignPseudo() {
        String[] pseudos = { "Ahri", "Yasuo", "Lux", "Lee Sin", "Jinx", "Akali", "Thresh", "Jhin", "Annie" };
        Random random = new Random();
        String pseudo = pseudos[random.nextInt(pseudos.length)];
        return pseudo;
    }
}