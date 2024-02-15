import java.util.Random;

/**
 * Represents a player in a game with a position and username.
 */
public class Player {
  // The X-coordinate of the player
  public int positionX;
  // The Y-coordinate of the player
  public int positionY;
  // The username of the player
  public String username;

  /**
   * Constructor to initialize the player's position and username.
   *
   * @param positionX The initial X-coordinate of the player.
   * @param positionY The initial Y-coordinate of the player.
   * @param username  The username of the player.
   */
  public Player(int positionX, int positionY, String username) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.username = username;
  }

  /**
   * Generates a random username from a predefined list of names.
   *
   * @return A randomly selected username.
   */
  public static String getRandomUsername() {
    String[] names = { "Ahri", "Yasuo", "Lux", "Lee Sin", "Jinx", "Akali", "Thresh", "Jhin", "Annie" };
    Random random = new Random();
    String name = names[random.nextInt(names.length)];
    return name;
  }

  /**
   * Moves the player's position by a given deltaX and deltaY.
   *
   * @param deltaX The change in the X-coordinate.
   * @param deltaY The change in the Y-coordinate.
   */
  public void move(int deltaX, int deltaY) {
    this.positionX += deltaX;
    this.positionY += deltaY;
  }

  /**
   * Checks if the new position is outside the board boundaries or conflicts with
   * another player's position.
   * Also, checks if the new position is on a destroyed block on the game board.
   *
   * @param otherPlayer The other player to check for conflicts.
   * @param deltaX      The change in the X-coordinate.
   * @param deltaY      The change in the Y-coordinate.
   * @param attempts    The remaining attempts to move.
   * @param gameBoard   The 2D array representing the game board.
   * @return True if the new position is forbidden, false otherwise.
   */
  public boolean forbiddenPosition(Player otherPlayer, int deltaX, int deltaY, int attempts, String[][] gameBoard) {
    // Check if the new position is outside the board boundaries
    if ((this.positionX < 0) || (this.positionX > 9) || (this.positionY < 0)
        || (this.positionY > 10)) {
      // Revert the position changes
      this.positionX -= deltaX;
      this.positionY -= deltaY;
      System.out.println("\u001B[31mYou can't move outside the board!\u001B[0m");
      System.out.println("\u001B[31m" + (3 - attempts) + " attempts left\u001B[0m");
      Console.sleep(2000);
      return true;
    } else if ((this.positionX == otherPlayer.positionX)
        && (this.positionY == otherPlayer.positionY)) {
      // Revert the position changes
      this.positionX -= deltaX;
      this.positionY -= deltaY;
      System.out.println("\u001B[31mYou can't move to the same position as the other player!\u001B[0m");
      System.out.println("\u001B[31m" + (3 - attempts) + " attempts left\u001B[0m");
      Console.sleep(2000);
      return true;
    } else if (gameBoard[this.positionX][this.positionY] == "   ") {
      // Revert the position changes
      this.positionX -= deltaX;
      this.positionY -= deltaY;
      System.out.println("\u001B[31mYou can't move to a destroyed block!\u001B[0m");
      System.out.println("\u001B[31m" + (3 - attempts) + " attempts left\u001B[0m");
      Console.sleep(2000);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if the player is on a specific coordinate.
   *
   * @param coordinate The coordinate to check (e.g., "A1").
   * @return True if the player is on the specified coordinate, false otherwise.
   */
  public boolean onCoordinate(String coordinate) {
    coordinate = coordinate.toUpperCase();
    int row = coordinate.charAt(0) - 'A';
    int col;
    if (coordinate.length() > 2) {
      col = Integer.parseInt(coordinate.substring(1, 3)) - 1;
    } else {
      col = Character.getNumericValue(coordinate.charAt(1)) - 1;
    }
    return (this.positionX == row) && (this.positionY == col);
  }

  /**
   * Checks if the player is blocked on all four sides.
   *
   * @param otherPlayer The other player to check for blocking.
   * @param gameBoard   The 2D array representing the game board.
   * @return True if the player is blocked on all four sides, false otherwise.
   */
  public boolean isBlocked(Player otherPlayer, String[][] gameBoard) {
    if ((this.positionX - 1 < 0 || this.positionX - 1 == otherPlayer.positionX
        || gameBoard[this.positionX - 1][this.positionY] == "   ")
        && (this.positionX + 1 > 9 || this.positionX + 1 == otherPlayer.positionX
            || gameBoard[this.positionX + 1][this.positionY] == "   ")
        && (this.positionY - 1 < 0 || this.positionY - 1 == otherPlayer.positionY
            || gameBoard[this.positionX][this.positionY - 1] == "   ")
        && (this.positionY + 1 > 10 || this.positionY + 1 == otherPlayer.positionY
            || gameBoard[this.positionX][this.positionY + 1] == "   ")) {
      return true;
    } else {
      return false;
    }
  }
}