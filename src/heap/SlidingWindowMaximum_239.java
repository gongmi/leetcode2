package heap;

//剑指offer65
import java.util.*;
//就是用于个双端队列 来保存可能的max的index
//但是放的时候不能出现递增的情况 因为如果加进来的数比原来的大
//那说明原来的不可能成为max了
//因此队列中放的数是递减的
//队列的头部即为max

public class SlidingWindowMaximum_239 {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0)
			return new int[0];
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
				deque.pollLast();
			deque.offerLast(i);
			int index = deque.peekFirst();
			if (i >= k - 1)
				res[i - k + 1] = nums[index];
			if ((i - index) == k - 1) // 头部的index太小了 即将滑出滑动窗口了 就不能再用于下一次作为头部了
				deque.pollFirst();
		}

		return res;
	}

	// 2017.08.27用的双指针 其实这里的j 右指针就相当于上面的i
	// 这里的左指针i 上面没有左指针
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if (k == 0)
			return new int[0];
		Deque<Integer> queue = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[j]) {
				queue.pollLast();
			}
			queue.offer(j);

			if (j - i == k && queue.peekFirst() == i++)
				queue.pollFirst();

			if (j - i == k - 1) {
				res[j - k + 1] = nums[queue.peekFirst()];
			}
		}
		return res;
	}
}
