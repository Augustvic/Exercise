package Leetcode.Backtracking;

import java.util.Arrays;

public class P37 {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for (char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void solveSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] columnUsed = new boolean[9][10];
        boolean[][] cubeUsed = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = board[i][j] - '0';
                rowUsed[i][k] = true;
                columnUsed[j][k] = true;
                cubeUsed[getCubeNum(i, j)][k] = true;
            }
        }
        backTracking(board, 0, 0, rowUsed, columnUsed, cubeUsed);
    }

    public static boolean backTracking(char[][] board, int i, int j, boolean[][] rowUsed, boolean[][] columnUsed, boolean[][] cubeUsed) {
        if (i >= 9) {
            return true;
        }
        int nextI = j >= 8 ? i + 1 : i;
        int nextJ = j >= 8 ? 0 : j + 1;
        if (board[i][j] != '.') {
            return backTracking(board, nextI, nextJ, rowUsed, columnUsed, cubeUsed);
        }
        for (int k = 1; k <= 9; k++) {
            if (isNotValidNum(k, i, j, rowUsed, columnUsed, cubeUsed)) {
                continue;
            }
            rowUsed[i][k] = true;
            columnUsed[j][k] = true;
            cubeUsed[getCubeNum(i, j)][k] = true;
            board[i][j] = (char)(k + '0');
            if (backTracking(board, nextI, nextJ, rowUsed, columnUsed, cubeUsed)) {
                return true;
            }
            rowUsed[i][k] = false;
            columnUsed[j][k] = false;
            cubeUsed[getCubeNum(i, j)][k] = false;
            board[i][j] = '.';
        }
        return false;
    }

    public static boolean isNotValidNum(int k, int i, int j, boolean[][] rowUsed, boolean[][] columnUsed, boolean[][] cubeUsed) {
        return rowUsed[i][k] || columnUsed[j][k] || cubeUsed[getCubeNum(i, j)][k];
    }

    public static int getCubeNum(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
