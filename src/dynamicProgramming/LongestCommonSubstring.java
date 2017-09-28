package dynamicProgramming;

//最长公共子串是：
//dp[i][j]表示以str1[i]和str2[j]为结尾的最长公共子串 

//当str1[i] == str2[j]时 dp[i][j] = dp[i-1][j-1] + 1;
//否则，dp[i][j] = 0;

//最优解为max(dp[i][j]),其中0<=i<len1, 0<=j<len2;
public class LongestCommonSubstring {

	public int getCommonLength(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (max < dp[i][j])
					max = dp[i][j];
			}
		}

		return max;

	}
}
