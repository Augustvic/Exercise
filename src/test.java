import DataStructure.BinaryTreeNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        String s1 = "+100";
        String s2 = "5e2";
        String s3 = "-123";
        String s4 = "3.14159";
        String s5 = "12e";
        String s6 = "1a3.14";
        String s7 = "1.2.3";
        String s8 = "12e+5.4";
        String s9 = "12e+";
        String s10 = "+.e";
        String s11 = ".12e+10";
        String s12 = "5.e+10";
        System.out.println(t.isNumeric(s1));
        System.out.println(t.isNumeric(s2));
        System.out.println(t.isNumeric(s3));
        System.out.println(t.isNumeric(s4));
        System.out.println(t.isNumeric(s5));
        System.out.println(t.isNumeric(s6));
        System.out.println(t.isNumeric(s7));
        System.out.println(t.isNumeric(s8));
        System.out.println(t.isNumeric(s9));
        System.out.println(t.isNumeric(s10));
        System.out.println(t.isNumeric(s11));
        System.out.println(t.isNumeric(s12));
    }

    public static test t = new test();

    private int pos = 0;

    public boolean isNumeric(String s) {
        pos = 0;
        if (s == null || s.length() == 0)
            return false;
        // scanInteger 有返回值是为了检测小数点前后必须至少有一个整数
        boolean res = scanInteger(s);
        if (pos < s.length() && s.charAt(pos) == '.') {
            pos++;
            res = scanUnsignedInteger(s) || res;
        }
        if (pos < s.length() && (s.charAt(pos) == 'e' || s.charAt(pos) == 'E')) {
            pos++;
            res = res && scanInteger(s);
        }
        return res && (pos == s.length());
    }

    public boolean scanInteger(String s) {
        if (pos < s.length() && (s.charAt(pos) == '+' || s.charAt(pos) == '-'))
            pos++;
        return scanUnsignedInteger(s);
    }

    public boolean scanUnsignedInteger(String s) {
        int start = pos;
        while (pos < s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9') {
            pos++;
        }
        return pos > start;
    }
}
