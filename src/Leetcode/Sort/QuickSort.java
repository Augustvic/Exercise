package Leetcode.Sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3, 2, 5, 4, 6, 7};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int p = r;
        while (l < r) {
            while (l < r && nums[l] < nums[p]) l++;
            while (l < r && nums[r] >= nums[p]) r--;
            swap(nums, l, r);
        }
        swap(nums, l, p);
        return l;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
