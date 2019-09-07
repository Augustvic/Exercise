import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int num1 = 12258;
        int num2 = 12268;
        int num3 = 8;
        System.out.println(t.translate(num1));
        System.out.println(t.translate(num2));
        System.out.println(t.translate(num3));
    }

    public static test t = new test();

    public int translate(int num) {
        if (num < 0)
            return 0;
        if (num < 10)
            return 1;
        String s = String.valueOf(num);
        int len = s.length();
        int[] nums = new int[len];
        nums[len - 1] = 1;
        int ten = s.charAt(len - 2) - '0';
        int ones = s.charAt(len - 1) - '0';
        int t = ten * 10 + ones;
        nums[len - 2] = (t >= 10 && t <= 25) ? 2 : 1;
        for (int i = len - 3; i >= 0; i--) {
            ten = s.charAt(i) - '0';
            ones = s.charAt(i +1) - '0';
            t = ten * 10 + ones;
            nums[i] = (t >= 10 && t <= 25) ? nums[i + 1] + nums[i + 2] : nums[i + 1];
        }
        return nums[0];
    }
}
