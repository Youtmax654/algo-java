// Importing the Scanner class from the java.util package
import java.util.Scanner;

// Importing the Console class from the Utils package
import Utils.Console;

// Defining the App class
public class App {
    // The main method that serves as the entry point of the program
    public static void main(String[] args) throws Exception {
        // Calling the menu method to display the menu options
        menu();
    }

    // The menu method that displays the menu options and handles user input
    public static void menu() {
        // Creating a new instance of the Scanner class to read user input
        Scanner input = new Scanner(System.in);
        // Clear the console screen
        Console.clear();

        // Display the title of the game
        System.out.println("\u001B[32m***********************************");
        System.out.println("         Block by Bloc         ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("Menu :\n");
        // Display menu options with color formatting
        System.out.println("\u001B[32m[1] Play");
        System.out.println("[2] Show Rules");
        System.out.println("[3] Exit\u001B[0m\n");
        System.out.print("Choose an option : ");
        // Read user choice from input
        String mainChoice = input.next();

        // Switch statement to handle user's mainChoice
        switch (mainChoice) {
            case "1":
                // If the user chooses 1, call the play method
                play();
                break;
            case "2":
                // If the user chooses 2, call the showRules method
                showRules();
                break;
            case "3":
                // If the user chooses 3, call the leave method
                leave();
                break;
            default:
                // Display a message for an invalid choice
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

    // Method to handle the "Play" option
    public static void play() {
        // Clear the console screen
        Console.clear();
        // Display the title for the play section
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Play               ");
        System.out.println("***********************************\u001B[0m");
        // Add your game logic here
    }

    // Method to handle the "Show Rules" option
    public static void showRules() {
        Scanner input = new Scanner(System.in);
        // Clear the console screen
        Console.clear();
        // Display the title for the rules section
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Rules            ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("- You have a colored pawn which will be yours throughout the game.\n- Your pawn can move horizontally and vertically, but only by one case.\n- After moving, you have to break a block.\n- A destroyed block is a hole in the ground, so no player can land on it.\n");
        System.out.println("\u001B[32m***********************************");
        System.out.println("           Restrictions            ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("- A player can't move on a destroyed/outside square or on a player.\n- A player cannot break an already destroyed block, under a player or outside the field.\n- A player is considered as a block\n");
        System.out.println("\u001B[32m***********************************");
        System.out.println("      How to win / lose        ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("- A player cannot move onto a destroyed square, off the board or onto a player.\n- A player who can no longer move is blocked and loses the game.");
        System.out.println("\n\u001B[32m [1] Go back to the main menu \u001B[0m\n");
        System.out.print("Choose an option : ");
        String rulesChoice = input.next();
        // If the user prompt 1 return to the main menu
        switch (rulesChoice) {
            case "1":
                menu();
                break;
            default:
                // Display a message for an invalid choice
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showRules();
                break;
        }
        input.close();
    }
    

    // Method to handle the "Leave" option
    public static void leave() {
        // Clear the console screen
        Console.clear();
        // Display a goodbye message
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }
}
