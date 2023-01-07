package Leetcode.ArrayAndMatrix;

import java.util.Arrays;

public class P27 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeElement(nums, 1);
        int[] arr = Arrays.copyOfRange(nums, 0, len);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i == nums.length) {
                break;
            }
            nums[curr++] = nums[i];
        }
        return curr;
    }
}
