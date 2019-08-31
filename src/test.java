import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums1 = {7, 4, 6, 5};
        int[] nums2 = {5, 7, 6, 9, 11, 10, 8};
        int[] nums3 = {13, 12, 11, 10, 9, 8};
        int[] nums4 = {8, 9, 10, 11, 12, 13};
        System.out.println(t.isPostOrderOfBST(nums1));
        System.out.println(t.isPostOrderOfBST(nums2));
        System.out.println(t.isPostOrderOfBST(nums3));
        System.out.println(t.isPostOrderOfBST(nums4));
    }

    public static test t = new test();

    public boolean isPostOrderOfBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length == 1)
            return true;
        return isPostOrderOfBSTHelp(nums, 0, nums.length - 1);
    }

    public boolean isPostOrderOfBSTHelp(int[] nums, int l, int r) {
        if (l >= r)
            return true;
        int index = l;
        int rootVal = nums[r];
        while (index < r && nums[index] < rootVal)
            index++;
        if (isRightSubtree(nums, index, r - 1, rootVal)) {
            return isPostOrderOfBSTHelp(nums, l, index - 1)
                    && isPostOrderOfBSTHelp(nums, index, r - 1);
        }
        return false;
    }

    public boolean isRightSubtree(int[] nums, int l, int r, int k) {
        for (int i = l; i <= r; i++) {
            if (nums[i] < k)
                return false;
        }
        return true;
    }
}
