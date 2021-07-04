package Leetcode.ArrayAndMatrix;

import java.util.HashSet;

public class P41 {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!hs.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
