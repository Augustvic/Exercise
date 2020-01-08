import DataStructure.*;
import Tools.*;
import com.sun.javafx.css.parser.LadderConverter;
import javafx.util.Pair;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        t.GetLeastNumbers_Solution(input, 4);
    }

    private static test t = new test();

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int l = 0;
        int r = input.length - 1;
        ArrayList<Integer> ret = new ArrayList<>();
        while (l <= r) {
            int index = partition(input, l, r);
            if (index == k - 1 && copy(ret, input, k)) {
                return ret;
            }
            else if (index > k - 1) {
                r = index - 1;
            }
            else {
                l = index + 1;
            }
        }
        return ret;
    }

    private int partition(int[] input, int l, int r) {
        int pivot = r;
        while (l < r) {
            while (l < r && input[l] < input[pivot]) l++;
            while (l < r && input[r] >= input[pivot]) r--;
            swap(input, l, r);
        }
        swap(input, l, pivot);
        return l;
    }

    private void swap(int[] input, int l, int r) {
        int t = input[l];
        input[l] = input[r];
        input[r] = t;
    }

    private boolean copy(ArrayList<Integer> ret, int[] input, int end) {
        for (int i = 0; i < end; i++) {
            ret.add(input[i]);
        }
        return true;
    }

}
