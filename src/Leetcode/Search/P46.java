package Leetcode.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gcx
 */
public class P46 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
            list.add(nums[i]);
            visited[i] = true;
            recursion(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
