package heap;

import java.util.*;

//这题目的tag没有heap 但是应该是heap的思想！！
//在heap中存放int[3]={nums[i][j],i,j}
public class SmallestRange_632 {
	public int[] smallestRange(List<List<Integer>> nums) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[1];
			}
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			pq.offer(new int[] { nums.get(i).get(0), i, 0 });
			max = Math.max(max, nums.get(i).get(0));
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.size()) {

			int[] curr = pq.poll();
			if (max - curr[0] < range) {
				range = max - curr[0];
				start = curr[0];
				end = max;
			}
			if (curr[2] + 1 < nums.get(curr[1]).size()) {
				curr[2]++;
				curr[0] = nums.get(curr[1]).get(curr[2]);
				pq.offer(curr);
				if (curr[0] > max) {
					max = curr[0];
				}
			}
		}

		return new int[] { start, end };
	}
}
