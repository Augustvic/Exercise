package Leetcode.String;

public class P43 {

    public static void main(String[] args) {
        String num1 = "101";
        String num2 = "11";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int m = num1.length();
        int n = num2.length();
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = n - 1; j >= 0; j--) {
                int baseIndex = (m - 1 - i) + (n - 1 - j);
                int baseValue = sb.length() < baseIndex + 1 ? 0 : char2Int(sb.charAt(baseIndex));
                int sum = char2Int(num1.charAt(i)) * char2Int(num2.charAt(j)) + carry + baseValue;
                carry = sum / 10;
                if (sb.length() >= baseIndex + 1) {
                    sb.setCharAt(baseIndex, int2Char(sum % 10));
                } else {
                    sb.append(int2Char(sum % 10));
                }
            }
            if (carry != 0) {
                sb.append(int2Char(carry));
            }
        }
        return sb.reverse().toString();
    }

    public static int char2Int(char c) {
        return c - '0';
    }

    public static char int2Char(int k) {
        return (char)(k + '0');
    }
}
