package dynamicProgramming;

public class PartitionEqualSubsetSum_416 {
	// http://www.cnblogs.com/shinning/p/6027743.html
	// 01背包问题
	// 本题与0-1背包问题类似。用数组dp[i][j]来表示体积不超过j时的前i个元素的最大和。
	// 可得出递推公式为
	// dp[i][j] = Math.max(dp[i - 1][j - nums[i]] + nums[i], dp[i -1][j]),
	// 其中j >= nums[i].当dp[i][sum] = sum，即背包装满时，则返回true。
	
//	仔细分析发现，在本题情况中，每次循环dp[i][j]只与上一层循环得到的dp[i -1][x]有关，
//	故只需要一维数组，每次更新数组值即可。
//	具体代码如下。注意第二层循环中j要从大到小遍历，
//	原因是在更新数组的过程中避免使用到当次更新的数组元素。
	public class Solution {
		public boolean canPartition(int[] nums) {
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
