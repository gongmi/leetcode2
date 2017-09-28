package dynamicProgramming;

//最长公共子序列是：
//dp[i][j] 表示子串str1[0...i]和子串str[0...j]的最长公共子序列

//当str1[i] == str2[j]时，dp[i][j] = dp[i-1][j-1] + 1;
//否则，dp[i][j] = max(dp[i-1][j], dp[i][j-1]);

//最优解为dp[len1-1][len2-1];
public class LongestCommonSubsequence {

	public int getCommonLength(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 区别在这儿
				}
			}
		}

		return dp[len1][len2];
	}
}
