import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        int[] nums1 = {7, 8, 9, 10, 11};
        int[] nums2 = {11, 10, 9, 8, 7, 6};
        System.out.println(t.maxProfit(nums));
        System.out.println(t.maxProfit(nums1));
        System.out.println(t.maxProfit(nums2));
    }

    public static test t = new test();

    public int maxProfit(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int minPrice = nums[0];
        int maxProfit = 0;
        for (int i = 1; i < nums.length; i++) {
           int diff = nums[i] - minPrice;
            if (diff > maxProfit)
                maxProfit = diff;
            if (nums[i] < minPrice)
                minPrice = nums[i];
        }
        return maxProfit;
    }
}
