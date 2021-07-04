package Leetcode.ArrayAndMatrix;

public class P42 {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int[] leftMaxHeight = new int[len];
        int[] rightMaxHeight = new int[len];
        leftMaxHeight[0] = 0;
        for (int i = 1; i < len; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i - 1]);
        }
        rightMaxHeight[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        int ret = 0;
        for (int i = 0; i < len; i++) {
             int h = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
             ret += (h > height[i]) ? (h - height[i]) : 0;
        }
        return ret;
    }
}
