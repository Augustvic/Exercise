package Leetcode.BinarySearch;

import java.util.Arrays;

public class P34 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            return nums[0] == target ? new int[]{0, 0} : new int[]{-1, -1};
        }
        int left = binarySearchLeft(nums, target);
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

    public static int binarySearchLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearchRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
