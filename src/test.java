import DataStructure.BinaryTree;
import DataStructure.BinaryTreeNode;
import DataStructure.ComplexListNode;
import DataStructure.ListNode;
import Tools.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 11, 15};
        int sum = 18;
        if(!t.find1(nums, sum))
            System.out.println("Error");
        int sum2 = 15;
        t.find2(sum2);
    }

    public static test t = new test();

    public boolean find1(int[] nums, int sum) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left] + nums[right];
            if (tmp == sum) {
                System.out.println("[" + nums[left] + "," + nums[right] + "]");
                return true;
            }
            else if (tmp > sum) {
                right--;
            }
            else {
                left++;
            }
        }
        return false;
    }

    public void find2(int sum) {
        if (sum < 0)
            return;
        int l = 1;
        int r = 2;
        int currSum = 3;
        while (l <= r && r < sum) {
            if (currSum == sum) {
                print(l, r);
                currSum -= l;
                l++;
            }
            else if (currSum > sum) {
                currSum -= l;
                l++;
            }
            else {
                r++;
                currSum += r;
            }
        }
    }

    private void print(int l, int r) {
        for (int i = l; i <= r; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
