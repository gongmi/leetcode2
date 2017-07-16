package dynamicProgramming;

import java.util.Arrays;

//n����n������ k����С�ںŵĸ���
//��ԭ����i-1���� j��С�ں� ��ô���Ұ�i���������С�ںŻ�����ǰ��ʱ С�ںŵĸ������ֲ���
//һ����j+1��λ��

//��ԭ����i-1���� j-1��С�ں� ��ô���Ұ�i��������ڴ��ںŻ��������ʱ С�ںŵĸ������һ��
//һ���У�i-2��-��j-1��+1=i-j��λ��
public class Permutation1 {
	public int validPermutation(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++)
				dp[i][j] = dp[i - 1][j] * (j + 1) + dp[i - 1][j - 1] * (i - j);

		for (int[] a : dp)
			System.out.println(Arrays.toString(a));
		return dp[n][k];
	}

}