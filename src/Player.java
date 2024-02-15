import java.util.Random;

import Utils.Console;

public class Player {
  public int positionX; // The X-coordinate of the player's position
  public int positionY; // The Y-coordinate of the player's position
  public String username; // The username of the player

  // Constructor to initialize the player's position and username
  public Player(int positionX, int positionY, String username) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.username = username;
  }

  // Method to generate a random username from a predefined list
  public static String getRandomUsername() {
    String[] names = { "Ahri", "Yasuo", "Lux", "Lee Sin", "Jinx", "Akali", "Thresh", "Jhin", "Annie" };
    Random random = new Random();
    String name = names[random.nextInt(names.length)];
    return name;
  }

  // Method to move the player's position by a given deltaX and deltaY
  public void move(int deltaX, int deltaY) {
    this.positionX += deltaX;
    this.positionY += deltaY;
  }

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

  public boolean onCoordinate(String coordinate) {
    coordinate = coordinate.toUpperCase();
    int row = coordinate.charAt(0) - 'A';
    int col;
    if (coordinate.length() > 2) {
      col = Integer.parseInt(coordinate.substring(1, 3)) - 1;
    } else {
      col = Character.getNumericValue(coordinate.charAt(1)) - 1;
    }
    if ((this.positionX == row) && (this.positionY == col)) {
      return true;
    } else {
      return false;
    }
  }

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