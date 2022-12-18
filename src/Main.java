import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(20);
        }
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    public static int partition(int[] nums, int l, int r) {
        int p = r;
        while (l < r) {
            while (l < r && nums[l] < nums[p]) l++;
            while (l < r && nums[r] >= nums[p]) r--;
            swap(nums, l, r);
        }
        swap(nums, l, p);
        return l;
    }

    public static void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}