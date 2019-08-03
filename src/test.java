import java.util.*;

public class test {

    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 9, 10, 1, 5};
        System.out.println(Arrays.toString(nums));
        t.shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static test t = new test();

    public void shellSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int n = nums.length;
        int incrementNum = n / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < incrementNum; i++) {
                bubbleSort(nums, i, incrementNum);
            }
            incrementNum = incrementNum >> 1;
        }
    }

    public void bubbleSort(int[] nums, int start, int incrementNum) {
        int n = nums.length;
        for (int i = n; i > 0; i -= incrementNum) {
            for (int j = 0; j + incrementNum < i; j += incrementNum) {
                if (nums[j] > nums[j + incrementNum])
                    swap(nums, j, j + incrementNum);
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
