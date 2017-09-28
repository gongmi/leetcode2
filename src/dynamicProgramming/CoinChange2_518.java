package dynamicProgramming;

//这道题和CombinationSum4_377相似
//只是CombinationSum4_377 是可以有重复的(Permutation) 只要顺序不一样
//但是这个是去重的 也就是 (Combination)
//这是一个完全背包问题
//方程为dp[i][j] = dp[i-1][j]+dp[i][j - w[i]]
//dp[i][j] 表示 使用前i个coin  来组成 amount j 有多少种方式
//可以变为dp[j] = dp[j] + dp[j - w[i]]; 并且j从小到大
//仔细观察这道题与CombinationSum4_377的不同之处 可以发现 区别在于
//两个for循环的位置
//仔细考虑 仿佛可以明白这其中的真理
public class CoinChange2_518 {
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int j = coin; j <= amount; j++) {
				dp[j] = dp[j] + dp[j - coin];
			}
		}
		return dp[amount];

	}
}
