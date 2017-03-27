package heap;

import java.util.PriorityQueue;

public class UglyNumberII_264 {
	public int nthUglyNumber(int n) {
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));
			int[] ans = new int[n];
			ans[0] = 1;
				pq.offer(new int[] { 2, 1, 2 });
				pq.offer(new int[] { 3, 1, 3 });
				pq.offer(new int[] { 5, 1, 5 });
			for (int i = 1; i < n; i++) {
				int next = pq.peek()[0];
				ans[i] = next;
				while (pq.peek()[0] == next) { //»áÓÐÖØ¸´
					int[] cur = pq.poll();
					cur[0] = cur[2] * ans[cur[1]];
					cur[1] = cur[1] + 1;
					pq.offer(cur);
				}
			}
			return ans[n-1];
	    }
}
