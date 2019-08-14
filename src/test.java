import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        System.out.println(t.fibonacci(10));
    }

    public static test t = new test();

    public int fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int f0 = 0;
        int f1 = 1;
        int fn = 0;
        while (n > 1) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
            n--;
        }
        return fn;
    }
}
