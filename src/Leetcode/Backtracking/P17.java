package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P17 {

    public static void main(String[] args) {
        String digits = "23";
        List<String> ret = letterCombinations(digits);
        for (String str : ret) {
            System.out.println(str);
        }
    }

    public static final HashMap<Character, String> digitToLetter = new HashMap<>();
    static {
        digitToLetter.put('2', "abc");
        digitToLetter.put('3', "def");
        digitToLetter.put('4', "ghi");
        digitToLetter.put('5', "jkl");
        digitToLetter.put('6', "mno");
        digitToLetter.put('7', "pqrs");
        digitToLetter.put('8', "tuv");
        digitToLetter.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        reverse(ret, new StringBuilder(), digits, 0);
        return ret;
    }

    public static void reverse(List<String> ret, StringBuilder sb, String digits, int pos) {
        if (pos == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        for (char c : digitToLetter.get(digits.charAt(pos)).toCharArray()) {
            sb.append(c);
            reverse(ret, sb, digits, pos + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
