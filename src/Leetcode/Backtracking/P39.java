package Leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ret = combinationSum(candidates, target);
        for (List<Integer> list : ret) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        help(result, list, candidates, target, 0);
        return result;
    }

    public static void help(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            help(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }





//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ret = new ArrayList<>();
//        Arrays.sort(candidates);
//        help(candidates, ret, new ArrayList<>(), target, 0);
//        return ret;
//    }
//
//    public static void help(int[] candidates, List<List<Integer>> ret, List<Integer> list, int target, int start) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            ret.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            int value = candidates[i];
//            list.add(value);
//            help(candidates, ret, list, target - value, i);
//            list.remove(list.size() - 1);
//        }
//    }
}
