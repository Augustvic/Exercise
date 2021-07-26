import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) {
            return ret;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + max * 3 < target) {
                continue;
            }
            if (nums[i] * 4 > target) {
                continue;
            }
            threeSum(ret, nums, target - nums[i], i + 1, i);
        }
        return ret;
    }

    public static void threeSum(List<List<Integer>> ret, int[] nums, int target, int start, int a) {
        int max = nums[nums.length - 1];
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + max * 2 < target) {
                continue;
            }
            if (nums[i] * 3 > target) {
                continue;
            }
            twoSum(ret, nums, target - nums[i], i + 1, a, i);
        }
    }

    public static void twoSum(List<List<Integer>> ret, int[] nums, int target, int start, int a, int b) {
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
                while (l < r && nums[l] == nums[l + 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r - 1]) {
                    r--;
                }
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