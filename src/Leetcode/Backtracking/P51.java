package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51 {

    public static void main(String[] args) {
        List<List<String>> ret = solveNQueens(4);
        for (List<String> list : ret) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("--------------");
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        char[][] nQueens = new char[n][n];
        for (char[] queens : nQueens) {
            Arrays.fill(queens, '.');
        }
        help(ret, nQueens, new boolean[2 * n - 1], new boolean[2 * n - 1], new boolean[n], 0, n);
        return ret;
    }

    public static void help(List<List<String>> ret, char[][] nQueens,
                            boolean[] diagonal45, boolean[] diagonal135,
                            boolean[] column, int row, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] queens : nQueens) {
                list.add(String.valueOf(queens));
            }
            ret.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            int index45 = row + j;
            int index135 = n - j - 1 + row;
            if (!diagonal45[index45] && !diagonal135[index135] && !column[j]) {
                nQueens[row][j] = 'Q';
                diagonal45[index45] = true;
                diagonal135[index135] = true;
                column[j] = true;
                help(ret, nQueens, diagonal45, diagonal135, column, row + 1, n);
                nQueens[row][j] = '.';
                diagonal45[index45] = false;
                diagonal135[index135] = false;
                column[j] = false;
            }
        }
    }
}
