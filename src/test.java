import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class test {
    public static void main(String[] args) {
        t.print(4);
    }

    public static test t = new test();

    public void print(int n) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(n);
        printHelp(sb, 0);
    }

    private void printHelp(StringBuilder sb, int pos) {
        if (pos == sb.length()) {
            printInteger(sb.toString());
            return;
        }
        for (int i = 0; i <= 9; i++) {
            sb.setCharAt(pos, (char)(i + '0'));
            printHelp(sb, pos + 1);
        }
    }

    private void printInteger(String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == '0')
            start++;
        if (start < s.length())
            System.out.println(s.substring(start));
    }

}
