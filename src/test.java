import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        System.out.println(t.translate(12058));
    }

    public static test t = new test();

    private int pos = 0;

    public int translate(int num) {
        if (num < 0)
            return 0;
        if (num < 10)
            return 1;
        String s = String.valueOf(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int two = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        dp[1] = (two >= 10 && two <= 25) ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            int t = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            dp[i] = (t >= 10 && t <= 25) ? dp[i - 2] + dp[i - 1] : dp[i - 1];
        }
        return dp[s.length() - 1];
    }
}
