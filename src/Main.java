import DataStructure.BinaryTree;
import DataStructure.BinaryTreeNode;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        for (int i = m; i >= 0; i--) {
            int carry = 0;
            for (int j = n; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int pos = m - i + n - j;
                int c = pos >= sb.length() ? 0 : sb.charAt(pos) - '0';
                int sum = a * b + c + carry;
                if (pos >= sb.length()) {
                    sb.append((char)(sum % 10 + '0'));
                } else {
                    sb.setCharAt(pos, (char)(sum % 10 + '0'));
                }
                carry = sum / 10;
            }
            if (carry != 0) {
                sb.append((char)(carry + '0'));
            }
        }
        return sb.reverse().toString();
    }
}
