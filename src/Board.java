import java.util.ArrayList;

/**
 * This class represents a game board.
 */
public class Board {
  /**
   * Creates a game board with the specified number of rows and columns.
   *
   * @param rows The number of rows in the board.
   * @param cols The number of columns in the board.
   * @return The created game board.
   */
  public static String[][] createBoard(int rows, int cols) {
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

  /**
   * Prints the game board.
   *
   * @param board The game board to be printed.
   */
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

  /**
   * Adds the players' pawns to the board.
   *
   * @param board   The game board.
   * @param player1 The first player.
   * @param player2 The second player.
   * @return The updated game board with players' pawns.
   */
  public static String[][] addPlayer(String[][] board, Player player1, Player player2) {
    String[] pawns = { "\u001B[31m \u25A0 \u001B[0m", "\u001B[34m \u25A0 \u001B[0m" };
    board[player1.positionX][player1.positionY] = pawns[0];
    board[player2.positionX][player2.positionY] = pawns[1];
    return board;
  }

  /**
   * Destroys a block on the game board.
   *
   * @param gameBoard  The game board.
   * @param coordinate The coordinate of the block to be destroyed.
   * @return The updated game board after destroying the block.
   */
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

  /**
   * Displays the game state, including players and destroyed blocks.
   *
   * @param player1         The first player.
   * @param player2         The second player.
   * @param destroyedBlocks List of coordinates of destroyed blocks.
   * @param gameBoard       The game board.
   * @return The updated game board after displaying the game state.
   */
  public static String[][] display(Player player1, Player player2, ArrayList<String> destroyedBlocks,
      String[][] gameBoard) {
    for (String block : destroyedBlocks) {
      gameBoard = Board.destroyBlock(gameBoard, block);
    }
    Console.clear();
    System.out.println("\u001B[32m***********************************");
    System.out.println("               Game               ");
    System.out.println("***********************************\u001B[0m\n");
    System.out.println(
        "\u001B[31m" + player1.username + "\u001B[0m" + " VS " + "\u001B[34m" + player2.username + "\u001B[0m\n");
    gameBoard = Board.addPlayer(gameBoard, player1, player2);
    Board.printBoard(gameBoard);
    return gameBoard;
  }
}
