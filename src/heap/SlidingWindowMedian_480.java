package heap;

import java.util.*;

public class SlidingWindowMedian_480 {
	// 和FindMedDataStream_295一样的思路
	// 如果用两个TreeMap时间复杂度更低 因为 对于PriorityQueue 的remove方法 只能遍历的寻找
	// 但是TreeMap 把map1的top 移到map2 没有用 max.offer(min.poll());方便 虽然时间复杂度都是1

	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(15, Collections.reverseOrder());

	public double[] medianSlidingWindow(int[] nums, int k) {
		int left = 0;
		int right = 0;
		double[] res = new double[nums.length - k + 1];
		while (right < k - 1) {
			addNum(nums[right++]);
		}
		while (right < nums.length) {
			addNum(nums[right++]);
			res[left] = findMedian();
			removeNum(nums[left++]);
		}
		return res;
	}

	public void removeNum(int num) {
		if (!min.isEmpty() && num >= min.peek())
			min.remove(num); // 这个操作的时间复杂度是O(N) 如果用tree的话 会是O(logN)
		else
			max.remove(num);
		if (min.size() - max.size() > 1)
			max.offer(min.poll());
		else if (max.size() - min.size() > 1)
			min.offer(max.poll());
	}

	public void addNum(int num) {
		if (max.isEmpty() || num > max.peek())
			min.offer(num);
		else
			max.offer(num);
		if (min.size() - max.size() > 1)
			max.offer(min.poll());
		else if (max.size() - min.size() > 1)
			min.offer(max.poll());
	}

	public double findMedian() {
		if (max.size() == min.size())
			return (max.peek() * 1.0 + min.peek() * 1.0) / 2.0;
		if (max.size() - min.size() == 1)
			return max.peek();

		return min.peek();
	}
}
