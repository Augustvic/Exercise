package Leetcode.String;

public class P5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                int p = i + j;
                int q = i;
                while ((p > 0) && (q < s.length() - 1) && (s.charAt(p - 1) == s.charAt(q + 1))) {
                    p--;
                    q++;
                }
                if (q - p > end - start) {
                    start = p;
                    end = q;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
