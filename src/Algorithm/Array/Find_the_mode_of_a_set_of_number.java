/*
 * The mode of a set of numbers is the number that occurs most frequently in the set. The set (4,6,2,4,3,1) 
 * has a mode of 4.
 * 1. Give an efficient and correct algorithm to compute the mode of a set of n numbers;
 * 2. Suppose we know that there is an (unknown) element that occurs n=2+1 times in the set. Give a 
 * worst-case linear-time algorithm to find the mode. 
 * For partial credit, your algorithm may run in expected linear time.
 */

package Array;

public class Find_the_mode_of_a_set_of_number {

	public static void main(String[] args) {
		int[] A = {1, 3, 4, 5, 2, 2, 2, 2, 2, 2};
		int n = A.length;
		int low = 0;
		int high = n - 1;
		int res = findMode(A, low, high, n);
		System.out.print("The mode of the array is:" + res);
	}

	public static int findMode(int[] A, int low, int high, int n) {
		if(low == high)
			return A[low];
		else if(low < high){
			int ploc = Partition(A, low, high);
			if(ploc > n/2)
				return findMode(A, low, ploc - 1, n);
			else
				return findMode(A, ploc + 1, high, n);
		}
		else
			return A[high];
	}
	
	public static int Partition(int[] arr, int low, int high) {
	    int pivot = arr[low];//选第一个元素作为枢纽元
	    while(low < high)
	    {
	        while(low < high && arr[high] >= pivot)high--;
	        arr[low] = arr[high];//从后面开始找到第一个小于pivot的元素，放到low位置
	        while(low < high && arr[low] <= pivot)low++;
	        arr[high] = arr[low];//从前面开始找到第一个大于pivot的元素，放到high位置
	    }
	    arr[low] = pivot;//最后枢纽元放到low的位置
	    return low;
    }
	
	public static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
