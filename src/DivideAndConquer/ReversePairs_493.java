package DivideAndConquer;

import java.util.*;

public class ReversePairs_493 {
	int res = 0;

	public int reversePairs(int[] nums) {
		int[] temp = new int[nums.length];
		return InversePairsCore(nums, temp, 0, nums.length - 1);
	}

	private int InversePairsCore(int[] a, int[] temp, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			InversePairsCore(a, temp, left, mid);
			InversePairsCore(a, temp, mid + 1, right);
			merge(a, temp, left, mid, right);
		}
		System.out.println(Arrays.toString(a));
		return res;

	}

	private void merge(int[] a, int[] copy, int leftPos, int leftEnd, int rightEnd) {
		int rightPos = leftEnd + 1;
		int rightStart = leftEnd + 1;
		int copyPos = leftPos;
		int start = leftPos;
		int right = rightStart;
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (a[leftPos] < a[rightPos]) {
				// ////////////////////////////
				while (right <= rightEnd && a[leftPos] > 2 * (long) a[right])
					right++;
				res += right - rightStart;
				// //////////////////////////////
				copy[copyPos++] = a[leftPos++];
			} else
				copy[copyPos++] = a[rightPos++];
		}
		while (leftPos <= leftEnd) {
			// ////////////////////////////////////////////////////////////////
			while (right <= rightEnd && a[leftPos] > 2 * (long) a[right])
				right++;
			res += right - rightStart;
			// ////////////////////////////////////////////////////////////////
			copy[copyPos++] = a[leftPos++];
		}
		while (rightPos <= rightEnd)
			copy[copyPos++] = a[rightPos++];
		for (int i = start; i <= rightEnd; i++)
			a[i] = copy[i];
	}
}
