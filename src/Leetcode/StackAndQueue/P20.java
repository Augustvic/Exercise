package Leetcode.StackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P20 {

    public static final Map<Character, Character> MAP = new HashMap<>();
    static {
        MAP.put(')', '(');
        MAP.put(']', '[');
        MAP.put('}', '{');
    }

    public static void main(String[] args) {
        System.out.println(isValid("([]){}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(c);
                continue;
            }
            if (MAP.containsKey(c)
                    && MAP.get(c).equals(stack.getLast())) {
                stack.removeLast();
                continue;
            }
            stack.addLast(c);
        }
        return stack.isEmpty();
    }
}
