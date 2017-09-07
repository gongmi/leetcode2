package dynamicProgramming;

import java.util.Arrays;

public class PerfectSquares_279 {
	// ��һ��𰸺���
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		// �տ�ʼ���뷨�ǿ���ǰ���i �����������μ���������С
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
			}
		}
		return dp[n];

	}

	// ��2���
	public int numSquares2(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			// �����ǿ� ÿ�ζ�����һ��ƽ����
			for (int j = 1; j * j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];

	}
}
