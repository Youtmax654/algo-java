// This class represents a game and contains a static method to display the game board.

public class Game {
  
  // This method takes a 2D array representing the game board and prints it to the console.
  public static void showBoard(char[][] table) {
      for (int i = 0; i < table.length; i++) {
        for (int j = 0; j < table[i].length; j++) {
            System.out.print(table[i][j] + "\u25A0 "); // Print each element of the board followed by a square symbol
        }
        System.out.println(); // Move to the next line after printing each row
    }
  }
}
