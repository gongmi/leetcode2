package dynamicProgramming;
//这道题是一道典型的应用DP来解的题，

//如果我们看到这种求总数，而不是列出所有情况的题，十有八九都是用DP来解，
//重中之重就是在于找出递推式。
//如果你第一反应没有想到用DP来做，想得是用贪心算法来做，
//比如先给字符串数组排个序，让长度小的字符串在前面，
//然后遍历每个字符串，遇到0或者1就将对应的m和n的值减小，
//这种方法在有的时候是不对的，
//比如对于{"11", "01", "10"}，m=2，n=2这个例子，
//我们将遍历完“11”的时候，把1用完了，那么对于后面两个字符串就没法处理了，
//而其实正确的答案是应该组成后面两个字符串才对。
//所以我们需要建立一个DP数组，其中dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数，
//而对于当前遍历到的字符串，我们统计出其中0和1的个数为zeros和ones，
//dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);



//感觉这道题是01背包啊 在满足0的个数 1的个数的weight的情况下 使个数最多
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
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
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
