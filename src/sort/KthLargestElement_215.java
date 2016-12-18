package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement_215 {
	// 快速选择排序Quick select 
//	用快速排序的思想 先把它一分为2  然后判断pivot与k的关系 来决定选哪一边继续partition
//	O(N) best case orO(N^2) worst case running time + O(1) memory
	public int findKthLargest3(int[] nums, int k) {
		k = nums.length - k;
		int index = 0;
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			index = QuickSort.partition(nums, low, high);
			if (index == k)
				return nums[index];
			else if (index > k)
				high = index - 1;
			else 
				low = index + 1;
		}
		return nums[low];

	}

	// 堆排序 O(N lg K) running time + O(K) memory
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int n : nums) {
			pq.offer(n);
			if (pq.size() > k)
				pq.poll();
		}

		return pq.poll();
	}

	// 快速排序 O(N lg N) running time + O(1) memory
	public int findKthLargest2(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

}
