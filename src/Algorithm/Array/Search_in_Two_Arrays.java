/*
 *You are given two arrays L1 and L2, each with n keys sorted in increasing
 * order. For simplicity, you may assume that the keys are all distinct from
 * each other. Describe an O(log(n)) time algorithm to find the kth smallest
 * of the 2n keys assuming that n is even.
 */

package Array;

import java.util.Arrays;

public class Search_in_Two_Arrays {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] a2 = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        int k = 18;   //kth smallest number
        int l1 = 0, r1 = a1.length - 1;
        int l2 = 0, r2 = a2.length - 1;
        System.out.print(search(a1, a2, l1, r1, l2, r2, k - 1));
    }

    public static int search(int[] a1, int[] a2, int l1, int r1, int l2, int r2, int k) {
        while(l1 < r1 - 1 && l2 < r2 - 1) {
            int mid1 = (l1 + r1) / 2;
            int mid2 = (l2 + r2) / 2;
            if(a1[mid1] < a2[mid2]) {
                if(k >= mid1 + mid2)
                    l1 = mid1;
                else
                    r2 = mid2;
            }
            else {
                if(k >= mid1 + mid2)
                    l2 = mid2;
                else
                    r1 = mid1;
            }
        }
        k = k - l1 - l2;
        int[] a3 = new int[r2 - l2 + 1 + r1 - l1 + 1];
        for(int i = l1; i <= r1; i++)
            a3[i - l1] = a1[i];
        for(int i = l2; i <= r2; i++)
            a3[i - l2 + (r1 - l1 + 1)] = a2[i];
        Arrays.sort(a3);
        return a3[k];
    }
}
