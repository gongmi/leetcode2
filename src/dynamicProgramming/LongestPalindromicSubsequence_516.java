package dynamicProgramming;
//���Ǿ���Ķ�̬�滮˼· ǰ��������뵽ͨʽ����
//���㷨���۵� ��������������� Longest Common Subsequence

public class LongestPalindromicSubsequence_516 {

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
}
