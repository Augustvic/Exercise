package Leetcode.BinarySearch;

public class P29 {

    public static void main(String[] args) {
        System.out.println(divide(-1010369383, -2147483648));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        int ret = help(Math.abs((long)dividend), Math.abs((long)divisor));
        return isNegative ? -ret : ret;
    }

    public static int help(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long base = divisor;
        int count = 1;
        while (base + base <= dividend) {
            base = base + base;
            count = count + count;
        }
        return count + help(dividend - base, divisor);
    }































//    public static int divide(int dividend, int divisor) {
//        if (divisor == 1)
//            return dividend;
//        if (divisor == -1)
//            return (dividend != Integer.MIN_VALUE) ? (-dividend) : Integer.MAX_VALUE;
//        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
//        long dividendL = Math.abs((long)dividend);
//        long divisorL = Math.abs((long)divisor);
//        int ret = help(dividendL, divisorL);
//        return isNegative ? -ret : ret;
//    }
//
//    public static int help(long dividend, long divisor) {
//        if (dividend < divisor)
//            return 0;
//        long base = divisor;
//        int count = 1;
//        while ((base + base) <= dividend) {
//            count = count + count;
//            base = base + base;
//        }
//        return count + help(dividend - base, divisor);
//    }
}
