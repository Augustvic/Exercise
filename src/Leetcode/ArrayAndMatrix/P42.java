package Leetcode.ArrayAndMatrix;

public class P42 {

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMaxHeight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i - 1]);
        }
        int[] rightMaxHeight = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        int[] trapArray = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            trapArray[i] = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += trapArray[i] > height[i] ? trapArray[i] - height[i] : 0;
        }
        return result;
    }
}
