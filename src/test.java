import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        t.pushBack(1);
        t.pushBack(6);
        t.pushBack(3);
        t.pushBack(2);
        t.pushBack(7);
        t.pushBack(5);
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
        System.out.println(t.popFront());
        System.out.println(t.max());
    }

    public static test t = new test();

    private Deque<InternalData> maxDq;
    private Deque<InternalData> dataDq;
    private int currIndex;

    public test() {
        maxDq = new ArrayDeque<>();
        dataDq = new ArrayDeque<>();
        currIndex = 0;
    }

    public void pushBack(int k) {
        InternalData d = new InternalData(k, currIndex++);
        dataDq.addLast(d);
        while (!maxDq.isEmpty() && k > maxDq.getLast().val) {
            maxDq.removeLast();
        }
        maxDq.addLast(d);
    }

    public int max() {
        if (dataDq.isEmpty())
            return -1;
        return maxDq.getFirst().val;
    }

    public int popFront() {
        if (dataDq.isEmpty())
            return -1;
        if (dataDq.getFirst().index == maxDq.getFirst().index) {
            maxDq.removeFirst();
        }
        return dataDq.removeFirst().val;
    }
}
