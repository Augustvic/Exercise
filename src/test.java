import java.util.*;

public class test {

    public static void main(String[] args) {
        int[][] nums = {{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(t.kthSmallest(nums, 8));
    }

    public static test t = new test();

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return ret;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1 && nums[nums[index] - 1] != nums[index]) {
                swap(nums, index, nums[index] - 1);
            }
            else {
                if (!ret.contains(nums[index]))
                    ret.add(nums[index]);
                index++;
            }
        }
        return ret;
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
