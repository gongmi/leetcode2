package sort;

import java.util.*;

public class BestMeetingPoint_296 {

	public int minTotalDistance(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		// 因为不清楚有多少个点 所以用list
		List<Integer> I = new ArrayList<Integer>();
		List<Integer> J = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					I.add(i);
				}
			}
		}
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (grid[i][j] == 1) {
					J.add(j);
				}
			}
		}
		return minTotalDistance(I) + minTotalDistance(J);
	}

	public int minTotalDistance(List<Integer> list) {
		int i = 0, j = list.size() - 1, sum = 0;
		while (i < j) {
			sum += list.get(j--) - list.get(i++);
		}
		return sum;
	}

}
