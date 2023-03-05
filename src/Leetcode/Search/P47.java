package Leetcode.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gcx
 */
@SuppressWarnings("all")
public class P47 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 0, 3};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        recursion(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void recursion(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list != null && list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            recursion(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
