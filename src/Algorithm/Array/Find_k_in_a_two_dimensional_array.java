/*��ά�����еĲ��ң�
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�����������һ��
 * ����������������һ����ά�����һ��������
 * �ж��������Ƿ��и�������
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
