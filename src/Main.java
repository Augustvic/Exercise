import java.util.*;

public class Main {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder newSb = new StringBuilder();
            for (int m = 0, k; m < sb.length(); m = k) {
                k = m + 1;
                while (k < sb.length() && sb.charAt(k) == sb.charAt(m)) {
                    k++;
                }
                newSb.append(k - m);
                newSb.append(sb.charAt(m));
            }
            sb = newSb;
        }
        return sb.toString();
    }
}