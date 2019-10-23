import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        System.out.println(t.isNumeric("123.45e+6"));
    }

    public static test t = new test();

    private int pos = 0;

    public boolean isNumeric(String s) {
        pos = 0;
        if (s == null || s.length() == 0)
            return false;
        boolean ret = scanInteger(s);
        if (pos < s.length() && s.charAt(pos) == '.') {
            pos++;
            ret = scanUnsignedInteger(s) || ret;
        }
        if (pos < s.length() && (s.charAt(pos) == 'e' || s.charAt(pos) == 'E')) {
            pos++;
            ret = ret && scanInteger(s);
        }
        return ret && (pos == s.length());
    }

    private boolean scanInteger(String s) {
        if (pos < s.length() && (s.charAt(pos) == '+' || s.charAt(pos) == '-'))
            pos++;
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int start = pos;
        while (pos < s.length() && s.charAt(pos) >= '0' && s.charAt(pos) <= '9')
            pos++;
        return pos > start;
    }

}
