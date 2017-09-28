package dynamicProgramming;

import java.util.Arrays;
//因为这道题是求个数  所以对于可以重复(Permutation)和不可以重复(Combination)来说 个数都是一样的 
//所以根据CombinationSum4_377(Permutation)和CoinChange2_518(Combination)做出来的答案是一样的

public class CoinChange_322 {
	// 以前的答案 根据CombinationSum4_377来的
	// top答案也都是这种
	public int coinChange(int[] coins, int amount) {
		int[] res = new int[amount + 1];
		for (int i = 1; i <= amount; i++)
			res[i] = -1;

		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins)
				if (i >= coin && res[i - coin] != -1) {
					res[i] = Math.min(res[i - coin] + 1, min);
					min = res[i];
				}
		}
		return res[amount];
	}

	// 做了CoinChange2_518之后的 完全背包答案
	// dp[i][j] 表示 使用前i个coin 来组成 amount j 需要的最少coin个数
	// 方程为dp[i][j] =min(1 + dp[i][j - w[i]], dp[i-1][j])

	// 但是这里注意可能 使用前i个coin 并不能组成 amount j
	// 所以我们这里用dp[i][j]= Integer.MAX_VALUE-1来表明 不存在
	// 初始条件为
	// dp[0][j]= Integer.MAX_VALUE-1; j从1到amount 就是说 当没有coin 无法组成 amount
	// 但是 dp[0][0]=0;即 0个coin 组成amount为0 需要的最少coin个数为0
	// 二维的数组可以变为
	// dp[j] =min(1 + dp[j - w[i]], dp[j])
	public int coinChange2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
			}
		}
		return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];

	}
}
