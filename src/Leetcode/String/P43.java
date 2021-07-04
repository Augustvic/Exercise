package Leetcode.String;

public class P43 {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = m; i >= 0; i--) {
            int carry = 0;
            for (int j = n; j >= 0; j--) {
                int a = charToInt(num1.charAt(i));
                int b = charToInt(num2.charAt(j));
                int pos = m - i + n - j;
                int c = pos >= sb.length() ? 0 : charToInt(sb.charAt(pos));
                int sum = a * b + c + carry;
                carry = sum / 10;
                char base = intToChar(sum % 10);
                if (pos >= sb.length()) {
                    sb.append(base);
                } else {
                    sb.setCharAt(pos, base);
                }
            }
            if (carry != 0) {
                sb.append(intToChar(carry));
            }
        }
        return sb.reverse().toString();
    }

    public static int charToInt(char c) {
        return c - '0';
    }

    public static char intToChar(int k) {
        return (char)(k + '0');
    }
}
