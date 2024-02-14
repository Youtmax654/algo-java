
public class Board {
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

  public static String[][] addPlayer(String[][] board, Player player1, Player player2) {
    String[] pawns = { "\u001B[31m \u25A0 \u001B[0m", "\u001B[34m \u25A0 \u001B[0m" };
    board[player1.positionX][player1.positionY] = pawns[0];
    board[player2.positionX][player2.positionY] = pawns[1];
    return board;
  }
}