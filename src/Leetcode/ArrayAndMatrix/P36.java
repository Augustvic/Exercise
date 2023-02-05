package Leetcode.ArrayAndMatrix;

public class P36 {

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] columnUsed = new boolean[9][10];
        boolean[][] cubeUsed = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int k = board[i][j] - '0';
                if (rowUsed[i][k] || columnUsed[j][k] || cubeUsed[getCubeNum(i, j)][k]) {
                    return false;
                }
                rowUsed[i][k] = true;
                columnUsed[j][k] = true;
                cubeUsed[getCubeNum(i, j)][k] = true;
            }
        }
        return true;
    }

    public static int getCubeNum(int i, int j) {
        return i / 3 * 3 + j / 3;
    }
}
