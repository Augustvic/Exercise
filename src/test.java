import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        t.sortColors(nums);
        System.out.println();
    }

    public static test t = new test();

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int l = 0;
        int r = nums.length - 1;
        int curr = 0;
        while (curr <= r) {
            if (nums[curr] == 0)
                swap(nums, l++, curr++);
            else if (nums[curr] == 2)
                swap(nums, curr, r--);
            else
                curr++;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
