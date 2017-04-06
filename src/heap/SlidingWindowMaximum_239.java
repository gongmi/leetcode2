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
		    if (k==0) return new int[0];
			int[] res = new int[nums.length-k+1];
			Deque<Integer> deque = new LinkedList<>();

			for (int i = 0; i < nums.length; i++) {
				while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
					deque.pollLast();
				deque.offerLast(i);
				int index = deque.peekFirst();
				if (i >= k - 1)
					res[i-k+1]=nums[index];
				if ((i - index) == k-1) //头部的index太小了 即将滑出滑动窗口了 就不能再用于下一次作为头部了
					deque.pollFirst();
			}

			return res;
		}
	}
