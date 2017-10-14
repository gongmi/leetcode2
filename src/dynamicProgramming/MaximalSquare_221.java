package dynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

public class MaximalSquare_221 {
	// �� MaximalRectangle_85�ĵ�һ�ֽⷨ���� ֻ��Ҫ����һ���������� ��Ȼ�ⲻ�� ���ѧ������
	// top��
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				} else
					dp[i][j] = 0;
			}
		}
		return max * max;
	}

	// ���Խ�ά
	// ����dp[i][j] Ҫ�õ�dp[i - 1][j - 1]
	// ���ڼ���dp[i][j-1]ʱ dp[i - 1][j - 1]�ᱻ����
	// ������һ��pre������dp[i - 1][j - 1]
	public int maximalSquare2(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] dp = new int[n + 1];
		int max = 0;
		int preLeftTop = 0;
		for (int i = 1; i <= m; i++) {
			preLeftTop = 0;
			for (int j = 1; j <= n; j++) {
				int temp = dp[j];
				if (matrix[i - 1][j - 1] == '1') {
					dp[j] = Math.min(preLeftTop, Math.min(dp[j], dp[j - 1])) + 1;
					max = Math.max(max, dp[j]);
				} else
					dp[j] = 0;
				preLeftTop = temp;
			}
		}
		return max * max;
	}
}
