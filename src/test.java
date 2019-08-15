import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int m = 100;
        int n = 100;
        System.out.print(t.movingCount(18, m, n));
    }

    public static test t = new test();

    public int movingCount(int threshold, int m, int n) {
        if (threshold < 0)
            return 0;
        boolean[][] visited = new boolean[m][n];
        return movingCountHelp(threshold, visited, m, n, 0, 0);
    }

    public int movingCountHelp(int threshold, boolean[][] visited, int m, int n, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !check(threshold, i, j))
            return 0;
        visited[i][j] = true;
        return 1 + movingCountHelp(threshold, visited, m, n, i + 1, j) +
                movingCountHelp(threshold, visited, m, n, i - 1, j) +
                movingCountHelp(threshold, visited, m, n, i, j + 1) +
                movingCountHelp(threshold, visited, m, n, i, j - 1);
    }

    public boolean check(int threshold, int i, int j) {
          return getSum(i) + getSum(j) <= threshold;
    }

    public int getSum(int k) {
        int sum = 0;
        while (k != 0) {
            sum += k % 10;
            k = k / 10;
        }
        return sum;
    }
}
