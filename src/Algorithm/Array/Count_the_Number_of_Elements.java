/*
 * Let L be a list of numbers in non-decreasing order, and x be a given number. Describe an algorithm that counts the
 * number of elements in L whose values are x. Your algorithm should run in O(log(n))time.
 */

package Array;

public class Count_the_Number_of_Elements {

	public static void main(String[] args) {
		double L[] = {1.3, 2.1, 2.1, 2.1, 2.1, 6.7, 7.5, 7.5, 8.6, 9.0};
		double x = 2.1;
		System.out.print(count(L, x));
	}
	
	public static int count(double[] L, double x) {
		int indexL = 0;
		int indexR = 0;
		int l = 0, r = L.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(L[mid] == x) {
				indexL = mid;
				r = mid - 1;
			}
			else if(L[mid] > x)
				r = mid - 1;
			else
				l = mid + 1;
		}
		l = 0; r = L.length - 1;
		while(l <= r) {
			int mid = (l + r) / 2;
			if(L[mid] == x) {
				indexR = mid;
				l = mid + 1;
			}
			else if(L[mid] > x)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return indexR - indexL + 1;
	}

}
