package dynamicProgramming;

//http://www.cnblogs.com/xhp956614463/p/3869698.html
//若原来是i-1个数 j个小于号 那么当我把i这个数加在小于号或者最前面时 小于号的个数保持不变
//一共有j+1个位置

//若原来是i-1个数 j-1个小于号 那么当我把i这个数加在大于号或者最后面时 小于号的个数会多一个
//一共有（i-2）-（j-1）+1=i-j个位置
public class Permutation {
	public int validPermutation(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= k; j++)
				dp[i][j] = dp[i - 1][j] * (j + 1) + dp[i - 1][j - 1] * (i - j);
		return dp[n][k];
	}
}
