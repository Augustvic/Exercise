import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
    }

    public static test t = new test();

    public int max(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int[] S = new int[nums.length];
        S[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            S[i] = Math.max(S[i - 1] + nums[i], nums[i]);
        }
        int ret = S[0];
        for (int i = 1; i < nums.length; i++) {
            if (S[i] > ret)
                ret = S[i];
        }
        return ret;
    }
}
