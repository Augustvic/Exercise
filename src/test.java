import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int k = 1500;
        System.out.println(t.getUglyNumber(k));
    }

    public static test t = new test();

    public int getUglyNumber(int k) {
        if (k <= 0)
            return 0;
        int[] ret = new int[k];
        ret[0] = 1;
        int nextIndex = 1;
        int currIndex2 = 0;
        int currIndex3 = 0;
        int currIndex5 = 0;
        while (nextIndex < k) {
            ret[nextIndex] = minOfThree(ret[currIndex2] * 2, ret[currIndex3] * 3, ret[currIndex5] * 5);
            while (ret[currIndex2] * 2 <= ret[nextIndex]) currIndex2++;
            while (ret[currIndex3] * 3 <= ret[nextIndex]) currIndex3++;
            while (ret[currIndex5] * 5 <= ret[nextIndex]) currIndex5++;
            nextIndex++;
        }
        return ret[k - 1];
    }

    private int minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
