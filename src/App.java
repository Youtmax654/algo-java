import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Utils.Console;

public class App {
    public static void main(String[] args) throws Exception {
        menu(); // Call the menu method to start the game
    }

    // Method to display the main menu
    public static void menu() {
        Scanner input = new Scanner(System.in);
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("         Block by Bloc         ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println("Menu :\n");
        System.out.println("\u001B[32m[1] Play");
        System.out.println("[2] Show Rules");
        System.out.println("[3] Exit\u001B[0m\n");
        System.out.print("Choose an option : ");

        String choice = input.next();

        switch (choice) {
            case "1":
                play(); // Call the play method to start the game
                break;
            case "2":
                showRules(); // Call the showRules method to display the rules
                break;
            case "3":
                leave(); // Call the leave method to exit the game
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                Console.sleep(2000);
                menu(); // If an invalid choice is entered, display the menu again
        }
        input.close();
    }

    // Method to start the game
    public static void play() {
        ArrayList<String> destroyedBlocks = new ArrayList<String>();

        // Create a scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Player 1 Name
        String player1Name;
        do {
            // Prompt the user to enter a name for Player 1 (2-10 characters)
            System.out.print("Enter name for Player 1 (2-10 characters): ");
            player1Name = input.next();
            // Check if the entered name length is not within the range of 2 to 10
            // characters
            if (player1Name.length() < 2 || player1Name.length() > 10) {
                // Display an error message in red indicating the required name length
                System.out.println("\u001B[31mThe name must be between 2 and 10 characters.\u001B[0m");
                // Pause execution for 2 seconds
                Console.sleep(2000);
                // Clear the console screen
                Console.clear();

            }
        } while (player1Name.length() < 2 || player1Name.length() > 10);

        // Player 2 Name
        String player2Name;
        do {
            // Prompt the user to enter a name for Player 2 (2-10 characters)
            System.out.print("Enter name for Player 2 (2-10 characters): ");
            player2Name = input.next();
            // Check if the entered name length is not within the range of 2 to 10
            // characters
            if (player2Name.length() < 2 || player2Name.length() > 10) {
                // Display an error message in red indicating the required name length
                System.out.println("\u001B[31mThe name must be between 2 and 10 characters.\u001B[0m");
                // Pause execution for 2 seconds
                Console.sleep(2000);
                // Clear the console screen
                Console.clear();
            }
        } while (player2Name.length() < 2 || player2Name.length() > 10);

        // Create Player objects with colored names based on user input
        Player player1 = new Player(4, 5, "\u001B[31m" + player1Name + "\u001B[0m");
        Player player2 = new Player(5, 5, "\u001B[34m" + player2Name + "\u001B[0m");

        // Randomly select the current player
        Random random = new Random();
        int currentPlayerIndex = random.nextInt(2) + 1;
        Player currentPlayer = currentPlayerIndex == 1 ? player1 : player2;
        Player otherPlayer = currentPlayer == player1 ? player2 : player1;

        while (true) {
            movingPhase(player1, player2, destroyedBlocks, currentPlayerIndex, currentPlayer, otherPlayer, input);
            breakingPhase(player1, player2, destroyedBlocks, currentPlayerIndex, currentPlayer, otherPlayer, input);

            // Switch the player turns
            if (currentPlayerIndex == 1) {
                currentPlayer = player2;
                otherPlayer = player1;
                currentPlayerIndex = 2;
            } else {
                currentPlayer = player1;
                otherPlayer = player2;
                currentPlayerIndex = 1;
            }
        }
    }

    private static void movingPhase(Player player1, Player player2, ArrayList<String> destroyedBlocks,
            int currentPlayerIndex,
            Player currentPlayer, Player otherPlayer, Scanner input) {
        // Start the game loop
        for (int i = 0; i <= 3; i++) {
            // Get the username of the current player
            String currentPlayerUsername = currentPlayer.username;

            String[][] gameBoard = Board.createBoard(10, 11);
            // Display the game board again after the player's move
            gameBoard = displayGameBoard(player1, player2, destroyedBlocks, gameBoard);

            // Prompt the current player for a direction
            System.out.println("\nIt's your turn " + currentPlayerUsername + " !\n");
            System.out.println("\u001B[32m[Z] Up [Q] Left [S] Down [D] Right\u001B[0m\n");
            System.out.println("Choose a direction : ");
            String direction = input.next();

            // Move the current player based on the chosen direction
            switch (direction) {
                case "Z", "z":
                    currentPlayer.move(-1, 0);
                    if (currentPlayer.forbiddenPosition(otherPlayer, -1, 0, i, gameBoard)) {
                        continue;
                    } else {
                        break;
                    }
                case "S", "s":
                    currentPlayer.move(1, 0);
                    if (currentPlayer.forbiddenPosition(otherPlayer, 1, 0, i, gameBoard)) {
                        continue;
                    } else {
                        break;
                    }
                case "Q", "q":
                    currentPlayer.move(0, -1);
                    if (currentPlayer.forbiddenPosition(otherPlayer, 0, -1, i, gameBoard)) {
                        continue;
                    } else {
                        break;
                    }
                case "D", "d":
                    currentPlayer.move(0, 1);
                    if (currentPlayer.forbiddenPosition(otherPlayer, 0, 1, i, gameBoard)) {
                        continue;
                    } else {
                        break;
                    }
                default:
                    System.out.println("\u001B[31mInvalid choice\u001B[0m");
                    System.out.println("\u001B[31m" + (3 - i) + " attempts left\u001B[0m");
                    Console.sleep(2000);
                    continue;
            }
            break;
        }
    }

    private static void breakingPhase(Player player1, Player player2, ArrayList<String> destroyedBlocks,
            int currentPlayerIndex,
            Player currentPlayer, Player otherPlayer, Scanner input) {
        for (int i = 0; i <= 3; i++) {
            // Get the username of the current player
            String currentPlayerUsername = currentPlayer.username;
            // Display the game board again after the player's move
            displayGameBoard(player1, player2, destroyedBlocks, Board.createBoard(10, 11));

            System.out.println("\nIt's your turn " + currentPlayerUsername + " !");
            // Prompt the current player to break a block
            System.out.println("\nChoose a block to break : ");
            String coordinates = input.next();
            if (isValidCoordinates(coordinates, 10, 11)) {
                if (destroyedBlocks.contains(coordinates)) {
                    System.out.println("\u001B[31mThis block is already destroyed\u001B[0m");
                    System.out.println("\u001B[31m" + (3 - i) + " attempts left\u001B[0m");
                    Console.sleep(2000);
                    continue;
                } else if (player1.onCoordinate(coordinates) || player2.onCoordinate(coordinates)) {
                    System.out.println("\u001B[31mYou can't break a block under a player\u001B[0m");
                    System.out.println("\u001B[31m" + (3 - i) + " attempts left\u001B[0m");
                    Console.sleep(2000);
                    continue;
                } else {
                    destroyedBlocks.add(coordinates);
                }
            } else {
                System.out.println("\u001B[31mInvalid coordinates\u001B[0m");
                System.out.println("\u001B[31m" + (3 - i) + " attempts left\u001B[0m");
                Console.sleep(2000);
                continue;
            }
            break;
        }
    }

    // Méthode pour vérifier si les coordonnées sont valides
    public static boolean isValidCoordinates(String coordinates, int numRows, int numCols) {
        coordinates = coordinates.toUpperCase();
        if (!coordinates.matches("[A-Z]\\d+")) {
            return false;
        }
        char letter = coordinates.charAt(0);
        int number;
        if (coordinates.length() > 2) {
            number = Integer.parseInt(coordinates.substring(1, 3)) - 1;
        } else {
            number = Character.getNumericValue(coordinates.charAt(1)) - 1;
        }
        if (letter < 'A' || letter > 'A' + numCols - 1) {
            return false;
        }
        if (number < 1 || number > numRows) {
            return false;
        }
        return true;
    }

    private static String[][] displayGameBoard(Player player1, Player player2, ArrayList<String> destroyedBlocks,
            String[][] gameBoard) {
        // Create a 10x11 game board
        for (String block : destroyedBlocks) {
            gameBoard = Board.destroyBlock(gameBoard, block);
        }
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("               Game               ");
        System.out.println("***********************************\u001B[0m\n");
        System.out.println(player1.username + " VS " + player2.username + "\n");
        gameBoard = Board.addPlayer(gameBoard, player1, player2);
        Board.printBoard(gameBoard);
        return gameBoard;
    }

    // Method to display the rules
    public static void showRules() {
        Scanner input = new Scanner(System.in);
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
        switch (rulesChoice) {
            case "1":
                menu(); // Call the menu method to go back to the main menu
                break;
            default:
                System.out.println("\u001B[31mInvalid choice\u001B[0m");
                Console.sleep(2000);
                showRules(); // If an invalid choice is entered, display the rules again
                break;
        }
        input.close();
    }

    // Method to exit the game
    public static void leave() {
        Console.clear();
        System.out.println("\u001B[32m***********************************");
        System.out.println("            Goodbye !            ");
        System.out.println("***********************************\u001B[0m");
    }
}
