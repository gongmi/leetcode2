package dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle_85 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int[] height = new int[matrix[0].length];
		int res = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				height[c] = matrix[r][c] == '0' ? 0 : height[c] + 1;
			}
			res = Math.max(res, largestRectangleArea(height));
		}
		return res;
	}

	private int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();
		int index = 0;
		int i = 0;
		int res = 0;
		int cur = 0;
		int len = heights.length;
		while (i <= len) {
			if (!s.isEmpty() && (i == len ? 0 : heights[i]) < heights[s.peek()]) {
				index = s.pop();
				cur = heights[index] * (i - (s.isEmpty() ? 0 : (s.peek() + 1)));
				res = Math.max(res, cur);
			} else
				s.push(i++);
		}
		return res;
	}

	public int maximalRectangle2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n - 1);
		int maxA = 0;
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) { // compute height (can do this from
											// either side)
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) { // compute left (from left to right)
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}
			for (int j = 0; j < n; j++) {
				// 加上这句就可以做MaximalSquare_221
				// if (right[j] - left[j] >= height[j])
				// maxA = Math.max(maxA, height[j] * height[j]);
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
			}

		}
		return maxA;
	}
}
