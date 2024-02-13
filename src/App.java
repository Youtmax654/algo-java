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

        // Clearing the console screen
        Console.clear();

        // Displaying the menu options
        System.out.println("Menu :");
        System.out.println("1. Play");
        System.out.println("2. Show the rules");
        System.out.println("3. Leave");
        System.out.println("Please select an option : ");

        // Reading the user's choice
        String choice = input.next();

        // Using a switch statement to perform different actions based on the user's choice
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
                // If the user chooses any other number, display an error message and call the menu method again
                System.out.println("Wrong choice, please try again.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                menu();
        }
        input.close();
    }

    // The play method that displays the "Play" message
    public static void play() {
        // Clearing the console screen
        Console.clear();

        // Displaying the "Play" message
        System.out.println("Play");
    }

    // The showRules method that displays the rules
    public static void showRules() {
        // Clearing the console screen
        Console.clear();

        // Displaying the rules
        System.out.println("Here are the rules");
    }

    // The leave method that displays the "Goodbye !" message
    public static void leave() {
        // Clearing the console screen
        Console.clear();

        // Displaying the "Goodbye !" message
        System.out.println("Goodbye !");
    }
}
