import java.util.Random;

public class Player {
  // Random Pseudo
  public static String getRandomUsername() {
    String[] names = { "Ahri", "Yasuo", "Lux", "Lee Sin", "Jinx", "Akali", "Thresh", "Jhin", "Annie" };
    Random random = new Random();
    String name = names[random.nextInt(names.length)];
    return name;
  }
}
