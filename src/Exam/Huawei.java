package Exam;// 1.
//
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Huawei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String str = "";
        int A = 0;
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.length() == 1) {
                A = Integer.valueOf(s);
                str = scanner.nextLine();
                break;
            }
            list.add(s);
        }
        String strSub = getSub(str, A);
        for (String s : list) {
            String st = getSub(s, A);
            if (strSub.length() == 0 || isSub(strSub, st)) {
                System.out.println(s);
            }
        }
    }

    public static String getSub(String s, int A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            if (val < A) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static boolean isSub(String sub, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (sub.charAt(0) == str.charAt(i)) {
                int p1 = 0;
                int p2 = i;
                while (p1 < sub.length() && p2 < str.length() && sub.charAt(p1) == str.charAt(p2)) {
                    p1++;
                    p2++;
                }
                if (p1 == sub.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 2.
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Exam.Huawei {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        ArrayList<String> l1 = new ArrayList<>();
//        ArrayList<String> l2 = new ArrayList<>();
//        ArrayList<String> curr = l1;
//        int i = 0;
//        while (str.length() != 0) {
//            char c = i < str.length() ? str.charAt(i) : ' ';
//            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
//                if (c >= 'A' && c <= 'Z') {
//                    StringBuilder sb = new StringBuilder(str);
//                    sb.setCharAt(i, Character.toLowerCase(c));
//                    str = sb.toString();
//                }
//                i++;
//            } else if (c == ' ') {
//                if (i == 0) {
//                    str = str.trim();
//                } else {
//                    curr.add(str.substring(0, i));
//                    if (i >= str.length()) {
//                        str = "";
//                    } else {
//                        str = str.substring(i + 1);
//                        i = 0;
//                    }
//                }
//            } else if (c == '.' || c == ',' || c == '!' || c == '?') {
//                String t = (c == '?') ? "?" : ".";
//                if (i == 0) {
//                    curr.add(t);
//                    str = str.substring(1);
//                    i = 0;
//                } else {
//                    curr.add(str.substring(0, i));
//                    curr.add(t);
//                    str = str.substring(i + 1);
//                    i = 0;
//                }
//            } else if (c == ';') {
//                if (i == 0) {
//                    str = str.substring(1);
//                    curr = l2;
//                    i = 0;
//                } else {
//                    curr.add(str.substring(0, i));
//                    str = str.substring(i + 1);
//                    curr = l2;
//                    i = 0;
//                }
//            }
//        }
////        System.out.println(l1.toString());
////        System.out.println(l2.toString());
//
//        System.out.print("(" + calculate(l1, l2) + ",");
//        System.out.print(l2.size() + ")");
//    }
//
//
//    public static int calculate(ArrayList<String> l1, ArrayList<String> l2) {
//        int[][] dp = new int[l1.size() + 1][l2.size() + 1];
//        for (int i = 0; i <= l1.size(); i++) {
//            dp[i][0] = i;
//        }
//        for (int j = 0; j <= l2.size(); j++) {
//            dp[0][j] = j;
//        }
//        for (int i = 1; i <= l1.size(); i++) {
//            for (int j = 1; j <= l2.size(); j++) {
//                int a = (l1.get(i - 1).equals(l2.get(j - 1))) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 2;
//                int b = dp[i - 1][j] + 1;
//                int c = dp[i][j - 1] + 1;
//                dp[i][j] = Math.min(a, Math.min(b, c));
//            }
//        }
//        return dp[l1.size()][l2.size()];
//    }
//}
