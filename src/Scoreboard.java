import java.util.ArrayList;

/**
 * The Scoreboard class represents a scoreboard that keeps track of player names
 * and scores.
 */
public class Scoreboard {
  // ArrayList to store player names
  private static ArrayList<String> players = new ArrayList<String>();
  // ArrayList to store player scores
  private static ArrayList<Integer> scores = new ArrayList<Integer>();

  // Method to add score for a player
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

  public static ArrayList<String> getPlayers() {
    return players;
  }

  public static ArrayList<Integer> getScores() {
    return scores;
  }
}
