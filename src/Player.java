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

  public boolean forbiddenPosition(Player otherPlayer, int deltaX, int deltaY, int attempts) {
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
    } else {
      return false;
    }
  }
}
