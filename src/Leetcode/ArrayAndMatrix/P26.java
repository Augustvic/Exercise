package Leetcode.ArrayAndMatrix;

import java.util.Arrays;

public class P26 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        int[] arr = Arrays.copyOfRange(nums, 0, len);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }
            if (curr != i) {
                nums[curr] = nums[i];
            }
            curr++;
        }
        return curr;
    }
}
