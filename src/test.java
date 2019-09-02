import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        String s = "aabc";
        t.permutation(s);
    }

    public static test t = new test();

    public void permutation(String s) {
        if (s == null || s.length() == 0)
            return;
        Set<String> set = new HashSet<>();
        permutationHelp(set, s, "");
        for (String st : set)
            System.out.println(st);
    }

    private void permutationHelp(Set<String> set, String s, String st) {
        if (s.length() == 0) {
            set.add(st);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String stNew = new String(st);
            StringBuilder sb = new StringBuilder(s);
            stNew += sb.charAt(i);
            sb.delete(i, i + 1);
            permutationHelp(set, sb.toString(), stNew);
        }
    }
}
