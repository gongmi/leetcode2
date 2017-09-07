package dynamicProgramming;

import java.util.Arrays;

public class PerfectSquares_279 {
	// 第一版答案很慢
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		// 刚开始的想法是看当前这个i 可能是哪两段加起来的最小
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
		}
		return dp[n];

	}

	// 第2版答案
	public int numSquares2(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			// 现在是看 每次都加上一个平方数
			for (int j = 1; j * j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];

	}
}
