package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40 {

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ret = combinationSum2(candidates, target);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        help(ret, new ArrayList<>(), candidates, target, 0, visited);
        return ret;
    }

    public static void help(List<List<Integer>> ret, List<Integer> list, int[] candidates, int target, int start, boolean[] visited) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i != 0 && !visited[i - 1] && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                list.add(candidates[i]);
                help(ret, list, candidates, target - candidates[i], i + 1, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
