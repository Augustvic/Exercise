package Algorithm.Sort;

import java.lang.reflect.Method;
import java.util.*;

public class TimeCostForSortTest {

    // 待排序数组长度
    private static final int N = 10000000;

    // 生成随机数的最大值
    private static final int randValue = 100000000;

    // 排序方法个数
    private static final int numOfSortAl = 7;

    // 各种排序的方法名
//    public static final String[] sort = {"selectSort", "bubbleSort", "insertSort", "shellSort",
//            "mergeSort", "quickSort", "heapSort"};
    public static final String[] sort = {"shellSort", "mergeSort", "quickSort", "heapSort"};

    // main 函数
    public static void main(String[] args) {
        TimeCostForSortTest t = new TimeCostForSortTest();
        // 生成待排序数组
        List<int[]> list = t.initialArrayList();
        for (int i = 0; i < sort.length; i++) {
            String al = sort[i];
            int[] nums = list.get(i);
            long startTime = System.currentTimeMillis();
            try {
                // 调用某个排序方法
                t.callForSortByName(al, nums);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            // 打印出排序所用的时间
            System.out.println(al + ": " + (endTime - startTime) + "ms");
        }
    }

    /**
     * 调用指定的方法
     * @param al 方法名
     * @param nums 参数
     * @throws Exception 异常
     */
    public void callForSortByName(String al, int[] nums) throws Exception {
        if (al == null || al.length() == 0)
            throw new NumberFormatException();
        // 使用装载当前类的类装载器来装载指定的类
        Class<?> alClass = Class.forName("Algorithm.Sort.TimeCostForSortTest");
        // 获得指定的对象中的方法
        Method method = alClass.getMethod(al, int[].class);
        // 调用 this 对象的 method 方法
        method.invoke(this, new Object[]{nums});
    }



    /**
     * 生成待排序数组，数字随机
     * 列表中每一个待排序数组完全相同
     * @return 生成的数组列表
     */
    private List<int[]> initialArrayList() {
        int[] nums = new int[N];
        Random rand = new Random();
        for (int j = 0; j < N; j++)
            nums[j] = rand.nextInt(randValue) + 1;
        List<int[]> list = new ArrayList<>();
        list.add(nums);
        for (int i = 1; i < sort.length; i++) {
            list.add(Arrays.copyOf(nums, nums.length));
        }
        return list;
    }

    /**
     * 选择排序
     * @param nums 待排序数组
     */
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

    /**
     * 冒泡排序
     * @param nums 待排序数组
     */
    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j + 1 < i; j++) {
                if (nums[j] > nums[j + 1])
                    swap(nums, j, j + 1);
            }
        }
    }

    /**
     * 插入排序
     * @param nums 待排序数组
     */
    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j - 1, j);
            }
        }
    }

    /**
     * shell 排序
     * @param nums 待排序数组
     */
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

    /**
     * 归并排序
     * @param nums 待排序数组
     */
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        helper = new int[nums.length];
        mergeSortHelp(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     * @param nums 待排序数组
     */
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        quickSortHelp(nums, 0, nums.length - 1);
    }

    /**
     * 堆排序
     * @param nums 待排序数组
     */
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

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private int[] helper;

    private void mergeSortHelp(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortHelp(nums, l, mid);
            mergeSortHelp(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
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

    private void quickSortHelp(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            quickSortHelp(nums, l, index - 1);
            quickSortHelp(nums, index + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = r;
        while (l < r) {
            while (l < r && nums[l] < nums[pivot]) l++;
            while (l < r && nums[r] >= nums[pivot]) r--;
            swap(nums, l, r);
        }
        swap(nums, l, pivot);
        return l;
    }

    private void adjustHeap(int[] nums, int i, int length) {
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
