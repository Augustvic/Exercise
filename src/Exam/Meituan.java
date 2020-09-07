package Exam;
//1
//
//
import java.util.*;

public class Meituan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> ret = help(n);
        System.out.println(ret.size());
        for (int[] arr : ret) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    private static List<int[]> help(int n) {
        List<int[]> ret = new ArrayList<>();
        if (n <= 0) {
            return ret;
        }
        for (int i = 1; i <= n / 4; i++) {
            String s1 = String.valueOf(i);
            String s2 = String.valueOf(i * 4);
            if (isMatch(s1, s2)) {
                int[] arr = {i, i * 4};
                ret.add(arr);
            }
        }
        return ret;
    }

    private static boolean isMatch(String s1, String s2) {
        while (s2.length() > 0 && s2.charAt(0) == '0') {
            s2 = s2.substring(1);
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int p1 = 0;
        int p2 = len - 1;
        while (p1 < len) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}


// 2
//
//
//import java.util.*;
//
//public class Meituan {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine());
//        int count = 0;
////        String start = "";
//        String end = "";
//        for (int i = 0; i < n; i++) {
//            String[] strs = scanner.nextLine().split("\\s+");
//            if (strs[0].equals(end)) {
//                end = strs[1];
//            } else {
//                count++;
////                start = strs[0];
//                end = strs[1];
//            }
//        }
//        System.out.println(count);
//    }
//}

// 3
//
//
//import java.util.*;
//
//public class Meituan {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        TreeMap<Integer, HashSet<Integer>> hm = new TreeMap<>();
//        for (int i = 0; i < m; i++) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            if (hm.containsKey(a)) {
//                HashSet<Integer> set = hm.get(a);
//                set.add(b);
//            } else {
//                HashSet<Integer> set = new HashSet<>();
//                set.add(b);
//                hm.put(a, set);
//            }
//            if (hm.containsKey(b)) {
//                HashSet<Integer> set = hm.get(b);
//                set.add(a);
//            } else {
//                HashSet<Integer> set = new HashSet<>();
//                set.add(a);
//                hm.put(b, set);
//            }
//        }
//        TreeMap<Integer, TreeSet<Integer>> ret = help(hm);
//        System.out.println(ret.size());
//        for (TreeSet<Integer> set : ret.values()) {
//            for (int k : set) {
//                System.out.print(k + " ");
//            }
//        }
//    }
//
//    public static TreeMap<Integer, TreeSet<Integer>> help(TreeMap<Integer, HashSet<Integer>> hm) {
//        TreeMap<Integer, TreeSet<Integer>> ret = new TreeMap<>();
//        while (!hm.isEmpty()) {
//            Map.Entry<Integer, HashSet<Integer>> entry = hm.firstEntry();
//            int key = entry.getKey();
//            HashSet<Integer> set = entry.getValue();
//
//            TreeSet<Integer> thisValue = new TreeSet<>();
//            thisValue.add(key);
//            TreeSet<Integer> temp = new TreeSet<>(set);
//
//            while (!temp.isEmpty()) {
//                int t = temp.first();
//                thisValue.add(t);
//                if (hm.containsKey(t)) {
//                    temp.addAll(hm.get(t));
//                    hm.remove(t);
//                }
//                temp.remove(t);
//            }
//
//            int min = thisValue.first();
//            ret.put(min, thisValue);
//        }
//        return ret;
//    }
//}
