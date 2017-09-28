package dynamicProgramming;

public class PartitionEqualSubsetSum_416 {
	// 即dp[i][j]表示前i个数是否可能得到weight为j
	// 在这里 value和weight 其实就是nums的值
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		int weight = sum;
		boolean[][] dp = new boolean[nums.length + 1][weight + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= weight; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[nums.length][weight];
	}

	// 把二维的dp数组优化为了一维的
	// 但是第二个循环必须从大到小
	// 因为有dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];

	// 那么 当i-1 时 我算了 dp[i-1][j] j从0 到len
	// 当i循环到i 时 这两个公式等价
	// dp[j] = dp[j] || dp[j - nums[i]]
	// dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]

	// 也就是说 dp[j]与 dp[j - nums[i]] 都是之前i-1时算出来的dp
	// 但是如果我从小到大去遍历j那么 dp[j - nums[i]] 就是我刚刚算的小的j
	// 即 dp[i][j] = dp[i - 1][j] || dp[i][j - nums[i]]
	// 这样就不对了
	public boolean canPartition2(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;

		for (int num : nums) {
			// 从大到小
			for (int j = sum; j >= num; j--) {
				dp[j] = dp[j] || dp[j - num];
				if (dp[sum])
					return true;
			}

		}
		return false;
	}
}
