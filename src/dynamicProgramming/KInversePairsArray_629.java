package dynamicProgramming;

//设f(n,k)表示n个数的排列中逆序数个数为k的排列数。
//最大的数n可能会排在第n-i位，从而产生i个与n有关的逆序对，去掉n之后，剩下的n-1个数的排列有k-i个逆序对。所以，f(n,k)=求和(f(n-1，k-i))(0<=i<n)。
//同理有f(n,k-1)=求和(f(n-1，k-1-i))(0<=i<n)。
//两式相减，可得f(n,k)-f(n,k-1)=f(n-1,k)-f(n-1,k-n)。
//递推公式为f(n,k)=f(n,k-1)+f(n-1,k)-f(n-1,k-n)。
//然后动态规划可得。
public class KInversePairsArray_629 {
	int mod = 1000000007;

	public int kInversePairs(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i * (i - 1) / 2 && j <= k; j++) {
				int tmp1 = 0, tmp2 = 0, tmp3 = 0;
				tmp1 = dp[i - 1][j];
				tmp2 = dp[i][j - 1];
				if (j - i >= 0)
					tmp3 = dp[i - 1][j - i];
				dp[i][j] = ((tmp1 + tmp2 - tmp3) % mod + mod) % mod;
			}
		}
		return dp[n][k];
	}
}
