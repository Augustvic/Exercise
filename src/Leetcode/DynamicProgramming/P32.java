package Leetcode.DynamicProgramming;

public class P32 {

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParenthesesDP(s));
    }

    public static int longestValidParenthesesDP(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = i < 2 ? 2 : dp[i - 2] + 2;
                continue;
            }
            if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
            }
        }
        int max = dp[0];
        for (int k : dp) {
            max = Math.max(max, k);
        }
        return max;
    }
}
