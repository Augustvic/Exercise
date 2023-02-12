package Leetcode.DynamicProgramming;

public class P44 {

    public static void main(String[] args) {
        String s = "";
        String p = "*****";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            dp[i][0] = p.charAt(i - 1) == '*' && dp[i - 1][0];
        }
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                boolean currentEqual = p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1);
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = (currentEqual) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
