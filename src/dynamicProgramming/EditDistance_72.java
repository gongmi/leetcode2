package dynamicProgramming;

public class EditDistance_72 {
	// 一开始我以为是最长公共子序列相似 Longest Common Subsequence
	// 但是这样无法解决ab 与bc的问题
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

		int L = dp[m][n];
		return Math.max(m, n) - L;
	}
//其实思想是一样的 只不过dp中存放的不应该是上面的len 而是steps
	public int minDistance2(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] cost = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			cost[i][0] = i;
		for (int i = 1; i <= n; i++)
			cost[0][i] = i;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (word1.charAt(i) == word2.charAt(j))
					cost[i + 1][j + 1] = cost[i][j];
				else {
					int a = cost[i][j];
					int b = cost[i][j + 1];
					int c = cost[i + 1][j];
					cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
					cost[i + 1][j + 1]++;
				}
			}
		}
		return cost[m][n];
	}
}
