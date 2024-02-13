import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Entry point of the program, calling the menu method
        menu();
    }

    // Method to display the main menu
    public static void menu() {
        Scanner input = new Scanner(System.in);
        // Clear the console screen
        clearConsole();

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
        System.out.println("[3] Leave\u001B[0m");
        System.out.println(" ");
        System.out.print("Choose an option : ");
        // Read user choice from input
        int choice = input.nextInt();

        // Switch statement to handle user's choice
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
                // Display a message for an invalid choice
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                break;
        }
    }

    // Method to handle the "Play" option
    public static void play() {
        // Clear the console screen
        clearConsole();
        // Display the title for the play section
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Play               ");
        System.out.println("***********************************\u001B[0m");
        // Add your game logic here
    }

    // Method to handle the "Show Rules" option
    public static void showRules() {
        // Clear the console screen
        clearConsole();
        // Display the title for the rules section
        System.out.println("\u001B[32m***********************************");
        System.out.println("         These are the rules         ");
        System.out.println("***********************************\u001B[0m");
        // Add your rules here
    }

    // Method to handle the "Leave" option
    public static void leave() {
        // Clear the console screen
        clearConsole();
        // Display a goodbye message
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }

    // Method to clear the console screen
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
