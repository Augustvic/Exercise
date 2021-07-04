package Leetcode.String;

public class P14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String shortest = shortestString(strs);
        for (String str : strs) {
            shortest = commonPrefix(shortest, str);
            if (shortest.length() == 0) {
                return shortest;
            }
        }
        return shortest;
    }

    public static String shortestString(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        return shortest;
    }

    public static String commonPrefix(String str1, String str2) {
        int range = Math.min(str1.length(), str2.length());
        int end = 0;
        while (end < range && (str1.charAt(end) == str2.charAt(end))) {
            end++;
        }
        return str1.substring(0, end);
    }
}
