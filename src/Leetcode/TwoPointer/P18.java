package Leetcode.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};
        List<List<Integer>> ret = fourSum(nums, -1000000000);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        long max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            if (nums[i] + max * 3 < target) continue;
            if ((long)nums[i] * 4 > target) break;
            threeSum(nums, target, nums[i], i + 1, result);
        }
        return result;
    }

    public static void threeSum(int[] nums, int target, int a, int startIndex, List<List<Integer>> result) {
        long max = nums[nums.length - 1];
        for (int i = startIndex; i < nums.length - 2; i++) {
            if (i != startIndex && nums[i - 1] == nums[i]) continue;
            if (nums[i] + max * 2 < target - a) continue;
            if ((long)nums[i] * 3 > target - a) break;
            twoSum(nums, target, a, nums[i], i + 1, result);
        }
    }

    public static void twoSum(int[] nums, int target, int a, int b, int startIndex, List<List<Integer>> result) {
        int l = startIndex, r = nums.length - 1;
        while (l < r) {
            int sum = a + b + nums[l] + nums[r];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                list.add(nums[l]);
                list.add(nums[r]);
                result.add(list);
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
    }
}
