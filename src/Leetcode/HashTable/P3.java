package Leetcode.HashTable;

import java.util.HashMap;

public class P3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charToPos = new HashMap<>();
        int max = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curr = charToPos.containsKey(c) ? Math.min(i - charToPos.get(c), pre + 1) : pre + 1;
            max = Math.max(pre = curr, max);
            charToPos.put(c, i);
        }
        return max;
    }
}
