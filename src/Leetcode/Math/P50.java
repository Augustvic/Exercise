package Leetcode.Math;

public class P50 {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (n == 1) {
            return x;
        }
        boolean isNegative = (n < 0);
        n = Math.abs(n);
        double ret = myPow(x, n >>> 1);
        ret = ret * ret;
        if ((n & 1) == 1) {
            ret = ret * x;
        }
        return isNegative ? 1 / ret : ret;
    }
}
