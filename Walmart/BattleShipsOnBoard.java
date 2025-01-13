package Walmart;

public class BattleShipsOnBoard {
    public int countBattleships(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }

        return count;
    }
}
