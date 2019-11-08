import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        String s = "2552551113";
        List<String> l = t.restoreIpAddresses(s);
        System.out.println();
    }

    public static test t = new test();

    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        restoreHelp(s, new StringBuilder(), ret, 0);
        return ret;
    }

    private void restoreHelp(String s, StringBuilder sb, List<String> ret, int cnt) {
        if (s.length() == 0 || cnt == 4) {
            if (s.length() == 0 &&cnt == 4) {
                ret.add(sb.toString().substring(0, sb.length() - 1));
            }
            return;
        }
        for (int i = 0; i < s.length() && i < 3; i++) {
            String st = s.substring(0, i + 1);
            int it = Integer.valueOf(st);
            if (it >= 0 && it <= 255) {
                int len = st.length() + 1;
                sb.append(st + '.');
                restoreHelp(s.substring(i + 1), sb, ret, cnt + 1);
                sb.delete(sb.length() - len, sb.length());
            }
        }
    }
}
