package Utils;

public class Console {
  // This class provides utility methods for interacting with the console.

  /**
   * Method that clear the console screen.
   */
  public static void clear() {
    System.out.print("\033c");
    System.out.flush();
  }

  public static void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
