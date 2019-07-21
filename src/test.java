import java.util.*;

public class test {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println();
    }

    public static test t = new test();

    public int findLHS(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int k : nums) {
            if (hm.containsKey(k)) {
                hm.put(k, hm.get(k) + 1);
            }
            else
                hm.put(k, 1);
        }
        int longest = 0;
        for (int key : hm.keySet()) {
            if (hm.containsKey(key + 1))
                longest = Math.max(longest, hm.get(key) + hm.get(key + 1));
        }
        return longest;
    }
}
