package Leetcode.ArrayAndMatrix;

public class P41 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(firstMissingPositive2(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if (k <= n) {
                nums[k - 1] = -Math.abs(nums[k - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int firstMissingPositive2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
                continue;
            }
            if (nums[i] - 1 > 0 && nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }
            swap(nums, i, nums[i] - 1);
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    public static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
