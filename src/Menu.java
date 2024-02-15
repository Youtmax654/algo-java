import java.util.Scanner;

/**
 * The Menu class represents the main menu of the game.
 */
public class Menu {

  /**
   * Method to display the main menu and handle user choices.
   */
  public static void main() {
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
    System.out.println("[3] Exit\u001B[0m\n");
    System.out.print("Choose an option : ");

    // Read user input for menu choice
    String choice = input.next();

    // Process the user's choice
    switch (choice) {
      case "1":
        Game.play(); // Call the play method to start the game
        break;
      case "2":
        Game.showRules(); // Call the showRules method to display the rules
        break;
      case "3":
        App.leave(); // Call the leave method to exit the game
        break;
      default:
        System.out.println("\u001B[31mInvalid choice\u001B[0m");
        Console.sleep(2000);
        Menu.main(); // If an invalid choice is entered, display the menu again
    }
  }

  /**
   * Method to display the game over screen with options to play again, go to the
   * main menu, or exit.
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
    System.out.println("\u001B[31m" + loser.username + " is blocked and loses the game\u001B[0m");
    System.out.println("\u001B[32m" + winner.username + " wins the game\u001B[0m\n");
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
  }
}
