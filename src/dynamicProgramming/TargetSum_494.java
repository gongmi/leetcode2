package dynamicProgramming;

//第一种方法 backTracking 但是很慢 
//这道题不需要输出每种具体情况 只需要一个数 说明是用dp
public class TargetSum_494 {
	int res = 0;

	public int findTargetSumWays(int[] nums, int S) {
		helper(nums, 0, S);
		return res;
	}

	private void helper(int[] nums, int k, int S) {
		if (k == nums.length) {
			if (S == 0)
				res++;
			return;
		}
		helper(nums, k + 1, S + nums[k]);
		helper(nums, k + 1, S - nums[k]);
	}

	// 01 背包 首先转化为一个 从数组中选若干个数 和为target 有几种方法
	// 与CoinChange2_518相似
	// 但是CoinChange2_518是完全背包 即每个数可以使用多次
	// 与PartitionEqualSubsetSum_416相似
	// 但是PartitionEqualSubsetSum_416是求是否可能 这个是求数量
	// dp[i][j] = dp[i-1][j]+dp[i-1][j - w[i]]
	public int findTargetSumWays2(int[] nums, int S) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < S)
			return 0;
		int target = (sum + S);
		if ((target & 1) == 1)
			return 0;
		target /= 2;

		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int j = target; j >= num; j--)
				dp[j] += dp[j - num];
		}
		return dp[target];
	}
}
