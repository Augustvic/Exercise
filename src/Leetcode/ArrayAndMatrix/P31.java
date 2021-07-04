package Leetcode.ArrayAndMatrix;

import java.util.Arrays;

public class P31 {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 5, 4, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) l--;
        if (l == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int r = nums.length - 1;
        while (l < r && nums[r] <= nums[l]) r--;
        swap(nums, l, r);
        reverse(nums, l + 1, nums.length - 1);
    }

    public static void reverse(int[] nums, int l, int r) {
        if (l > r || r < 0 || l >= nums.length) return;
        if (l < 0) l = 0;
        if (r >= nums.length) r = nums.length - 1;
        while (l < r) {
            swap(nums, l ,r);
            l++;
            r--;
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
