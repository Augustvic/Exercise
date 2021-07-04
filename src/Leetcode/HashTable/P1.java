package Leetcode.HashTable;

import java.util.HashMap;

public class P1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hm.containsKey(num)) {
                result[0] = hm.get(num);
                result[1] = i;
                break;
            }
            hm.put(target - num, i);
        }
        return result;
    }
}
