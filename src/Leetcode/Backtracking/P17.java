package Leetcode.Backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class P17 {

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinationsWithNoRecur(digits));
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
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        recursion(digits, 0, new StringBuilder(), result);
        return result;
    }

    public static void recursion(String digits, int index, StringBuilder sb, List<String> result) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letter = digitToLetter.get(digits.charAt(index));
        for (char c : letter.toCharArray()) {
            sb.append(c);
            recursion(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> letterCombinationsWithNoRecur(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (char c : digits.toCharArray()) {
            List<String> currList = new ArrayList<>();
            for (String str : result) {
                for (char currChar : digitToLetter.get(c).toCharArray()) {
                    currList.add(str + currChar);
                }
            }
            result = currList;
        }
        return result;
    }
}
