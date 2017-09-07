package dynamicProgramming;

import java.util.HashSet;
import java.util.List;

public class WordBreak_139 {
	// 第一版答案自己做出来的哦 但是很慢
	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		for (int len = 0; len < n; len++) {
			for (int i = 0; i + len < n; i++) {
				int j = i + len;
				dp[i][j] = set.contains(s.substring(i, j + 1));
				if (j == i) {
					continue;
				}
				for (int k = i; k <= j - 1; k++) {
					dp[i][j] = dp[i][j] || (dp[i][k] && dp[k + 1][j]);
					if (dp[i][j])
						break;
				}
			}
		}
		return dp[0][n - 1];
	}

	// top答案
	public boolean wordBreak2(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[n];
	}
}
