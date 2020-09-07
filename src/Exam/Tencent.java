package Exam;
// 1
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Tencent {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        ArrayList<Integer> list = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            list.add(scanner.nextInt());
//        }
//        list.remove(k - 1);
//        for (int val : list) {
//            System.out.print(val+ " ");
//        }
//    }
//}


// 2
//
//import java.util.*;
//
//public class Exam.Tencent {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int k = scanner.nextInt();
//        TreeMap<Character, LinkedList<Integer>> map = new TreeMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (!map.containsKey(c)) {
//                map.put(c, new LinkedList<>());
//            }
//            LinkedList<Integer> list = map.get(c);
//            list.add(i);
//        }
//        Comparator<String> comparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        };
//        TreeSet<String> ret = new TreeSet<>(comparator);
////        for (LinkedList<Integer> list : map.values()) {
////            for (int pos : list) {
////                for (int i = pos + 1; i <= s.length(); i++) {
////                    String t = s.substring(pos, i);
////                    ret.add(t);
////                }
////            }
////            if (ret.size() >= k) {
////                int i = 0;
////                for (String temp : ret) {
////                    i++;
////                    if (i == k) {
////                        System.out.print(temp);
////                    }
////                }
////                break;
////            }
////        }
//
//        for (Map.Entry entry : map.entrySet()) {
//            char c = (char) entry.getKey();
//            LinkedList<Integer> list = (LinkedList)entry.getValue();
//            ret.add(String.valueOf(c));
//            int currPos = -1;
//            int nextPos = -1;
//            char nextMin = (char)('z' + 1);
//            for (int pos : list) {
//                if (pos < s.length() - 1) {
//                    if (s.charAt(pos + 1) < nextMin) {
//                        currPos = pos;
//                        nextPos = pos + 1;
//                        nextMin = s.charAt(pos + 1);
//                    }
//                }
//            }
//            if (nextPos != -1) {
//                for (int i = nextPos + 1; i <= s.length(); i++) {
//                    ret.add(s.substring(currPos, i));
//                }
//            }
//            if (ret.size() >= k) {
//                int i = 0;
//                for (String temp : ret) {
//                    i++;
//                    if (i == k) {
//                        System.out.print(temp);
//                    }
//                }
//                break;
//            }
//            for (int pos : list) {
//                for (int i = pos + 1; i <= s.length(); i++) {
//                    String t = s.substring(pos, i);
//                    ret.add(t);
//                }
//            }
//            if (ret.size() >= k) {
//                int i = 0;
//                for (String temp : ret) {
//                    i++;
//                    if (i == k) {
//                        System.out.print(temp);
//                    }
//                }
//                break;
//            }
//        }
//    }
//}

// 3
//
//import java.util.*;
//
//public class Exam.Tencent {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i++) {
//            long n = scanner.nextLong();
//            int max = 0;
//            for (long num = n / 2L; num >= 0; num--) {
//                max = Math.max(max, numOfDigits(num) + numOfDigits(n - num));
//            }
//            System.out.println(max);
//        }
//    }
//
//    private static int numOfDigits(long num) {
//        int count = 0;
//        while (num != 0L) {
//            count += num % 10L;
//            num = num / 10L;
//        }
//        return count;
//    }
//}


// 5
//
import java.util.*;

public class Tencent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(cut(s.substring(l - 1, r)) + 1);
        }
    }

    private static int cut(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            dp[i] = rule(s.substring(0, i + 1)) ? 0 : i;
            for (int j = i; j >= 1; j--) {
                if (rule(s.substring(j, i + 1))) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }

    private static boolean rule(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}