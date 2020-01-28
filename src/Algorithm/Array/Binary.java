package Array;

import java.util.LinkedList;
import java.util.List;

public class Binary {
    public static void main(String[] args) {
        int n = 2;
        List<Integer> res = grayCode(n);
        for(int k : res)
            System.out.print(k + " ");
    }

    public static List<Integer> grayCode(int n) {
        List<String> res = new LinkedList<>();
        List<Integer> res_int = new LinkedList<>();
        if(n == 0) {
            res_int.add(0);
            return res_int;
        }
        if(n == 1) {
            res_int.add(0);
            res_int.add(1);
            return res_int;
        }

        int pos = 0;
        String s1 = "0";
        recurse(res, s1, pos + 1, n);
        String s2 = "1";
        recurse(res, s2, pos + 1, n);

        for(String s : res) {
            res_int.add(binaryToInt(s));
        }
        return res_int;
    }

    public static void recurse(List<String> res, String s, int pos, int n) {
        if(pos == n) {
            res.add(s);
            return;
        }
        String s1 = s + "0";
        recurse(res, s1, pos + 1, n);
        String s2 = s + "1";
        recurse(res, s2, pos + 1, n);
    }

    public static int binaryToInt(String s) {
        int k = 0;
        for(int i = 0; i < s.length(); i++)
            k += s.charAt(i) == '0' ? 0 : Math.pow(2, s.length() - 1 - i);
        return k;
    }
}
