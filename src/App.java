// import java.util.Random;

// Importing the Scanner class from the java.util package
import java.util.Random;
import java.util.Scanner;

// Importing the Console class from the Utils package
import Utils.Console;

public class App {
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        Console.clear();

        System.out.println("\u001B[32m***********************************");
        System.out.println("         Block by Bloc         ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("Menu :\n");
        // Display menu options with color formatting
        System.out.println("\u001B[32m[1] Play");
        System.out.println("[2] Show Rules");
        System.out.println("[3] Exit\u001B[0m\n");
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
        String player1 = "\u001B[31m" + Player.getRandomUsername() + "\u001B[0m";
        String player2 = "\u001B[34m" + Player.getRandomUsername() + "\u001B[0m";
        while (player1 == player2) {
            player2 = Player.getRandomUsername();
        }

        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Game               ");
        System.out.println("***********************************\u001B[0m\n");

        System.out.println(
                player1 + " VS " + player2 + "\n");

        // Generate the game board
        String[][] gameBoard = new String[10][11];

        // Fill the game board with the coordinates
        char row = 'A';
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if (j > 8)
                    gameBoard[i][j] = row + Integer.toString(j + 1);
                else
                    gameBoard[i][j] = row + Integer.toString(j + 1) + " ";
            }
            row++;
        }

        // Call the printBoard method to display the game board
        gameBoard = Board.showPlayer(gameBoard, 2);
        Board.printBoard(gameBoard);

        Random random = new Random();
        int currentPlayerIndex = random.nextInt(2) + 1;
        String currentPlayer = currentPlayerIndex == 1 ? player1 : player2;

        System.out.println("\nIt's your turn " + currentPlayer + " !");
    }

    // Method to handle the "Show Rules" option
    public static void showRules() {
        // Creating a new instance of the Scanner class to read user input
        Scanner input = new Scanner(System.in);
        // Clear the console screen
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Rules            ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println(
                "- You have a colored pawn which will be yours throughout the game.\n- Your pawn can move horizontally and vertically, but only by one case.\n- After moving, you have to break a block.\n- A destroyed block is a hole in the ground, so no player can land on it.\n");
        System.out.println("\u001B[32m***********************************");
        System.out.println("           Restrictions            ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println(
                "- A player can't move on a destroyed/outside square or on a player.\n- A player cannot break an already destroyed block, under a player or outside the field.\n- A player is considered as a block\n");
        System.out.println("\u001B[32m***********************************");
        System.out.println("      How to win / lose        ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println(
                "- A player cannot move onto a destroyed square, off the board or onto a player.\n- A player who can no longer move is blocked and loses the game.");
        System.out.println("\n\u001B[32m[1] Go back to the main menu \u001B[0m\n");
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
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }
}