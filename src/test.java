import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        System.out.println(t.minSteps(4));
    }

    public static test t = new test();

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0)
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
            }
        }
        return dp[n];
    }
}
