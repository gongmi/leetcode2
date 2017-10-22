package dynamicProgramming;

import java.util.*;

public class MaxSumRectangleNoLargerThanK_363 {
	// time complexity O(c*c * r * log(r)
	// space complexity O(r).
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] sums = new int[row];
		int res = Integer.MIN_VALUE;
		for (int c1 = 0; c1 < col; c1++) {
			Arrays.fill(sums, 0);
			for (int c2 = c1; c2 < col; c2++) {
				for (int r = 0; r < row; r++) {
					sums[r] = sums[r] + matrix[r][c2];
				}
				// max subarray sum no more than k
				// ÓëContainsDuplicateIII_220 ÏàËÆ
				TreeSet<Integer> set = new TreeSet<>();
				set.add(0);
				int cur = 0;
				for (int r = 0; r < row; r++) {
					cur += sums[r];
					Integer pre = set.ceiling(cur - k);
					if (pre != null)
						res = Math.max(res, cur - pre);
					set.add(cur);
				}
			}
		}
		return res;
	}
}
