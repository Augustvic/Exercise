package Leetcode.TwoPointer;

public class P11 {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int area = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max(area, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return area;
    }
}
