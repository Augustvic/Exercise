package Tools;

public class ArrayUtil {

    public static boolean isEmpty(int[] nums) {
        return (nums == null) || (nums.length == 0);
    }

    public static boolean isEmpty(int[][] matrix) {
        return (matrix == null || matrix.length == 0 || matrix[0].length == 0);
    }
}
