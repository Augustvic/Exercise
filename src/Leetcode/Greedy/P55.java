package Leetcode.Greedy;

import java.util.Date;

public class P55 {

    public static void main(String[] args) {
        System.out.println((new Date()).getTime());
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int index = 0;
        int max = 0;
        while (index <= max && max < nums.length - 1) {
            max = Math.max(max, nums[index] + index);
            index++;
        }
        return max >= nums.length - 1;
    }
}
