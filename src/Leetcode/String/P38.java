package Leetcode.String;

public class P38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        StringBuilder[] sb = new StringBuilder[2];
        int index = 1;
        sb[0] = new StringBuilder("1");
        for (int k = 2; k <= n; k++) {
            int lastLen = sb[1 - index].length();
            StringBuilder lastSb =  sb[1 - index];
            StringBuilder currSb = new StringBuilder();
            for (int i = 0, j; i < lastLen; i = j) {
                j = i + 1;
                while (j < lastLen && lastSb.charAt(j) == lastSb.charAt(i)) {
                    j++;
                }
                currSb.append(j - i);
                currSb.append(lastSb.charAt(i));
            }
            sb[index] = currSb;
            index = 1 - index;
        }
        return sb[1-index].toString();
    }
}
