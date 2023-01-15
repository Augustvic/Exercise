package Leetcode.ArrayAndMatrix;

import java.util.Arrays;

public class P31 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 5, 4, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int pre = nums.length - 1;
        while (pre > 0 && nums[pre - 1] >= nums[pre]) pre--;
        if (pre == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int post = nums.length - 1;
        while (post > pre && nums[post] <= nums[pre - 1]) post--;
        swap(nums, pre - 1, post);
        reverse(nums, pre, nums.length - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
