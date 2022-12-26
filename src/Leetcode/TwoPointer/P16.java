package Leetcode.TwoPointer;

import java.util.Arrays;

public class P16 {

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int currSum = a + nums[l] + nums[r];
                if (Math.abs(currSum - target) < Math.abs(sum - target)) {
                    sum = currSum;
                }
                if (currSum == target) {
                    return target;
                } else if (currSum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return sum;
    }
}
