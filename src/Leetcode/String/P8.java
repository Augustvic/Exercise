package Leetcode.String;

public class P8 {

    public static void main(String[] args) {
        String s = " -1543-1";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        if ((s = s.trim()).length() <= 0) {
            return 0;
        }
        boolean isNegative = false;
        long ret = 0;
        if (s.startsWith("-") || s.startsWith("+")) {
            isNegative = s.startsWith("-");
            s = s.substring(1);
        }
        for (char c : s.toCharArray()) {
            if (!isDigit(c)) {
                break;
            }
            ret = ret * 10 + (c - '0');
            if (isOverFlow(isNegative, ret)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isNegative ? -(int)ret : (int)ret;
    }

    public static boolean isOverFlow(boolean isNegative, long ret) {
        return ((isNegative && -ret < Integer.MIN_VALUE)
                || (!isNegative && ret > Integer.MAX_VALUE));
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
