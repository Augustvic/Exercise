package Leetcode.ArrayAndMatrix;

import java.util.ArrayList;
import java.util.List;

public class P56 {
    public int[][] merge(int[][] intervals) {
        // sort
        quickSort(intervals, 0, intervals.length - 1);
        // merge
        List<int[]> resultList = new ArrayList<>();
        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (max < intervals[i][0]) {
                int[] t = new int[]{min, max};
                resultList.add(t);
                min = intervals[i][0];
                max = intervals[i][1];
            } else {
                max = Math.max(max, intervals[i][1]);
            }
        }
        resultList.add(new int[]{min, max});
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public void quickSort(int[][] intervals, int l, int r) {
        if (l > r) {
            return;
        }
        int index = partition(intervals, l, r);
        quickSort(intervals, l, index - 1);
        quickSort(intervals, index + 1, r);
    }

    public int partition(int[][] intervals, int l, int r) {
        int p = r;
        int pivot = intervals[p][0];
        while (l < r) {
            while (l < r && intervals[l][0] < pivot) {
                l++;
            }
            while (l < r && intervals[r][0] >= pivot) {
                r--;
            }
            swap(intervals, l, r);
        }
        swap(intervals, l, p);
        return l;
    }

    public void swap(int[][] intervals, int l, int r) {
        int[] t = intervals[l];
        intervals[l] = intervals[r];
        intervals[r] = t;
    }
}
