import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        Iterator<Integer> it = l.iterator();
        it.next();
        it.remove();
        System.out.println(l.toString());
    }

    public static test t = new test();

    public String replace(String s) {
        if (StringUtil.isEmpty(s))
            return s;
        int numOfBlank = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                numOfBlank++;
        }
        StringBuilder sb = new StringBuilder();
        sb.setLength(s.length() + 2 * numOfBlank);
        int p = s.length() - 1;
        int q = sb.length() - 1;
        while (p >= 0 && q >= 0) {
            if (s.charAt(p) == ' ') {
                sb.replace(q - 2, q + 1, "%20");
                p = p - 1;
                q = q - 3;
            }
            else {
                sb.setCharAt(q, s.charAt(p));
                p = p - 1;
                q = q - 1;
            }
        }
        return sb.toString();
    }
}
