package Leetcode.BinarySearch;

public class P33 {

    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                    continue;
                }
                l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                    continue;
                }
                r = mid - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }







//    public static int search(int[] nums, int target) {
//        int l = 0, r = nums.length - 1;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            int midVal = nums[mid];
//            int lVal = nums[l];
//            int rVal = nums[r];
//            if (midVal == target) return mid;
//            if (lVal == target) return l;
//            if (rVal == target) return r;
//            if (midVal == lVal) {
//                return traverse(nums, l, r, target);
//            } else if (midVal > lVal) {
//                if (target > midVal || target < lVal) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            } else {
//                if (target < midVal || target > lVal) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            }
//        }
//        return nums[l] == target ? l : -1;
//    }
//
//    public static int traverse(int[] nums, int l, int r, int target) {
//        for (int i = l; i <= r; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
