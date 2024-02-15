import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The Game class represents the main logic for executing and playing the game.
 */
public class Game {
  /**
   * Method to start the game.
   */
  public static void play() {
    // List to keep track of destroyed blocks
    ArrayList<String> destroyedBlocks = new ArrayList<String>();

    // 2D array representing the game board
    String[][] gameBoard = Board.createBoard(10, 11);

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

    // Main game loop
    while (true) {
      // Execute the moving phase of the current player
      movingPhase(player1, player2, destroyedBlocks, currentPlayerIndex, currentPlayer, otherPlayer, input);

      // Execute the breaking phase of the current player
      breakingPhase(player1, player2, destroyedBlocks, currentPlayerIndex, currentPlayer, otherPlayer, input);

      // Display the game board
      gameBoard = Board.display(player1, player2, destroyedBlocks, gameBoard);

      // Check if Player 1 is blocked
      if (player1.isBlocked(player2, gameBoard)) {
        Menu.gameOver(player1, player2);
        break;
      }

      // Check if Player 2 is blocked
      if (player2.isBlocked(player1, gameBoard)) {
        Menu.gameOver(player2, player1);
        break;
      }

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

  /**
   * Handles the moving phase of the game where players take turns moving their
   * pawns.
   * Players can choose a direction to move (Up, Left, Down, Right).
   *
   * @param player1            The first player.
   * @param player2            The second player.
   * @param destroyedBlocks    List of coordinates representing destroyed blocks.
   * @param currentPlayerIndex The index of the current player in the list of
   *                           players.
   * @param currentPlayer      The current player taking their turn.
   * @param otherPlayer        The opponent player.
   * @param input              Scanner for user input.
   */
  private static void movingPhase(Player player1, Player player2, ArrayList<String> destroyedBlocks,
      int currentPlayerIndex, Player currentPlayer, Player otherPlayer, Scanner input) {
    // Start the game loop
    for (int i = 0; i <= 3; i++) {
      // Get the username of the current player
      String currentPlayerUsername = currentPlayer.username;

      // Create and display the game board
      String[][] gameBoard = Board.createBoard(10, 11);
      gameBoard = Board.display(player1, player2, destroyedBlocks, gameBoard);

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

  /**
   * Handles the breaking phase of the game where players take turns breaking
   * blocks on the game board.
   * Players input coordinates to break a block, and the game enforces certain
   * rules for valid moves.
   *
   * @param player1            The first player.
   * @param player2            The second player.
   * @param destroyedBlocks    List of coordinates representing destroyed blocks.
   * @param currentPlayerIndex The index of the current player in the list of
   *                           players.
   * @param currentPlayer      The current player taking their turn.
   * @param otherPlayer        The opponent player.
   * @param input              Scanner for user input.
   */
  private static void breakingPhase(Player player1, Player player2, ArrayList<String> destroyedBlocks,
      int currentPlayerIndex, Player currentPlayer, Player otherPlayer, Scanner input) {
    for (int i = 0; i <= 3; i++) {
      // Get the username of the current player
      String currentPlayerUsername = currentPlayer.username;

      // Display the game board again after the player's move
      Board.display(player1, player2, destroyedBlocks, Board.createBoard(10, 11));

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

  /**
   * Checks if the given coordinates are valid on the game board.
   *
   * @param coordinates The coordinates to be checked.
   * @param numRows     The number of rows on the game board.
   * @param numCols     The number of columns on the game board.
   * @return True if the coordinates are valid, false otherwise.
   */
  private static boolean isValidCoordinates(String coordinates, int numRows, int numCols) {
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

  /**
   * Displays the rules of the game and allows the player to go back to the main
   * menu.
   */
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
        Menu.main(); // Call the menu method to go back to the main menu
        break;
      default:
        System.out.println("\u001B[31mInvalid choice\u001B[0m");
        Console.sleep(2000);
        showRules(); // If an invalid choice is entered, display the rules again
        break;
    }
    input.close();
  }
}