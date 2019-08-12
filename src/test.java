import java.util.*;

public class test {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
    }

    public void threeWayQuickSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        threeWayQuickSortHelp(nums, 0, nums.length - 1);
    }

    public void threeWayQuickSortHelp(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int pivot = nums[l];
        int lt = l;
        int i = l + 1;
        int rt = r;
        while (i <= rt) {
            if (nums[i] < pivot)
                swap(nums, lt++, i++);
            else if (nums[i] > pivot)
                swap(nums, i, rt--);
            else
                i++;
        }
        threeWayQuickSortHelp(nums, l, lt - 1);
        threeWayQuickSortHelp(nums, rt + 1, r);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
