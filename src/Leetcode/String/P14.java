package Leetcode.String;

public class P14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String shortest = shortest(strs);
        if (shortest == null || shortest.length() == 0) {
            return "";
        }
        for (String str : strs) {
            shortest = commonPrefix(shortest, str);
            if (shortest.length() == 0) {
                return "";
            }
        }
        return shortest;
    }

    public static String shortest(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String shortest = null;
        for (String str : strs) {
            if (shortest == null || (str != null && str.length() < shortest.length())) {
                shortest = str;
            }
        }
        return shortest;
    }

    public static String commonPrefix(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return "";
        }
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.length() < s2.length() ? s1 : s2;
    }
}
