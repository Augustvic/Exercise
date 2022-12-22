package Leetcode.Math;

public class P9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int halfReverse = 0;
        while (x > halfReverse) {
            halfReverse = halfReverse * 10 + x % 10;
            x = x / 10;
        }
        return x == halfReverse || x == halfReverse / 10;
    }
}
