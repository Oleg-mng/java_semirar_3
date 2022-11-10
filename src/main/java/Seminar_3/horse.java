package Seminar_3;

import java.util.ArrayList;
import java.util.List;

public class horse {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        sol.solveHorse(5);
    }
}
class Solution1 {
    int[][] board;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveHorse(int n) {
        board = new int[n][n];
        backtrack(0);
        return ans;
    }

    private void backtrack (int col) {
        if (col == board.length) {
            addBoard();
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (canPlace (row, col)) {
                board[row][col] = 1;
                backtrack(col + 1);
                board[row][col] = 0;
            }
        }
    }

    private boolean canPlace(int i, int j) {
        //налево
        for (int col = j -1; col >= 0; col--) {
            if (board[i][col] == 1) return false;
        }
        board[i][j] = board[i][j] + moves [i][j]
        //вверх по диагонали
        for (int row = i + moves[i, j], col = j + moves[i, j]; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 1) return false;
        }
        //вниз по диагонали
        for (int row = i+1, col = j -1; row < board.length && col >= 0; row++, col--) {
            if (board[row][col] == 1) return false;
        }
        return true;
    }
    private void addBoard() {
        List<String> b = new ArrayList<>();
        int k = 0; // порядковый номер успеха
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] == 0 ? '.' : k);
                k++;
            }
            b.add(sb.toString());
        }
        ans.add(b);
    }
}




