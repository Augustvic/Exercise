/*二维数组中的查找：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个
 * 函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

package Array;

public class Find_k_in_a_two_dimensional_array {

	public static void main(String[] args) {
		int array[][] = {{1, 2, 3, 4}, {3, 5, 6, 8}, {4, 7, 8, 9}, {6, 10, 12, 13}};
		int target = 7;
		System.out.print(Find(target, array));
	}

	public static boolean Find(int target, int [][] array) {
		int rows = array.length - 1;
		int columns = array[0].length - 1;
		int i = 0;
		int j = columns;
		while(i <= rows && j >= 0) {
			if(array[i][j] == target)
				return true;
			else if(array[i][j] > target)
				j--;
			else
				i++;
		}
		return false;
	}
}
