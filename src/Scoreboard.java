import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The Scoreboard class represents a scoreboard that keeps track of player names
 * and scores.
 * It provides methods to add scores, retrieve player names and scores, save
 * scores to a file,
 * load scores from a file, and sort scores in ascending or descending order.
 */
public class Scoreboard {
  // ArrayList to store player names
  private static ArrayList<String> players = new ArrayList<String>();
  // ArrayList to store player scores
  private static ArrayList<Integer> scores = new ArrayList<Integer>();

  /**
   * Adds a score for a player to the scoreboard.
   * If the player already exists in the scoreboard, the score is updated by
   * adding the new score.
   * If the player does not exist, the player and score are added to the
   * scoreboard.
   *
   * @param playerName the name of the player
   * @param score      the score to be added
   */
  public static void addScore(String playerName, int score) {
    // If player already exists in the scoreboard
    if (players.contains(playerName)) {
      // Get the index of the player
      int index = players.indexOf(playerName);
      // Get the current score of the player
      int currentScore = scores.get(index);
      // Update the score by adding the new score
      scores.set(index, currentScore + score);
      return;
    } else {
      // If player does not exist, add the player and score to the scoreboard
      players.add(playerName);
      scores.add(score);
    }
  }

  /**
   * Returns the list of players.
   *
   * @return the list of players
   */
  public static ArrayList<String> getPlayers() {
    return players;
  }

  /**
   * Returns the list of scores.
   *
   * @return the list of scores
   */
  public static ArrayList<Integer> getScores() {
    return scores;
  }

  /**
   * Saves the scores of players to a file.
   * The scores are written in binary format.
   * If an error occurs while saving the scores, an error message is printed and
   * the exception is logged.
   */
  public static void saveScores() {
    try {
      // Create a new file object
      File file = new File("scores.bn");
      // Create a new file writer object
      FileWriter writer = new FileWriter(file);
      // Write the scores to the file
      for (int i = 0; i < players.size(); i++) {
        writer.write(App.stringToBinary(players.get(i) + "," + scores.get(i) + "\n"));
      }
      // Close the file writer
      writer.close();
      System.out.println("\u001B[32mScores saved successfully.\u001B[0m");
      Console.sleep(2000);
    } catch (IOException e) {
      // Print the error message
      System.out.println("\u001B[31mAn error occurred while saving the scores.\u001B[0m");
      Console.sleep(2000);
      e.printStackTrace();
    }
  }

  /**
   * Loads the scores from a file and populates the players and scores lists.
   * If the file exists, it reads the file line by line, converts the binary data
   * to string, splits the string by comma, and adds the player and score to the
   * respective lists.
   * If the file does not exist, it displays a message indicating no scores found.
   * If an error occurs while loading the scores, it prints an error message and
   * the stack trace.
   */
  public static void loadScores() {
    try {
      // Create a new file object
      File file = new File("scores.bn");
      // Check if the file exists
      if (file.exists()) {
        players.removeAll(players);
        scores.removeAll(scores);
        // Create a new scanner object to read the file
        java.util.Scanner scanner = new java.util.Scanner(file);
        // Read the file line by line
        while (scanner.hasNextLine()) {
          // Read the line and convert it to binary
          String line = scanner.nextLine();
          // Convert the binary to string

          // Convert the binary data to a string
          String dataString = "";
          try {
            dataString = App.binaryToString(line);
          } catch (Exception e) {
            // Print an error message if an exception occurs while converting the binary
            // data
            System.out.println("\u001B[31mAn error occurred while loading the scores.\u001B[0m");
            Console.sleep(2000);
            e.printStackTrace();
            return;
          }

          // Split the string by comma and add the player and score to the lists
          dataString.lines().forEach(data -> {
            String[] dataArray = data.split(",");
            players.add(dataArray[0]);
            scores.add(Integer.parseInt(dataArray[1]));
          });
        }

        // Close the scanner
        scanner.close();
        System.out.println("\u001B[32mScores loaded successfully.\u001B[0m");
        Console.sleep(2000);
      } else {
        System.out.println("\u001B[31mNo scores found.\u001B[0m");
        Console.sleep(2000);
      }
    } catch (IOException e) {
      // Print the error message
      System.out.println("\u001B[31mAn error occurred while loading the scores.\u001B[0m");
      Console.sleep(2000);
      e.printStackTrace();
    }
  }

  /**
   * Sorts the scores in ascending order.
   * This method uses a bubble sort algorithm to rearrange the scores and players
   * in ascending order.
   * The lowest score will be at index 0, and the highest score will be at the end
   * of the list.
   */
  public static void sortAsc() {
    for (int i = 0; i < scores.size(); i++) {
      for (int j = i + 1; j < scores.size(); j++) {
        if (scores.get(i) > scores.get(j)) {
          // Swap the scores and players
          int tempScore = scores.get(i);
          scores.set(i, scores.get(j));
          scores.set(j, tempScore);

          String tempPlayer = players.get(i);
          players.set(i, players.get(j));
          players.set(j, tempPlayer);
        }
      }
    }
  }

  /**
   * Sorts the scores in descending order.
   * This method uses a bubble sort algorithm to rearrange the scores and players
   * in descending order.
   * The highest score will be at index 0, and the lowest score will be at the end
   * of the list.
   */
  public static void sortDesc() {
    for (int i = 0; i < scores.size(); i++) {
      for (int j = i + 1; j < scores.size(); j++) {
        if (scores.get(i) < scores.get(j)) {
          // Swap the scores and players
          int tempScore = scores.get(i);
          scores.set(i, scores.get(j));
          scores.set(j, tempScore);

          String tempPlayer = players.get(i);
          players.set(i, players.get(j));
          players.set(j, tempPlayer);
        }
      }
    }
  }
}
