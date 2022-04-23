import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(myPow(2, Integer.MIN_VALUE));
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

//     public static double myPow(double x, int n) {
//         if (n == 0) {
//             return 1.0d;
//         }
//         if (n == -1) {
//             return 1 / x;
//         }
//         if (n == 1) {
//             return x;
//         }
//         boolean isNegative = false;
//         if (n < 0) {
//             n = Math.abs(n);
//             isNegative = true;
//         }
//         double base = myPow(x, n/2);
//         base = base * base;
//         if ((n & 1) == 1) {
//             base = base * x;
//         }
//         return isNegative ?  1 / base : base;
//     }
}