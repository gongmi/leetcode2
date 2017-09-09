package DivideAndConquer;

import java.util.*;

// 用剑指offer 逆序对的思路 看top的解答思路 
//就是在左边移动的时候加入

//while (low <= rightEnd && a[low] - a[leftPos] < lower)
//	low++;
//while (high <= rightEnd && a[high] - a[leftPos] <= upper)
//	high++;
//res += high - low;

//而且要注意 low 和high只需要一个 我一开始 每次都重新找了low 和high
//其实后来的low和high 一定在 当前的后面（因为leftPos是递增的） 
//所以只需要在原来的位置上向后移就行了

//the indices low, high will only increase but not decrease,
//each of them will only traversal the right half once at most. 
//divide and conquer solution   time complexity   O(n log n).
public class CountRangeSum_327 {
	int res = 0;
	int lower;
	int upper;

	public int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		long[] copy = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		this.lower = lower;
		this.upper = upper;
		mergeSort(sums, copy, 0, sums.length - 1);
		return res;
	}

	private void mergeSort(long[] a, long[] copy, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) >> 1;
		mergeSort(a, copy, left, mid);
		mergeSort(a, copy, mid + 1, right);
		merge(a, copy, left, mid, right);
	}

	private void merge(long[] a, long[] copy, int leftPos, int leftEnd, int rightEnd) {
		int rightPos = leftEnd + 1;
		int rightStart = leftEnd + 1;
		int copyPos = leftPos;
		int start = leftPos;
		int low = rightStart, high = rightStart;
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos] < a[rightPos]) {
				// ////////////////////////////
				while (low <= rightEnd && a[low] - a[leftPos] < lower)
					low++;
				while (high <= rightEnd && a[high] - a[leftPos] <= upper)
					high++;
				res += high - low;
				// //////////////////////////////
				copy[copyPos++] = a[leftPos++];
			} else
				copy[copyPos++] = a[rightPos++];
		}
		while (leftPos <= leftEnd) {
			// ////////////////////////////////////////////////////////////////
			while (low <= rightEnd && a[low] - a[leftPos] < lower)
				low++;
			while (high <= rightEnd && a[high] - a[leftPos] <= upper)
				high++;
			res += high - low;
			// ////////////////////////////////////////////////////////////////
			copy[copyPos++] = a[leftPos++];
		}
		while (rightPos <= rightEnd)
			copy[copyPos++] = a[rightPos++];
		for (int i = start; i <= rightEnd; i++)
			a[i] = copy[i];
	}
}