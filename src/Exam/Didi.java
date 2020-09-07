package Exam;
// 1.
//

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Didi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> ret = new TreeMap<>();
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (a == b || a == c || b == c) {
                        continue;
                    }
                    int x = a * 100 + b * 10 + c;
                    int y = a * 100 + c * 10 + c;
                    if (rule(x, y, n)) {
                        ret.put(x, y);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(ret.size());
            for (Map.Entry entry : ret.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static boolean rule(int x, int y, int n) {
        return x + y == n;
    }
}

// 2.
//
//import java.util.*;
//
//public class Exam.Tencent {
//
//    private static long a = 0;
//    private static long b = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        long[][] matrix = new long[n][n];
//        boolean flag = (n & 1) == 1;
//        a = 0;
//        b = 0;
//        if (flag) {
//            matrix[n / 2][n / 2] = 1;
//        }
//        int index = n / 2 - 1;
//        while (index >= 0) {
//            circle(matrix, index, n, flag);
//            index--;
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void circle(long[][] matrix, int index, int n, boolean flag) {
//        int start = index;
//        int end = n - 1 - index;
//        for (int i = start + 1; i <= end; i++) {
//            matrix[i][start] = next(flag);
//        }
//        for (int j = start + 1; j <= end; j++) {
//            matrix[end][j] = next(flag);
//        }
//        for (int i = end - 1; i >= start; i--) {
//            matrix[i][end] = next(flag);
//        }
//        for (int j = end - 1; j >= start; j--) {
//            matrix[start][j] = next(flag);
//        }
//    }
//
//    private static long next(boolean flag) {
//        if (a == 0 && b == 0) {
//            if (flag) {
//                a = 1;
//                b = 1;
//            } else {
//                a = 0;
//                b = 1;
//            }
//            return 1;
//        }
//        long t = a + b;
//        a = b;
//        b = t;
//        return t;
//    }
//}