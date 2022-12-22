package Leetcode.Math;

public class P7 {

    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);
        int ret = 0;
        while (x > 0) {
            int remain = x % 10;
            if (isOverFlow(isNegative, ret, remain)) {
                return 0;
            }
            ret = ret * 10 + remain;
            x = x / 10;
        }
        return isNegative ? -ret : ret;
    }

    public static boolean isOverFlow(boolean isNegative, int x, int remain) {
        int secondMinValue = Integer.MIN_VALUE / 10;
        int secondMaxValue = Integer.MAX_VALUE / 10;
        return (isNegative && (-x < secondMinValue || (-x == secondMinValue && remain > 8)))
                || (!isNegative && (x > secondMaxValue || ( x == secondMaxValue && remain > 7)));
    }
}
