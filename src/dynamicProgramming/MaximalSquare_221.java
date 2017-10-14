package dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaximalSquare_221 {
	// 用 MaximalRectangle_85的第一种解法来做 只需要加上一个条件即可 当然这不是 最科学的做法
	// top答案
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				} else
					dp[i][j] = 0;
			}
		}
		return max * max;
	}

	// 可以降维
	// 由于dp[i][j] 要用到dp[i - 1][j - 1]
	// 而在计算dp[i][j-1]时 dp[i - 1][j - 1]会被覆盖
	// 所以用一个pre来保存dp[i - 1][j - 1]
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] dp = new int[n + 1];
		int max = 0;
		int preLeftTop = 0;
		for (int i = 1; i <= m; i++) {
			preLeftTop = 0;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(preLeftTop, Math.min(dp[j], dp[j - 1])) + 1;
					max = Math.max(max, dp[j]);
				} else
					dp[j] = 0;
				preLeftTop = temp;
			}
		}
		return max * max;
	}
}
