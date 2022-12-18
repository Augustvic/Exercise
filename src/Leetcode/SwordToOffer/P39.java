package Leetcode.SwordToOffer;

public class P39 {

    public static void main(String[] args) {
        int[] nums = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        System.out.println(moreThanHalfOptimal(nums));
        System.out.println(moreThanHalfOptimal2(nums));
    }

    // Hint https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-pvh8/
    public static int moreThanHalfOptimal(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            count = count + (nums[i] == candidate ? 1 : -1);
        }
        return candidate;
    }

    public static int moreThanHalfOptimal2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return getIndexWithSort(nums, nums.length / 2);
    }

    public static int getIndexWithSort(int[] nums, int index) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int p = partition(nums, l, r);
            if (p == index) {
                return nums[p];
            } else if (p > index) {
                r = p - 1;
            } else {
                l = p + 1;
            }
        }
        return 0;
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = r;
        while (l < r) {
            while (l < r && nums[l] < nums[pivot]) l++;
            while (l < r && nums[r] >= nums[pivot]) r--;
            swap(nums, l, r);
        }
        swap(nums, l, pivot);
        return l;
    }

    public static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}