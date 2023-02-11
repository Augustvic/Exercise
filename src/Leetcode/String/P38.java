package Leetcode.String;

public class P38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int k = 2; k <= n; k++) {
            StringBuilder currSb = new StringBuilder();
            int index = 0;
            while (index < sb.length()) {
                int end = index + 1;
                while (end < sb.length() && sb.charAt(index) == sb.charAt(end)) {
                    end++;
                }
                currSb.append(end - index);
                currSb.append(sb.charAt(index));
                index = end;
            }
            sb = currSb;

        }
        return sb.toString();
    }
}
