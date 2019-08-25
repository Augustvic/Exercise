import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        t.push(3);
        t.push(4);
        t.push(2);
        t.push(1);
        System.out.println("MIN:" + t.min());
        System.out.println("POP:" + t.pop());
        System.out.println("POP:" + t.pop());
        System.out.println("MIN:" + t.min());
        System.out.println("POP:" + t.pop());
        System.out.println("POP:" + t.pop());
        System.out.println("POP:" + t.pop());
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
