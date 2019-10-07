import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        System.out.println(t.fibr(6));
    }

    public static test t = new test();

    public int fibr(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(1);
        while (n-- > 2) {
            int a = S.pop();
            int b = a + S.peek();
            S.push(a);
            S.push(b);
        }
        return S.peek();
    }
}
