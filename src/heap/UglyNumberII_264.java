package heap;

import java.util.PriorityQueue;

public class UglyNumberII_264 {
	public int nthUglyNumber(int n) {
//		其实这个PriorityQueue的作用就是用来输出最小的数 是个小顶堆 就相当于排了序 所以不用min了
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));
			int[] ans = new int[n];
			ans[0] = 1;
				pq.offer(new int[] { 2, 1, 2 });
				pq.offer(new int[] { 3, 1, 3 });
				pq.offer(new int[] { 5, 1, 5 });
			for (int i = 1; i < n; i++) {
				int next = pq.peek()[0];
				ans[i] = next;
				while (pq.peek()[0] == next) { //会有重复
					int[] cur = pq.poll();
					cur[0] = cur[2] * ans[cur[1]];
					cur[1] = cur[1] + 1;
					pq.offer(cur);
				}
			}
			return ans[n-1];
	    }
//这就是树上那种思路 不过我稍微改变了一下 我是下一次对ugly在第i的位置赋值 因为我用三个val存放了上一次算的值 因此
//	如果上次没有被进丑数的那两个value就可以不用再算一遍了 
	public int GetUglyNumber_Solution(int index) {
		int[] ugly = new int[index];
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int val2 = 1;
		int val3 = 1;
		int val5 = 1;

		int next = 1;
		for (int i = 1; i < index; i++) {
			ugly[i] = next; 
			if (ugly[i] == val2)
				val2 = ugly[index2++] * 2;
			if (ugly[i] == val3)
				val3 = ugly[index3++] * 3;
			if (ugly[i] == val5)
				val5 = ugly[index5++] * 5;

			next = Math.min(next, Math.min(val5, Math.min(val2, val3)));
		}
		return ugly[index - 1];

	}
}
