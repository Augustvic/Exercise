/*
 * Suppose an array A consists of n elements, each of which is red, white, or blue. We seek to sort the elements
 * so that all the reds come before all the whites, which come before all the blues.
 * The only operation permitted on the keys are
 * 1.Examine(A, i): report the color of the ith element of A.
 * 2.Swap(A, i, j): swap the ith element of A with the jth element.
 * Find, describe and analyze a linear time algorithm for this red-white-blue sorting.
 */


package Array;

public class The_Dutch_National_Flag_Problem {

	public static void main(String[] args) {
		char[] A = {'R', 'W', 'R', 'B', 'W', 'R', 'B', 'W', 'B', 'W'};
		int l = 0;
		int r = A.length - 1;
		sort(A, l, r);
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
	
	public static void sort(char[] A, int l, int r) {
		int i = 0;
		while(i < r) {
			if(A[i] == 'R') {
				swap(A, i, l);
				l += 1;
				i += 1;
			}
			else if(A[i] == 'B') {
				swap(A, i, r);
				r -= 1;
			}
			else {
				i += 1;
			}
		}
	}
	
	public static void swap(char[] A, int i, int j) {
		char c = A[i];
		A[i] = A[j];
		A[j] = c;
	}
}
