package dynamicProgramming;
//这是经典的动态规划思路 前提是如何想到通式！！

//与算法导论的 最长公共子序列相似 Longest Common Subsequence

public class PalindromicSubsequenceLongest_516 {

	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		if (len <= 1)
			return len;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++)
			dp[i][i] = 1;
		for (int i = len - 2; i >= 0; i--)
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i + 1][j - 1] + 2;
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
			}
		return dp[0][len - 1];

	}

	// 2017.07的答案 思想是一样的 为什么时间比上面的慢
	// 因为循环的方向不一样 我这个是外层是长度 内层是left
	// 上面那个是外层是left 内层是长度
	public int longestPalindromeSubseq2(String s) {
		int len = s.length();

		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = 1;
		}
		int j = 0;
		for (int l = 1; l < len; l++) {
			for (int i = 0; i + l < len; i++) {
				j = i + l;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		return dp[0][len - 1];

	}
}
