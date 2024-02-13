package Utils;

public class Console {
  // This class provides utility methods for interacting with the console.

  /**
   * Method that clear the console screen.
   */
  public static void clear() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
  }
}
