/*
 * Design an O(n) time algorithm that, given a set S of n distinct numbers and a positive integer k(k<=n), find k
 * numbers (including the median itself) in S that are closest to the median of S. For example, if
 * S = {4, 18, 8, 2, 20, 6, 19} and k = 3, then the output should be {4, 8, 6}.
 * Hint: Use the linear-time SELECT algorithm.
 */

package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Find_k_Numbers_Closest_to_Median {

    public static void main(String[] args) {
        int[] s = {4, 18, 8, 2, 20, 6, 19};
        int k = 3;
        List<Integer> res =closestToMedian(s, k);
        for(int i : res)
            System.out.print(i + " ");
    }

    public static List<Integer> closestToMedian(int[] s, int k) {
        List<Integer> res = new LinkedList<>();
        int median = s[selectIndex(s, s.length/2 + 1)];
        int[] diff = new int[s.length];
        for(int i = 0; i < s.length; i++) {
            diff[i] = Math.abs(s[i] - median);
        }
        for(int i = 1; i <= k; i++) {
            int index = selectIndex(diff, i);
            res.add(s[index]);
        }
        return res;
    }

    public static int selectIndex(int[] s, int th) {
        int[] sTmp = new int[s.length];
        for(int i = 0; i < s.length; i++)
            sTmp[i] = s[i];
        Arrays.sort(sTmp);
        int num = sTmp[th - 1];
        int index = 0;
        for(; index < s.length; index++)
            if(num == s[index])
                break;
        return index;
    }
}
