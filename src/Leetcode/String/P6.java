package Leetcode.String;

public class P6 {

    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows == 1) {
            return s;
        }
        StringBuilder[] sbArr = new StringBuilder[numRows];
        boolean down = false;
        int index = 0;
        for (char c : s.toCharArray()) {
            if (sbArr[index] == null) {
                sbArr[index] = new StringBuilder();
            }
            sbArr[index].append(c);
            if (index == 0 || index == numRows - 1) {
                down = !down;
            }
            index += down ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            if (sb != null) {
                ret.append(sb);
            }
        }
        return ret.toString();
    }
}
