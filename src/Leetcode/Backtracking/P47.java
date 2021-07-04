package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ret = permuteUnique(nums);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        help(ret, nums, new ArrayList<>(), visited);
        return ret;
    }

    public static void help(List<List<Integer>> ret, int[] nums, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && !visited[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                help(ret, nums, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
