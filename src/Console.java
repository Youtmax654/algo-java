/**
 * The Console class provides utility methods for interacting with the console.
 */
public class Console {

  /**
   * Clears the console screen.
   * This method sends the escape sequence for clearing the console screen and
   * flushes the output stream.
   */
  public static void clear() {
    System.out.print("\033c");
    System.out.flush();
  }

  /**
   * Pauses the execution of the program for a specified duration.
   *
   * @param time The duration, in milliseconds, for which the program should
   *             sleep.
   */
  public static void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      // Prints the stack trace if the thread is interrupted during sleep.
      e.printStackTrace();
    }
  }
}
