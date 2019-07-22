import java.util.*;

public class test {

    public static void main(String[] args) {
        int[][] nums = {{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(t.kthSmallest(nums, 8));
    }

    public static test t = new test();

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lt = matrix[0][0];
        int rb = matrix[m - 1][n - 1];
        while (lt <= rb) {
            int mid = lt + (rb - lt) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++)
                    cnt++;
            }
            if (cnt < k)
                lt = mid + 1;
            else
                rb = mid - 1;
        }
        return lt;
    }
}
