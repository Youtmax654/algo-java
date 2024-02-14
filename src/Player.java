import java.util.Random;

public class Player {
  public int positionX;
  public int positionY;
  public String username;

  public Player(int positionX, int positionY, String username) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.username = username;
  }

  // Random Pseudo
  public static String getRandomUsername() {
    String[] names = { "Ahri", "Yasuo", "Lux", "Lee Sin", "Jinx", "Akali", "Thresh", "Jhin", "Annie" };
    Random random = new Random();
    String name = names[random.nextInt(names.length)];
    return name;
  }
}
