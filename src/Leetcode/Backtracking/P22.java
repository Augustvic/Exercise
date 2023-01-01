package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class P22 {

    public static void main(String[] args) {
        List<String> ret = generateParenthesis(2);
        System.out.println(ret);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        recurse(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public static void recurse(List<String> result, StringBuilder sb, int left, int right, int n) {
        if (left > n || right > n || left < right) {
            return;
        }
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        sb.append('(');
        recurse(result, sb, left + 1, right, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        recurse(result, sb, left, right + 1, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
