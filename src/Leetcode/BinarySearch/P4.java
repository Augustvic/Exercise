package Leetcode.BinarySearch;

public class P4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int base = (length - 1) / 2;
        return isEven(length) ? (getKthNum(nums1, nums2, base) + getKthNum(nums1, nums2, base + 1)) / 2.0 : getKthNum(nums1, nums2, base);
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public static int getKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k];
            }
            if (index2 == length2) {
                return nums1[index1 + k];
            }
            if (k == 0) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = (k + 1) / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
