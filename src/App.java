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
        System.out.println("***********************************\u001B[0m");
        System.out.println(" ");
        System.out.println("Menu :");
        System.out.println(" ");
        // Display menu options with color formatting
        System.out.println("\u001B[32m[1] Play");
        System.out.println("[2] Show Rules");
        System.out.println("[3] Exit\u001B[0m");
        System.out.println(" ");
        System.out.print("Choose an option : ");
        // Read user choice from input
        String choice = input.next();

        // Switch statement to handle user's choice
        switch (choice) {
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
        // Clear the console screen
        Console.clear();
        // Display the title for the rules section
        System.out.println("\u001B[32m***********************************");
        System.out.println("         These are the rules         ");
        System.out.println("***********************************\u001B[0m");
        // Add your rules here
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
