// This class represents a game board.
public class Board {

  public static String[][] createBoard(int rows, int cols) {
    // Create a game board with empty cells
    String[][] gameBoard = new String[rows][cols];
    char row = 'A';
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j > 9 - 1)
          gameBoard[i][j] = row + Integer.toString(j + 1);
        else
          gameBoard[i][j] = row + Integer.toString(j + 1) + " ";
      }
      row++;
    }
    return gameBoard;
  }

  // This method prints the game board.
  public static void printBoard(String[][] board) {
    System.out.println("\u001B[34m+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\u001B[0m");
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print("\u001B[34m| \u001B[0m");
        System.out.print(board[row][col] + " ");
      }
      System.out.println("\u001B[34m|\u001B[0m");
      System.out.println("\u001B[34m+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+\u001B[0m");
    }
  }

  // This method adds the players' pawns to the board.
  public static String[][] addPlayer(String[][] board, Player player1, Player player2) {
    String[] pawns = { "\u001B[31m \u25A0 \u001B[0m", "\u001B[34m \u25A0 \u001B[0m" };
    board[player1.positionX][player1.positionY] = pawns[0];
    board[player2.positionX][player2.positionY] = pawns[1];
    return board;
  }

  public static String[][] destroyBlock(String[][] gameBoard, String coordinate) {
    coordinate = coordinate.toUpperCase();
    int row = coordinate.charAt(0) - 'A';
    int col;
    if (coordinate.length() > 2) {
      col = Integer.parseInt(coordinate.substring(1, 3)) - 1;
    } else {
      col = Character.getNumericValue(coordinate.charAt(1)) - 1;
    }
    gameBoard[row][col] = "   ";
    return gameBoard;
  }
}