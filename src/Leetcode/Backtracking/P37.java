package Leetcode.Backtracking;

import java.util.Arrays;

public class P37 {

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

    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] columnUsed = new boolean[9][10];
    static boolean[][] cubeUsed = new boolean[9][10];

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    rowUsed[i][k] = true;
                    columnUsed[j][k] = true;
                    cubeUsed[cubeNum(i, j)][k] = true;
                }
            }
        }
        help(board, 0, 0, 9, 9);
    }

    public static boolean help(char[][] board, int i, int j, int m, int n) {
        if (i >= 9) {
            return true;
        }
        int nextI = (j == 8) ? i + 1 : i;
        int nextJ = (j == 8) ? 0 : j + 1;
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                if (validNum(i, j, k)) {
                    board[i][j] = (char) (k + '0');
                    rowUsed[i][k] = true;
                    columnUsed[j][k] = true;
                    cubeUsed[cubeNum(i, j)][k] = true;
                    if (help(board, nextI, nextJ, m, n)) {
                        return true;
                    }
                    board[i][j] = '.';
                    rowUsed[i][k] = false;
                    columnUsed[j][k] = false;
                    cubeUsed[cubeNum(i, j)][k] = false;
                }
            }
        } else {
            return help(board, nextI, nextJ, m, n);
        }
        return false;
    }

    public static boolean validNum(int i, int j, int k) {
        return !(rowUsed[i][k] || columnUsed[j][k] || cubeUsed[cubeNum(i, j)][k]);
    }

    public static int cubeNum(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }
}
