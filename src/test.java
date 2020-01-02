import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class test {
    public static void main(String[] args) {
        System.out.println(t.isNumeric("123.45e+6"));
    }

    public static test t = new test();

    private int pos = 0;

    public boolean isNumeric(String s) {
        pos = 0;
        boolean res = scanInteger(s);
        if (pos < s.length() && s.charAt(pos) == '.') {
            pos++;
            res = scanUnsignedInteger(s) || res;
        }
        if (pos < s.length() && (s.charAt(pos) == 'E' || s.charAt(pos) == 'e')) {
            pos++;
            res = res && scanInteger(s);
        }
        return res && (pos == s.length());
    }

    private boolean scanInteger(String s) {
        if (pos < s.length() && (s.charAt(pos) == '+' || s.charAt(pos) == '-'))
            pos++;
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int start = pos;
        while (pos < s.length() && s.charAt(pos) <= '9' && s.charAt(pos) >= '0')
            pos++;
        return pos > start;
    }

}
