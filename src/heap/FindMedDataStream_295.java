package heap;

import java.util.*;

public class FindMedDataStream_295 {
	PriorityQueue<Integer> min = new PriorityQueue<>();
	PriorityQueue<Integer> max = new PriorityQueue<>(15, Collections.reverseOrder());

	public FindMedDataStream_295() {
	}

	public void addNum(int num) {
		if (min.isEmpty() || num > min.peek())
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
			return (max.peek() + min.peek()) / 2.0;
		if (max.size() - min.size() == 1)
			return max.peek();

		return min.peek();
	}
}
