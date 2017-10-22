package heap;

import java.util.*;

public class SlidingWindowMedian_480 {
	// ��FindMedDataStream_295һ����˼·
	// ���������TreeMapʱ�临�Ӷȸ��� ��Ϊ ����PriorityQueue ��remove���� ֻ�ܱ�����Ѱ��
	// ����TreeMap ��map1��top �Ƶ�map2 û���� max.offer(min.poll());���� ��Ȼʱ�临�Ӷȶ���1

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
			min.remove(num); // ���������ʱ�临�Ӷ���O(N) �����tree�Ļ� ����O(logN)
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
