import DataStructure.TreeNode;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ServiceLoader;

public class test {
    public static void main(String[] args) {
        for (Method method : t.getClass().getMethods()) {
            System.out.println(method.getParameterTypes().length);
        }
    }

    private static test t = new test();

    public String setS(String s, String s2, int i) {
        return s;
    }
}
