package Leetcode.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> l : list) {
            for (int k : l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            help(list, nums, i + 1, nums.length - 1, -nums[i]);
        }
        return list;
    }

    public static void help(List<List<Integer>> list, int[] nums, int l, int r, int target) {
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                List<Integer> ret = new ArrayList<>();
                ret.add(-target);
                ret.add(nums[l]);
                ret.add(nums[r]);
                list.add(ret);
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++; r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
