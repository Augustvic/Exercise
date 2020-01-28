package Other;

/**
 * Created by August on 2019/5/5 19:36
 **/

public class KMP {

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(kmp(s, p));
    }

    public static int kmp(String s, String p) {
        if (s == null || p == null)
            return -1;
        int[] next = new int[p.length()];
        buildNext(next, p);
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            while (i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            if (j == p.length())
                return i - p.length();
            if (j == 0) {
                i++;
            } else {
                j = next[j - 1] + 1;
            }
        }
        return -1;
    }

    public static void buildNext(int[] next, String p) {
        for (int i = 0; i < p.length(); i++)
            next[i] = -1;
        for (int i = 1; i < p.length(); i++) {
            int j = next[i - 1];
            while ((p.charAt(j + 1) != p.charAt(i)) && (j >= 0))
                j = next[j];
            if (p.charAt(j + 1) == p.charAt(i))
                next[i] = j + 1;
            else
                next[i] = -1;
        }
    }
}
