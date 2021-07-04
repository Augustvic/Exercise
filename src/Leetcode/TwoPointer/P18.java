package Leetcode.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        List<List<Integer>> ret = fourSum(nums, 8);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + max * 3 < target) continue;
            if (nums[i] * 4 > target) break;
            threeSum(ret, nums, i + 1, target - nums[i], i);
        }
        return ret;
    }

    public static void threeSum(List<List<Integer>> ret, int[] nums, int start, int target, int a) {
        int max = nums[nums.length - 1];
        for (int i = start; i < nums.length - 2; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            if (nums[i] + max * 2 < target) continue;
            if (nums[i] * 3 > target) break;
            twoSum(ret, nums, i + 1, target - nums[i], a, i);
        }
    }

    public static void twoSum(List<List<Integer>> ret, int[] nums, int start, int target, int a, int b) {
        int l = start, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[a]);
                list.add(nums[b]);
                list.add(nums[l]);
                list.add(nums[r]);
                ret.add(list);
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
