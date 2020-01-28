package Array;

public class Quick_Sort {

	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 1, 8, 2, 10, 9, 2, 3, 6, 7, 5, 11};
		int l = 0;
		int r = nums.length - 1;
		quickSort(nums, l, r);
		for(int i : nums)
			System.out.print(i + " ");
	}

	public static void quickSort(int[] nums, int l, int r) {
		if(l < r) {
			int index = partition(nums, l, r);
			quickSort(nums, l, index - 1);
			quickSort(nums, index + 1, r);
		}
	}

	public static int partition(int[] nums, int l, int r) {
		int pivot = r;
		while(l < r) {
			while(nums[l] < nums[pivot] && l < r) l++;
			while(nums[r] >= nums[pivot] && l < r) r--;
			swap(nums, l, r);
		}
		swap(nums, pivot, l);
		return l;
	}

	public static void swap(int[] nums, int x, int y) {
		int t = nums[x];
		nums[x] = nums[y];
		nums[y] = t;
	}
}
