import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int i = 2;
        Comparable<Integer> key = (Comparable<Integer>) i;
        int j = 1;
        System.out.println(key.compareTo(j));
    }

    public static test t = new test();

    private Stack<Integer> dataSt;
    private Stack<Integer> minSt;

    public test() {
        dataSt = new Stack<>();
        minSt = new Stack<>();
    }

    public int min() {
        if (!minSt.isEmpty())
            return minSt.peek();
        else
            throw new NullPointerException();
    }

    public void push(int val) {
        dataSt.push(val);
        if (minSt.isEmpty() || val < minSt.peek())
            minSt.push(val);
        else
            minSt.push(minSt.peek());
    }

    public int pop() {
        if (!dataSt.isEmpty()) {
            minSt.pop();
            return dataSt.pop();
        }
        else
            throw new NullPointerException();
    }
}
