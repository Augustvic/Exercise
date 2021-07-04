package Leetcode.TwoPointer;

import java.util.Arrays;

public class P16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < diff) {
                    ret = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ret;
    }
}
