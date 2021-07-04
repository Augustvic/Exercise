package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class P22 {

    public static void main(String[] args) {
        List<String> ret = generateParenthesis(4);
        for (String s : ret) {
            System.out.println(s);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        help(ret, 0, 0, new StringBuilder(), n);
        return ret;
    }

    public static void help(List<String> ret, int left, int right, StringBuilder sb, int n) {
        if (left > n || right > n || right > left) {
            return;
        }
        if (left == n && right == n) {
            ret.add(sb.toString());
            return;
        }
        // '('
        sb.append('(');
        help(ret, left + 1, right, sb, n);
        sb.deleteCharAt(sb.length() - 1);
        // ')'
        sb.append(')');
        help(ret, left, right + 1, sb, n);
        sb.deleteCharAt(sb.length() - 1);
    }
}
