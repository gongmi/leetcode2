package dynamicProgramming;

// 01背包  在满足0的个数 1的个数的weight的情况下 使个数最多
//因为不是分数背包问题 所以不能用上面所说的贪心算法来做
//https://discuss.leetcode.com/topic/76103/0-1-knapsack-detailed-explanation
public class OnesAndZeroes_474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int l = strs.length;
		int[][][] dp = new int[l + 1][m + 1][n + 1];

		for (int i = 0; i < l + 1; i++) {
			int[] nums = new int[2];
			if (i > 0) {
				nums = calculate(strs[i - 1]);
			}
			for (int j = 0; j < m + 1; j++) {
				for (int k = 0; k < n + 1; k++) {
					if (i == 0) {
						dp[i][j][k] = 0;
					} else if (j >= nums[0] && k >= nums[1]) {
						dp[i][j][k] = Math.max(dp[i - 1][j][k],
								dp[i - 1][j - nums[0]][k - nums[1]] + 1);
					} else {
						dp[i][j][k] = dp[i - 1][j][k];
					}
				}
			}
		}

		return dp[l][m][n];
	}

	private int[] calculate(String str) {
		int[] res = new int[2];
		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}
		return res;
	}

	// 也就是说这下面的解法其实就是背包问题的简化
	// we can decrease the space complexity from ijk to j*k
	// 但是必须从大到小
	// http://love-oriented.com/pack/P01.html
	// 上面讲了关于降维
	public int findMaxForm2(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int ones = calculate(s)[0];
			int zeroes = calculate(s)[1];

			for (int i = m; i >= zeroes; i--)
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i - zeroes][j - ones] + 1, dp[i][j]);
				}
		}
		return dp[m][n];
	}

}
