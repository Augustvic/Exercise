package Leetcode.HashTable;

public class P12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        intToRoman(sb, num);
        return sb.toString();
    }

    public static void intToRoman(StringBuilder sb, int num) {
        if (num >= 1000) {
            sb.append("M");
            intToRoman(sb, num - 1000);
        } else if (num >= 900) {
            sb.append("CM");
            intToRoman(sb, num - 900);
        } else if (num >= 500) {
            sb.append("D");
            intToRoman(sb, num - 500);
        } else if (num >= 400) {
            sb.append("CD");
            intToRoman(sb, num - 400);
        } else if (num >= 100) {
            sb.append("C");
            intToRoman(sb, num - 100);
        } else if (num >= 90) {
            sb.append("XC");
            intToRoman(sb, num - 90);
        } else if (num >= 50) {
            sb.append("L");
            intToRoman(sb, num - 50);
        } else if (num >= 40) {
            sb.append("XL");
            intToRoman(sb, num - 40);
        } else if (num >= 10) {
            sb.append("X");
            intToRoman(sb, num - 10);
        } else if (num == 9) {
            sb.append("IX");
            intToRoman(sb, 0);
        } else if (num >= 5) {
            sb.append("V");
            intToRoman(sb, num - 5);
        } else if (num == 4) {
            sb.append("IV");
            intToRoman(sb, 0);
        } else if (num > 0) {
            sb.append("I");
            intToRoman(sb, num - 1);
        }
    }
}
