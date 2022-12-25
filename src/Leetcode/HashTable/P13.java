package Leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class P13 {

    private static final Map<String, Integer> MAP = new HashMap<>();
    static {
        MAP.put("I", 1);
        MAP.put("V", 5);
        MAP.put("X", 10);
        MAP.put("L", 50);
        MAP.put("C", 100);
        MAP.put("D", 500);
        MAP.put("M", 1000);
        MAP.put("IV", 4);
        MAP.put("IX", 9);
        MAP.put("XL", 40);
        MAP.put("XC", 90);
        MAP.put("CD", 400);
        MAP.put("CM", 900);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() >= 2 && MAP.containsKey(s.substring(0, 2))) {
            return MAP.get(s.substring(0, 2)) + romanToInt(s.substring(2));
        }
        return MAP.get(s.substring(0, 1)) + romanToInt(s.substring(1));
    }
}
