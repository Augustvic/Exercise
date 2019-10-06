import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[][] M = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        System.out.println(t.findCircleNum(M));
    }

    public static test t = new test();

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0)
            return 0;
        int cnt = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(M, i, visited);
            }
        }
        return cnt;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == '1' && !visited[j])
                dfs(M, j, visited);
        }
    }
}
