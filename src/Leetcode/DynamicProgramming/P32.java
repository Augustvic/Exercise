package Leetcode.DynamicProgramming;

import java.util.LinkedList;

public class P32 {

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParenthesesDP(s));
    }

    public static int longestValidParenthesesStack(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;
        stack.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.removeLast();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    max = Math.max(max, i - stack.getLast());
                }
            }
        }
        return max;
    }

    public static int longestValidParenthesesDP(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = i - dp[i - 1] - 2 >= 0 ? dp[i - 1] + dp[i - dp[i - 1] - 2] + 2 : dp[i - 1] + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
