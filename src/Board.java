
public class Board {
  public static void printBoard(String[][] board) {
    System.out.println("\u001B[34m+----+----+----+----+----+----+----+----+----+-----+-----+\u001B[0m");
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print("\u001B[34m| \u001B[0m");
        System.out.print(board[row][col] + " ");
      }
      System.out.println("\u001B[34m|\u001B[0m");
      System.out.println("\u001B[34m+----+----+----+----+----+----+----+----+----+-----+-----+\u001B[0m");
    }
  }
}