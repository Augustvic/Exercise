package Exam;

import java.util.HashSet;
import java.util.Scanner;

// 2020/8/8
//1
public class NetEase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        System.out.println(count(nums));
    }

    private static long count(long[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long count = 0;
        for (long num : nums) {
            count += getCount(num);
        }
        return count;
    }

    private static long getCount(long num) {
        if (num == 0 || num == 1) {
            return 0;
        }
        return num / 2;
    }
}


//2
//public class Exam.Exam.Meituan {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] nums= new int[m];
//        HashSet<Integer> hs = new HashSet<>();
//        for (int i = 0; i < m; i++) {
//            nums[i] = scanner.nextInt();
//            hs.add(nums[i]);
//        }
//        int[] array = null;
//        if (m != n) {
//            array = array(nums, n, hs);
//        } else {
//            array = nums;
//        }
//        for (int i = 0; i < array.length - 1; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println(array[array.length - 1]);
//    }
//
//    private static int[] array(int[] nums, int n, HashSet<Integer> hs) {
//        int[] ret = new int[n];
//        int p = 0;
//        int q = 0;
//        for (int i = 1; i <= n || q < nums.length; ) {
//            if (hs.contains(i)) {
//                i++;
//                continue;
//            }
//            if (q < nums.length && i > nums[q]) {
//                ret[p] = nums[q];
//                q++;
//                p++;
//            } else {
//                ret[p] = i;
//                i++;
//                p++;
//            }
//        }
//        return ret;
//    }
//}


// 3
//public class Exam.Meituan {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i++) {
//            int n = scanner.nextInt();
//            int[] nums = new int[n];
//            for (int j = 0; j < n; j++) {
//                nums[j] = scanner.nextInt();
//            }
//            System.out.println(gift(nums));
//        }
//    }
//
//    private static int ret;
//
//    private static int gift(int[] nums) {
//        ret = Integer.MAX_VALUE;
//        dfs(nums, 0, 0, 0, 0);
//        return ret;
//    }
//
//    private static void dfs(int[] nums, int sum1, int sum2, int index, int value) {
//        if (index >= nums.length) {
//            if (sum1 == sum2 && ret > value) {
//                ret = value;
//            }
//            return;
//        }
//        dfs(nums, sum1 + nums[index], sum2, index + 1, value);
//        dfs(nums, sum1, sum2 + nums[index], index + 1, value);
//        dfs(nums, sum1, sum2, index + 1, value + nums[index]);
//    }
//}

//public class Exam.Exam.Meituan{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        while(T > 0) {
//            T--;
//            int n = sc.nextInt();
//            int[] a = new int[n];
//            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
////Arrays.sort(a); 这行可以不要，写的时候忘记删去了
//            System.out.println(new Solution().value(n, a));
//        }
//    }
//}
//
//class Solution{
//    int[] a;
//    int n;
//    int ans = Integer.MAX_VALUE;
//    public int value(int n, int[] a) {
//        this.a = a;
//        this.n = n;
//        dfs(n - 1, 0, 0, 0);
//        return ans;
//    }
//
//    void dfs(int index, int p1, int p2, int value) {
//        if(index == -1) {
//            if(p1 == p2 && ans > value)
//                ans = value;
//            return;
//        }
//        dfs(index - 1, p1 + a[index], p2, value);
//        dfs(index - 1, p1, p2 + a[index], value);
//        dfs(index - 1, p1, p2, value + a[index]);
//    }
//}