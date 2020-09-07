package Exam;// 1.
//
//
//import java.util.Scanner;
//
//public class Exam.Pdd {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        if (n <= 3 || n >= 200) {
//            return;
//        }
//        int h = n / 2;
//        if ((n & 1) == 1) {
//            // 奇数
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (i == j || i == n - 1 - j || i == h || j == h) {
//                        System.out.print(0);
//                    } else if (i < h && j > h && i < n - 1 - j) {
//                        System.out.print(1);
//                    } else if (i < h && j < h && i < j) {
//                        System.out.print(2);
//                    } else if (i < h && j < h && i > j) {
//                        System.out.print(3);
//                    } else if (i > h && j < h && i < n - 1 - j) {
//                        System.out.print(4);
//                    } else if (i > h && j < h && i > n - 1 - j) {
//                        System.out.print(5);
//                    } else if (i > h && j > h && i < j) {
//                        System.out.print(6);
//                    } else if (i > h && j > h && i > j) {
//                        System.out.print(7);
//                    }  else if (i < h && j > h && i > n - 1 - j) {
//                        System.out.print(8);
//                    }
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//        } else {
//            // 偶数
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (i == j || i == n - 1 - j) {
//                        System.out.print(0);
//                    } else if (i < h && j >= h && i < n - 1 - j) {
//                        System.out.print(1);
//                    } else if (i < h && j < h && i < j) {
//                        System.out.print(2);
//                    } else if (i < h && j < h && i > j) {
//                        System.out.print(3);
//                    } else if (i >= h && j < h && i < n - 1 - j) {
//                        System.out.print(4);
//                    } else if (i >= h && j < h && i > n - 1 - j) {
//                        System.out.print(5);
//                    } else if (i >= h && j >= h && i > j) {
//                        System.out.print(6);
//                    } else if (i >= h && j >= h && i < j) {
//                        System.out.print(7);
//                    }  else if (i < h && j >= h && i > n - 1 - j) {
//                        System.out.print(8);
//                    }
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }
//        }
//    }
//}


//4.
//
//
//import java.util.HashSet;
//import java.util.Scanner;
//
//public class Exam.Pdd {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        HashSet<Integer> hs = new HashSet<>();
//        for (int i = 0; i < M; i++) {
//            int y = scanner.nextInt();
//            for (int k = 1; k < Integer.MAX_VALUE; k++) {
//                int ret = k * y;
//                if (ret > N || ret < 0) {
//                    break;
//                }
//                hs.add(ret);
//            }
//        }
//        System.out.println(hs.size());
//    }
//}


//2.
//
//
import java.util.Scanner;

public class Pdd {

    public static final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean[][] matrix = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (scanner.nextInt() == 1);
            }
        }
        int ret = max(matrix, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]) {
                    matrix[i][j] = false;
                    ret = Math.max(traverse(matrix, i, j, m, n), ret);
                    matrix[i][j] = true;
                }
            }
        }
        System.out.println(ret);
    }

    public static int traverse(boolean[][] matrix, int i, int j, int m, int n) {
        int ret = 0;
        for (int p = 0; p < m; p++) {
            for (int q = 0; q < n; q++) {
                if (!(p == i && q == j) && !matrix[p][q]) {
                    matrix[p][q] = true;
                    ret = Math.max(help(matrix, new boolean[m][n], m, n, p, q), ret);
                    matrix[p][q] = false;
                }
            }
        }
        return ret;
    }

    public static int max(boolean[][] matrix, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j]) {
                    ret = Math.max(ret, help(matrix, visited, m, n, i, j));
                }
            }
        }
        return ret;
    }

    public static int help(boolean[][] matrix, boolean[][] visited, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !matrix[i][j]) {
            return 0;
        }
        int count = 1;
        visited[i][j] = true;
        for (int[] pos : direction) {
            int nextI = i + pos[0];
            int nextJ = j + pos[1];
            count += help(matrix, visited, m, n, nextI, nextJ);
        }
        return count;
    }
}

