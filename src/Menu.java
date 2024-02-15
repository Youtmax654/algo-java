import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Menu class represents the main menu of the game.
 */
public class Menu {

  /**
   * Method to display the main menu and handle user choices.
   */
  public static void main() {
    // Create instances of the Scanner classes
    Scanner input = new Scanner(System.in);

    // Clear the console screen
    Console.clear();

    // Display the game title
    System.out.println("\u001B[32m***********************************");
    System.out.println("         Block by Bloc         ");
    System.out.println("***********************************\u001B[0m\n");

    // Display the menu options
    System.out.println("Menu :\n");
    System.out.println("\u001B[32m[1] Play");
    System.out.println("[2] Show Rules");
    System.out.println("[3] Show scoreboard");
    System.out.println("[4] Exit\u001B[0m\n");
    System.out.print("Choose an option : ");

    // Read user input for menu choice
    String choice = input.next();

    // Process the user's choice
    switch (choice) {
      case "1":
        Game.play(); // Call the play method to start the game
        break;
      case "2":
        showRules(); // Call the showRules method to display the rules
        break;
      case "3":
        showScoreboard(); // Call the show method to display the scoreboard
        break;
      case "4":
        App.leave(); // Call the leave method to exit the game
        break;
      default:
        System.out.println("\u001B[31mInvalid choice\u001B[0m");
        Console.sleep(2000);
        Menu.main(); // If an invalid choice is entered, display the menu again
    }
    input.close();
  }

  /**
   * Displays the game over screen and handles the user's choice for game over
   * options.
   * 
   * @param loser  The player who lost the game.
   * @param winner The player who won the game.
   */
  public static void gameOver(Player loser, Player winner) {
    Scanner input = new Scanner(System.in);

    // Clear the console screen
    Console.clear();

    // Display the game over screen
    System.out.println("\u001B[32m***********************************");
    System.out.println("          End of the game          ");
    System.out.println("***********************************\u001B[0m\n");

    // Display the game result and winner information
    System.out.println("\u001B[31m" + loser.username + " is blocked. He loses the game and loses 2 points\u001B[0m");
    System.out.println("\u001B[32m" + winner.username + " wins the game and wins 5 points\u001B[0m\n");

    Scoreboard.addScore(winner.username, 5);
    Scoreboard.addScore(loser.username, -2);

    System.out.println("\u001B[32m" + loser.username + " sucks at the game, don't play ever again\u001B[0m\n");
    System.out.println("\u001B[32m[1] Play again\n[2] Go back to the main menu\n[3] Exit\u001B[32m\u001B[0m\n");
    System.out.println("Choose an option :");

    // Read user input for game over options
    String choice = input.next();

    // Process the user's choice
    switch (choice) {
      case "1":
        Game.play();
        break;
      case "2":
        Menu.main();
        break;
      case "3":
        App.leave();
        break;
      default:
        System.out.println("\u001B[31mInvalid choice\u001B[0m");
        Console.sleep(2000);
        gameOver(loser, winner);
        break;
    }
    input.close();
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

  public static void showScoreboard() {
    ArrayList<String> players = Scoreboard.getPlayers();
    ArrayList<Integer> scores = Scoreboard.getScores();
    // Create a Scanner object to read user input
    Scanner input = new Scanner(System.in);
    // Clear the console
    Console.clear();
    // Display the scoreboard header
    System.out.println("\u001B[32m***********************************");
    System.out.println("          Scoreboard           ");
    System.out.println("***********************************\u001B[0m\n");
    // Display the player names and scores
    for (int i = 0; i < 10; i++) {
      if (i < players.size()) {
        if (players.get(i).isEmpty()) {
          System.out.println(i + 1 + ". ??? | ??? points");
        } else {
          System.out.println(i + 1 + ". " + players.get(i) + " | " + scores.get(i) + " points");
        }
      } else {
        System.out.println(i + 1 + ". ??? | ??? points");
      }
    }
    System.out.println("\n");
    // Display the menu options
    System.out.println("\u001B[32m[1] Go back to the main menu\u001B[0m\n");
    System.out.println("Choose an option :");
    // Read the user's choice
    String choice = input.next();
    // Perform action based on user's choice
    switch (choice) {
      case "1":
        // Go back to the main menu
        Menu.main();
        break;
      default:
        // Invalid choice, display error message and retry
        System.out.println("\u001B[31mInvalid choice\u001B[0m");
        Console.sleep(2000);
        showScoreboard();
        break;
    }
    // Close the Scanner object
    input.close();
  }
}
