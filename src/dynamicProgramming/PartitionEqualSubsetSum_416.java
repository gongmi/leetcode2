package dynamicProgramming;

public class PartitionEqualSubsetSum_416 {

	public class Solution {
		public boolean canPartition(int[] nums) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			if (sum % 2 != 0)
				return false;
			sum /= 2;
			int length = nums.length;
			int weight = sum;
			int[][] c = new int[length + 1][weight + 1];

			for (int i = 1; i < length; i++) {
				for (int k = 1; k <= weight; k++) {
					if (nums[i] <= k) {
						c[i][k] = Math.max(v[i] + c[i - 1][k - w[i]], c[i - 1][k]);
					} else
						c[i][k] = c[i - 1][k];
				}
			}
			return c[length][weight];
		}

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

			for (int i = 0; i < nums.length; i++) {
				
				for (int j = sum; j >= nums[i]; j--) {
					dp[j] = dp[j] || dp[j - nums[i]];
					if (dp[sum])
						return true;
				}
				
			}
			return false;
		}
	}
}
