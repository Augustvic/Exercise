import DataStructure.*;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> l = Arrays.asList("ale","apple","monkey","plea");
        System.out.println(t.findLongestWord(s, l));
    }

    public static test t = new test();

    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String tmp : d) {
            if (tmp.length() < res.length() || res.compareTo(tmp) < 0)
                continue;
            if (isValid(s, tmp))
                res = tmp;
        }
        return res;
    }

    private boolean isValid(String s, String tmp) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < tmp.length()) {
            if (s.charAt(i) == tmp.charAt(j))
                j++;
            i++;
        }
        return j == tmp.length();
    }
}
