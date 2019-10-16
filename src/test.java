import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
    }

    public static test t = new test();

    private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] columnUsed = new boolean[9][10];
    private boolean[][] cubeUsed = new boolean[9][10];

    public int solveSudoku(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[N][W];
    }

    private boolean solveSudokuHelp(char[][] board, int i, int j) {
        while (i < 9 && board[i][j] != '.') {
            i = (j == 8) ? (i + 1) : i;
            j = (j == 8) ? 0 : j + 1;
        }
        for (int k = 1; k <= 9; k++) {
            if (!rowUsed[i][k] && !columnUsed[j][k] && !cubeUsed[cubeNum(i, j)][k]) {
                board[i][j] = (char)(k + '0');
                rowUsed[i][k] = true;
                columnUsed[j][k] = true;
                cubeUsed[cubeNum(i, j)][k] = true;
                if (solveSudokuHelp(board, i, j))
                    return true;
                board[i][j] = '.';
                rowUsed[i][k] = false;
                columnUsed[j][k] = false;
                cubeUsed[cubeNum(i, j)][k] = false;
            }
        }
        return false;
    }

    private int cubeNum(int i, int j) {
        i = i / 3;
        j = j / 3;
        return i * 3 + j;
    }
}
