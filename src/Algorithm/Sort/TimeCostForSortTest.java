package Algorithm.Sort;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TimeCostForSortTest {

    // 待排序数组长度
    public static final int N = 1000000;

    public static final int numOfSortAl = 7;

    public static final String[] sort = {"selectSort", "bubbleSort", "insertSort", "shellSort",
            "mergeSort", "quickSort", "heapSort"};

    public static void main(String[] args) {
        TimeCostForSortTest t = new TimeCostForSortTest();
        List<int[]> list = t.initialArrayList(N, numOfSortAl);
        for (int i = 0; i < numOfSortAl; i++) {
            String al = sort[i];
            int[] nums = list.get(i);
            long startTime = System.currentTimeMillis();
            try {
                t.callForSortByName(al, nums);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(al + ": " + (endTime - startTime) + "ms");
        }
    }

    public void callForSortByName(String al, int[] nums) throws Exception {
        if (al == null || al.length() == 0)
            throw new NumberFormatException();
        Method method = this.getClass().getMethod(al, int[].class);
        method.invoke(this, new Object[]{nums});
    }

    // 生成待排序数组
    public List<int[]> initialArrayList(int n, int numOfSortAl) {
        int[] nums = new int[n];
        Random rand = new Random();
        for (int j = 0; j < n; j++)
            nums[j] = rand.nextInt(1000) + 1;
        List<int[]> list = new ArrayList<>();
        list.add(nums);
        for (int i = 1; i < numOfSortAl; i++) {
            list.add(Arrays.copyOf(nums, nums.length));
        }
        return list;
    }

    public void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = index; j < n; j++) {
                if (nums[j] < nums[index])
                    index = j;
            }
            swap(nums, i, index);
        }
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j + 1 < i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
    }

    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j - 1, j);
            }
        }
    }

    public void shellSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int incrementNum = nums.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < incrementNum; i++) {
                //冒泡排序
                for (int j = i; j < nums.length - incrementNum; j = j + incrementNum) {
                    if (nums[j] > nums[j + incrementNum]) {
                        int temple = nums[j];
                        nums[j] = nums[j + incrementNum];
                        nums[j + incrementNum] = temple;
                    }
                }
            }
            incrementNum = incrementNum / 2;
        }
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        helper = new int[nums.length];
        mergeSortHelp(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        quickSortHelp(nums, 0, nums.length - 1);
    }

    public void heapSort(int[] nums) {
        if (nums == null)
            return;
        for (int i = nums.length / 2 - 1; i > 0; i--)
            adjustHeap(nums, i, nums.length);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private int[] helper;

    public void mergeSortHelp(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortHelp(nums, l, mid);
            mergeSortHelp(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public void merge(int[] nums, int l, int mid, int r) {
        for (int i = l; i <= r; i++)
            helper[i] = nums[i];
        int p1 = mid;
        int p2 = r;
        int index = r;
        while (p1 >= l && p2 >= mid + 1) {
            if (helper[p1] > helper[p2])
                nums[index--] = helper[p1--];
            else
                nums[index--] = helper[p2--];
        }
        while (p1 >= l)
            nums[index--] = helper[p1--];
        while (p2 >= mid + 1)
            nums[index--] = helper[p2--];
    }

    public void quickSortHelp(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSortHelp(nums, l, index - 1);
            quickSortHelp(nums, index + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = r;
        while (l < r) {
            while (l < r && nums[l] < nums[pivot]) l++;
            while (l < r && nums[r] >= nums[pivot]) r--;
            swap(nums, l, r);
        }
        swap(nums, l, pivot);
        return l;
    }

    public void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1])
                k = k + 1;
            if (temp < nums[k]) {
                nums[i] = nums[k];
                i = k;
            } else
                break;
        }
        nums[i] = temp;
    }
}
