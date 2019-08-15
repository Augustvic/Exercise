package Tools;

public class ArrayUtil {

    public static <T> boolean isEmpty(T[] nums) {
        return (nums == null) || (nums.length == 0);
    }

    public static <T> boolean isEmpty(T[][] matrix) {
        return (matrix == null || matrix.length == 0 || matrix[0].length == 0);
    }
}
