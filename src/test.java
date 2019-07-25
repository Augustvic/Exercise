import java.util.*;

public class test {

    public static void main(String[] args) {
        System.out.println(t.maxChunksToSorted(new int[]{1, 2, 0, 3}));
        ArrayList<Integer> l = new ArrayList<>();
    }

    public static test t = new test();

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int ret = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            //right代表到目前为止的最大值
            right = Math.max(arr[i], right);
            if(right == i)
                ret++;
        }
        return ret;
    }
}
