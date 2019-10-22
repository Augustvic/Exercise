import DataStructure.*;
import Tools.*;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
//        t.printOneToMaxOfNDigits(3);
        System.out.println(t.add("123", "456"));
        System.out.println(t.add("123", "0"));
        System.out.println(t.add("123", "1234"));
        System.out.println(t.add("0", "0"));
    }

    public static test t = new test();

    public void printOneToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        StringBuilder sb = new StringBuilder();
        sb.setLength(n);
        printHelp(n, 0, sb);
    }

    private void printHelp(int n, int pos, StringBuilder sb) {
        if (n == pos) {
            printString(sb.toString());
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.setCharAt(pos, (char)(i + '0'));
            printHelp(n, pos + 1, sb);
        }
    }

    private void printString(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == '0') start++;
        System.out.print(s.substring(start));
        System.out.println();
    }

    public String add(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);
        reverse(sb1);
        reverse(sb2);
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int pos = 0;
        while (pos < sb1.length() && pos < sb2.length()) {
            int a = sb1.charAt(pos) - '0';
            int b = sb2.charAt(pos) - '0';
            sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            ret.append((char)(sum + '0'));
            pos++;
        }
        if (pos < sb1.length())
            ret.append(sb1.substring(pos));
        if (pos < sb2.length())
            ret.append(sb2.substring(pos));
        if (carry != 0)
            ret.append((char)(carry + '0'));
        reverse(ret);
        return ret.toString();
    }

    private void reverse(StringBuilder sb) {
        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {
            char c = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, c);
            l++;
            r--;
        }
    }

}
