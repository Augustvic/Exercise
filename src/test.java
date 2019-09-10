import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 3, 3, 3, 3};
        int[] nums2 = {1, 2, 4, 5, 6, 7, 8, 9};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] nums4 = {1, 2, 3};
        int k = 3;
        System.out.println("1. Count: " + t.count(nums1, k));
        System.out.println("1. Count: " + t.count(nums2, k));
        System.out.println("1. Count: " + t.count(nums3, k));
        System.out.println("1. Count: " + t.count(nums4, k));
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums6 = {0, 2, 3, 4, 5, 6, 7};
        System.out.println("2. Missing Number: " + t.missingNumber(nums5));
        System.out.println("2. Missing Number: " + t.missingNumber(nums6));
        int[] nums7 = {-1, 0, 2, 4, 5};
        int[] nums8 = {-1, 0, 4, 5};
        System.out.println("3. Number Same As Index: " + t.numberSameAsIndex(nums7));
        System.out.println("3. Number Same As Index: " + t.numberSameAsIndex(nums8));
    }

    public static test t = new test();

    public int count(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        int first = firstIndex(nums, k);
        int last = lastIndex(nums, k);
        if (first == -1 && last == -1)
            return 0;
        return last - first + 1;
    }

    private int firstIndex(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] == k) {
                if (nums[mid - 1] == k) {
                    r = mid - 1;
                }
                else
                    return mid;
            }
            else if (nums[mid] > k) {
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return nums[l] == k ? l : -1;
    }

    private int lastIndex(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == k) {
                if (nums[mid + 1] == k) {
                    l = mid + 1;
                }
                else
                    return mid;
            }
            else if (nums[mid] > k) {
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return nums[l] == k ? l : -1;
    }

    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return nums[l] != l ? l : -1;
    }

    public int numberSameAsIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                return mid;
            }
            else if (nums[mid] > mid) {
                r = mid;
            }
            else
                l = mid + 1;
        }
        return Integer.MIN_VALUE;
    }
}
