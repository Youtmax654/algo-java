
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

  public static String[][] showPlayer(String[][] board, int player) {
    String[] pawns = { "\u001B[31m \u25A0 \u001B[0m", "\u001B[34m \u25A0 \u001B[0m" };

    switch (player) {
      case 2:
        board[4][5] = pawns[0];
        board[5][5] = pawns[1];
        return board;
      default:
        break;
    }
    return board;
  }
}