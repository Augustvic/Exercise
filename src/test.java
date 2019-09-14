import DataStructure.BinaryTree;
import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3, 3, 2, 5, 5, 6};
        t.find1(nums1);
        int[] nums3 = {2, 4, 3, 2, 4, 7, 3, 3, 4, 2};
        System.out.println(t.find2(nums3));
    }

    public static test t = new test();

    public void find1(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int xorAll = 0;
        for (int num : nums) {
            xorAll = xorAll ^ num;
        }
        int index = indexOfLast1(xorAll);
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (is1(num, index))
                a = a ^ num;
            else
                b = b ^ num;
        }
        System.out.println("[" + a + "," + b + "]");
    }

    private int indexOfLast1(int k) {
        int index = 0;
        while ((k & 1) == 0) {
            index++;
            k = k >> 1;
        }
        return index;
    }

    private boolean is1(int k, int index) {
        k = k >> index;
        return (k & 1) == 1;
    }

    public int find2(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += (nums[j] % 2 == 0) ? 0 : 1;
                nums[j] = nums[j] >> 1;
            }
            bits[i] = sum % 3;
        }
        int ret = 0;
        for (int i = 31; i >= 0; i--) {
            ret = ret << 1;
            ret += bits[i];
        }
        return ret;
    }
}
