import java.util.*;

public class Main {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String s1 = reverse(num1);
        String s2 = reverse(num2);
        int[] ret = new int[s1.length() + s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            int carry = 0;
            for (int j = 0; j < s2.length(); j++) {
                int pos = i + j;
                int a = s1.charAt(i) - '0';
                int b = s2.charAt(j) - '0';
                int sum = ret[pos] + a * b + carry;
                ret[pos] = sum % 10;
                carry = sum / 10;
            }
            if (carry != 0) {
                ret[i + s2.length()] = carry;
            }
        }
        return reverse(ret);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String reverse(int[] arr) {
        int end = arr.length - 1;
        while (end >= 0 && arr[end] == 0) {
            end--;
        }
        int l = 0, r = end;
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= end; i++) {
            sb.append((char)(arr[i] + '0'));
        }
        return sb.toString();
    }
}